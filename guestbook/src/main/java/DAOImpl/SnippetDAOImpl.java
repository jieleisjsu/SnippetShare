package DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import DAO.SnippetDAO;
import Entity.Snippet;
import RowMapper.SnippetRowMapper;

public class SnippetDAOImpl implements SnippetDAO {
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public boolean insert(Snippet snippet) {
		String sql = "INSERT IGNORE INTO SNIPPET "
				+ "(title, tags, content, boardID, owner)"
				+ "VALUES (?, ?, ?, ?, ?)";
	int rowAffected = jdbcTemplate.update(sql, 
		new Object[]{snippet.getTitle(), snippet.getTags(), snippet.getContent(),
			snippet.getBoardID(), snippet.getOwner()});
		return rowAffected == 1;
	}
	@Override
	public List<Snippet> findByBoard(int boardID) {
		String sql = "SELECT * FROM SNIPPET WHERE boardID = ?";
		List<Snippet> snippets = jdbcTemplate.query(
					sql, new Object[] {boardID}, new SnippetRowMapper());
		if(snippets == null) return new ArrayList<Snippet>();
		return snippets;
	}
	@Override
	public boolean deleteByID(int id) {
		String sql = "DELETE FROM SNIPPET "
				+ "WHERE id = ?";
		int rowAffected = jdbcTemplate.update(sql, 
				new Object[]{id});
		return rowAffected == 1;
	}
	@Override
	public boolean update(int id, Snippet snippet) {
		String sql = "UPDATE SNIPPET "
				+ "SET title = ?, tags = ?, content = ? "
				+ "WHERE id = ?";
		int rowAffected = jdbcTemplate.update(sql, 
				new Object[]{snippet.getTitle(), snippet.getTags(), snippet.getContent(), id});
		return rowAffected == 1;
	}
	@Override
	public Snippet findByID(int id) {
		String sql = "SELECT * FROM SNIPPET WHERE id = ?";
		Snippet snippet = new Snippet();
		snippet = (Snippet) jdbcTemplate.queryForObject(
					sql, new Object[] { id }, new SnippetRowMapper());
		return snippet;
	}
	@Override
	public List<Snippet> findByUsername(String username) {
		String sql = "SELECT * FROM SNIPPET WHERE owner = ?";
		List<Snippet> snippets = jdbcTemplate.query(
					sql, new Object[] {username}, new SnippetRowMapper());
		if(snippets == null) return new ArrayList<Snippet>();
		return snippets;
	}
	
	

}
