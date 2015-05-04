package DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import DAO.UserDAO;
import Entity.Comment;
import Entity.User;
import RowMapper.CommentRowMapper;
import RowMapper.UserRowMapper;

public class UserDAOImpl implements UserDAO {
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public boolean insert(User user) {
		String sql = "INSERT IGNORE INTO USER "
				+ "VALUES (?, ?, ?, ?, ?)";
	int rowAffected = jdbcTemplate.update(sql, 
		new Object[]{user.getUsername(), user.getPassword(),user.getAuthorities(),
			user.getName(), user.getAddress()});
		return rowAffected == 1;
	}
	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM USER"; 
		List<User> users = jdbcTemplate.query(sql, new UserRowMapper()); 
		if(users == null) return new ArrayList<User>();
		return users;
	}
	

}
