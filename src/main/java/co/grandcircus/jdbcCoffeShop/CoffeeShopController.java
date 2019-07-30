package co.grandcircus.jdbcCoffeShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.jdbcCoffeShop.dao.ProductDao;
import co.grandcircus.jdbcCoffeShop.dao.UserDao;
import co.grandcircus.jdbcCoffeeShop.entity.Product;
import co.grandcircus.jdbcCoffeeShop.entity.User;




@Controller	
public class CoffeeShopController {
	
	@Autowired
	private ProductDao Pdao;
	@Autowired
	private UserDao Udao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("redirect:/index");
		
	}
	
	
	@RequestMapping("/index")
	public ModelAndView list() {
		List<Product> listOfProducts = Pdao.findAll();
		return new ModelAndView("index", "products",listOfProducts);
		
	}

	@RequestMapping("/register-form")
	public ModelAndView register() {		
		return new ModelAndView("register-form");
	}
	
	
	@PostMapping("/register-form")
	public ModelAndView addSubmit(User user) {
		Udao.register(user);
		return new ModelAndView("register-result");
	}
	
		
	@RequestMapping("/register-result")
	public ModelAndView showResult( 
		@RequestParam("firstName") String firstName) {
		  ModelAndView mv = new ModelAndView("register-result");
		  mv.addObject("firstName", firstName);
		  return mv;
	}
	
	
}//end classs
