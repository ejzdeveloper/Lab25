package co.grandcircus.jdbcCoffeShop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.jdbcCoffeeShop.entity.User;


@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbc;

	public void register(User user) {
		String sql = "INSERT INTO user (username, password, firstname, lastname) VALUES (?, ?, ?, ?)";
		jdbc.update(sql, user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName());
	}
	
	
	
}//end class
