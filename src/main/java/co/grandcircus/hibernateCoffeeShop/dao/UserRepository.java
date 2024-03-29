package co.grandcircus.hibernateCoffeeShop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.hibernateCoffeeShop.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);
}
