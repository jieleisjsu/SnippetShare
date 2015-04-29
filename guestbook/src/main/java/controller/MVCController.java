package controller;

import java.io.IOException;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import DAO.*;
import Entity.*;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

@Controller
@RequestMapping("/*")
public class MVCController {
	private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private SnippetDAO snippetDAO;

	@Autowired
	private CommentDAO commentDAO;
	
	@RequestMapping(value="test", method= RequestMethod.GET)
	public String hello(HttpServletRequest req, Model model){
		model.addAttribute("userID", req.getRemoteUser());
		return "testAuthority";
	}
	
	@RequestMapping(value="user/test", method= RequestMethod.GET)
	public String helloUser(HttpServletRequest req, Model model){
		model.addAttribute("userID", req.getRemoteUser());
		return "testAuthority";
	}
	
	@RequestMapping(value="homepage", method= RequestMethod.GET)
	public String getHomepage() {
		return "homepage";
	}
	
	@RequestMapping(value="index", method= RequestMethod.GET)
	public String getIndex() {
		return "index";
	}
	
	
	
	@RequestMapping(value="signup", method= RequestMethod.POST)
	public String signnup(Model model, 
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("address") String address) {
		User user = (User) context.getBean("user");
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		user.setAddress(address);
		if(userDAO.insert(user)) return "index";
		else {
			model.addAttribute("errorMessage", "username already regiestred");
			return "signup";
		}
	}
	
	@RequestMapping(value="user/creatboard", method= RequestMethod.POST)
	public String creatBoard(Model model, HttpServletRequest req,
			@RequestParam("title") String title,
			@RequestParam("access") String access,
			@RequestParam("category") String category) {
		Board board = (Board) context.getBean("board");
		board.setTitle(title);
		board.setAccess(access);
		board.setCategory(category);
		board.setUsername(req.getRemoteUser());
		if(!(access.equals("public") || access.equals("private"))) {
			model.addAttribute("errorMessage", "invalid access value");
			return "error";
		}
		boardDAO.insert(board);
		return "redirect:getboards";
	}
	
	@RequestMapping(value="user/getboards", method= RequestMethod.GET)
	public String getBoard(Model model, HttpServletRequest req) {
		List<Board> ownList = boardDAO.findOwnBoard(req.getRemoteUser());
		model.addAttribute("ownList", ownList);
		model.addAttribute("count", ownList.get(0).getTitle());//for debug. to be deleted
		List<Board> pubList = boardDAO.findPublicBoard();
		model.addAttribute("pubList", pubList);
		List<Board> priList = boardDAO.findPrivate(req.getRemoteUser());
		
		model.addAttribute("priList", priList);
		return "pagelist";
	}
	
	@RequestMapping(value="user/getboardbyid", method= RequestMethod.GET)
	public String getBoardByID(Model model, HttpServletRequest req,
			@RequestParam("id") int id) {
		Board board = boardDAO.findByID(id);
		model.addAttribute("board", board);
		List<Snippet> snippetList = snippetDAO.findByBoard(id);
		model.addAttribute("snippets", snippetList.size());
		return "boardview";
	}
	
	@RequestMapping(value="user/deletesnippet", method= RequestMethod.POST)
	public String deleteSnippet(Model model, HttpServletRequest req,
			@RequestParam("id") int id) {
		Snippet snippet = snippetDAO.findByID(id);
		if(!snippet.getOwner().equals(req.getRemoteUser())){
			model.addAttribute("errorMessage", "you do not have access to this board");
			return "error";
		}
		else {
			int boardID = snippet.getBoardID();
			if(snippetDAO.deleteByID(id)) {
				return "redirect:getboardbyid?id=" + boardID;
			}
			else {
				model.addAttribute("errorMessage", "fail to delete the snippet");
				return "error";
			}
		}
	}
	
	@RequestMapping(value="user/updatesnippet", method= RequestMethod.POST)
	public String updateSnippet(Model model, HttpServletRequest req,
			@RequestParam("id") int id,
			@RequestParam("tags") String tags,
			@RequestParam("content") String content,
			@RequestParam("title") String title
			) {
		Snippet snippet = snippetDAO.findByID(id);
		if(!snippet.getOwner().equals(req.getRemoteUser())){
			model.addAttribute("errorMessage", "you do not have access to this board");
			return "error";
		}
		snippet = (Snippet) context.getBean("snippet");
		snippet.setTags(tags);
		snippet.setTitle(title);
		snippet.setContent(content);
		if(snippetDAO.update(id, snippet)) {
			return "redirect:getsnippetbyid?id=" + id;
		}
		else {
			model.addAttribute("errorMessage", "fail to update the snippet");
			return "error";
		}
	}
	
	@RequestMapping(value="user/getsnippetbyid", method= RequestMethod.GET)
	public String getSnippetByID(Model model, HttpServletRequest req,
			@RequestParam("id") int id) {
		Snippet snippet = snippetDAO.findByID(id);
		model.addAttribute("snippet", snippet);
		List<Comment> comments = commentDAO.findBySnippetID(id);
		model.addAttribute("comments", comments);
		return "snippetview";
	}
	
	@RequestMapping(value="user/creatsnippet", method= RequestMethod.POST)
	public String creatSnippet(Model model, HttpServletRequest req,
			@RequestParam("title") String title,
			@RequestParam("tags") String tags,
			@RequestParam("content") String content,
			@RequestParam("boardID") int boardID) {
		Set<Integer> availbleBoards = boardDAO.findAllAvailbleBoardID(req.getRemoteUser());
		if(!availbleBoards.contains(boardID)) {
			model.addAttribute("errorMessage", "you do not have access to this board");
			return "error";
		}
		Snippet snippet = (Snippet) context.getBean("snippet");
		snippet.setTitle(title);
		snippet.setTags(tags);
		snippet.setContent(content);
		snippet.setBoardID(boardID);
		snippet.setOwner(req.getRemoteUser());
		if(snippetDAO.insert(snippet)) {
			return "redirect:getboardbyid?id=" + boardID;
		}
		else {
			model.addAttribute("errorMessage", "cannot creat thie snippet");
			return "error";
		}
	}
	@RequestMapping(value="user/creatcomment", method= RequestMethod.POST)
	public String creatComment(Model model, HttpServletRequest req,
			@RequestParam("content") String content,
			@RequestParam("snippetid") int snippetID) {
		Set<Integer> availbleBoards = boardDAO.findAllAvailbleBoardID(req.getRemoteUser());
		Snippet snippet = snippetDAO.findByID(snippetID);
		int boardID = snippet.getBoardID();
		if(!availbleBoards.contains(boardID)) {
			model.addAttribute("errorMessage", "you do not have access to this board");
			return "error";
		}
		Comment comment = (Comment) context.getBean("comment");
		comment.setContent(content);
		comment.setSnippetID(snippetID);
		if(commentDAO.insert(comment)) return "redirect:getsnippetbyid?id=" + snippetID;
		else {
			model.addAttribute("errorMessage", "cannot creat thie comment");
			return "error";
		}
	}
}
