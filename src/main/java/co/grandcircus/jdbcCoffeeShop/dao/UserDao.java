package co.grandcircus.jdbcCoffeeShop.dao;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.jdbcCoffeeShop.entity.User;


@Repository

@Transactional
public class UserDao {
	
	@PersistenceContext
    EntityManager em;

	public void register(User user) {
		em.persist(user);
	}//end register
	
}//end class
