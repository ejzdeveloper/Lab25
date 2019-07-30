package co.grandcircus.jdbcCoffeShop.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.grandcircus.jdbcCoffeeShop.entity.Product;


@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<Product> findAll() {
		String sql = "SELECT * FROM product";
		return jdbc.query(sql, new BeanPropertyRowMapper<>(Product.class));
	}


}//end class



