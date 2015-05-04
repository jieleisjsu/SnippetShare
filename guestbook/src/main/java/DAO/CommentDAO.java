package DAO;
import java.util.List;

import Entity.Comment;

public interface CommentDAO {
	public boolean insert(Comment comment);
	public List<Comment> findBySnippetID(int id);
	public List<Comment> findByUsername(String username);
}
