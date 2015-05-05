package DAOImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import DAO.BoardDAO;
import Entity.Board;
import RowMapper.BoardRowMapper;

public class BoardDAOImpl implements BoardDAO {
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public boolean insert(Board board) {
		String sql = "INSERT IGNORE INTO BOARD "
				+ "(title, category, access, username)"
				+ "VALUES (?, ?, ?, ?)";
	int rowAffected = jdbcTemplate.update(sql, 
		new Object[]{board.getTitle(), board.getCategory(), board.getAccess(), board.getUsername()});
		return rowAffected == 1;
	}
	@Override
	public List<Board> findOwnBoard(String username) {
		String sql = "SELECT * FROM BOARD where username = ?"; 
		List<Board> boards = jdbcTemplate.query(sql, new Object[]{username}, new BoardRowMapper()); 
		if(boards == null) return new ArrayList<Board>();
		return boards;
	}
	@Override
	public List<Board> findPublicBoard() {
		String sql = "SELECT * FROM BOARD where access = ?"; 
		List<Board> boards = jdbcTemplate.query(sql, new Object[]{"public"}, new BoardRowMapper()); 
		if(boards == null) return new ArrayList<Board>();
		return boards;
	}
	@Override
	public List<Board> findPrivate(String username) {
		String sql = "SELECT * FROM BOARD where id in "
				+ "(SELECT boardID as id FROM ACCESS where username = ?)"; 
		List<Board> boards = jdbcTemplate.query(sql, new Object[]{username}, new BoardRowMapper()); 
		if(boards == null) return new ArrayList<Board>();
		return boards;
	}
	@Override
	public List<Board> findUnavailable(String username) {
		String sql = "SELECT * FROM BOARD where access = 'private' and id not in "
				+ "(SELECT boardID as id FROM ACCESS where username = ?)"; 
		List<Board> boards = jdbcTemplate.query(sql, new Object[]{username}, new BoardRowMapper()); 
		if(boards == null) return new ArrayList<Board>();
		return boards;
	}
	@Override
	public Set<Integer> findAllAvailbleBoardID(String username) {
		List<Board> allBoard = new ArrayList<Board>();
		allBoard.addAll(findPublicBoard());
		allBoard.addAll(findOwnBoard(username));
		allBoard.addAll(findPrivate(username));
		Set<Integer> res = new HashSet<Integer>();
		for(Board board : allBoard) res.add(board.getId());
		return res;
	}
	@Override
	public Board findByID(int id) {
		String sql = "SELECT * FROM BOARD WHERE id = ?";
		Board board = new Board();
		board = (Board) jdbcTemplate.queryForObject(
					sql, new Object[] { id }, new BoardRowMapper());
		return board;
	}

}
