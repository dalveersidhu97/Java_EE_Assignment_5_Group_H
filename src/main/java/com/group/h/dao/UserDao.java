package com.group.h.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.group.h.beans.Login;
import com.group.h.beans.User;

public class UserDao {
	private JdbcTemplate template;
	public static final int USER_ALREADY_EXISTS = -4;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public User validateUser(Login l) {

		String sql = "select * from Login l inner join User u on u.userId=l.userId where l.username='" + l.getUsername() + "' and l.password='"
				+ l.getPassword() + "';";
		try {
			return template.query(sql, new ResultSetExtractor<User>() {

				public User extractData(ResultSet rs) throws SQLException, DataAccessException {
					
					User u = new User();

					rs.next();
					u.setUserId(rs.getInt("userId"));
					u.setName(rs.getString("name"));
					u.setPassword(rs.getString("password"));
					u.setEmail(rs.getString("email"));
					u.setRole(rs.getString("role"));
					return u;
				}
			});
		} catch (Exception  e) {
			e.printStackTrace();
			// null if there is any error
			return null;
		}
	}

}