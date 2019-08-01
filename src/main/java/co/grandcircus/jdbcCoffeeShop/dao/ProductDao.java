package co.grandcircus.jdbcCoffeeShop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import co.grandcircus.jdbcCoffeeShop.entity.Product;


@Repository

@Transactional
public class ProductDao {

	@PersistenceContext
    EntityManager em;

	public List<Product> findAll() {
		return em.createQuery("FROM Product", Product.class).getResultList();
	}//end findAll
	
	public Product findById(Long id) {
		return em.find(Product.class, id);
	}//end findById
	
	public void create(Product product) {
		em.persist(product);
	}//end create
	
	public void update(Product product) {
		em.merge(product);
	}//end update
	
	public void delete(Long id) {
		// Deleting with Hibernate entity manager requires fetching a reference first.
		Product product = em.getReference(Product.class, id);
		em.remove(product);
	}//end delete
}//end class



