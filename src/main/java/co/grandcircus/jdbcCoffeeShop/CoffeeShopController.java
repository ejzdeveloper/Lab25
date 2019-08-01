package co.grandcircus.jdbcCoffeeShop;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.jdbcCoffeeShop.dao.ProductDao;
import co.grandcircus.jdbcCoffeeShop.dao.UserDao;
import co.grandcircus.jdbcCoffeeShop.entity.Product;
import co.grandcircus.jdbcCoffeeShop.entity.User;

@Controller	
public class CoffeeShopController {
	
	@Autowired
	private ProductDao Pdao;
	
	@Autowired
	private UserDao Udao;
	
	//show list in index
	@RequestMapping("/")
    public ModelAndView list() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("products", Pdao.findAll());
        return mv;
    }//end list
	
	//show list in admin
		@RequestMapping("/admin")
	    public ModelAndView adminList() {
	        ModelAndView mv = new ModelAndView("admin");
	        mv.addObject("products", Pdao.findAll());
	        return mv;
	    }//end adminList
	
	//show add coffee form
	@RequestMapping("/addCoffee")
	public ModelAndView showCreateForm() {
		return new ModelAndView("addCoffee", "title", "Add a Coffee");
	}//end showCreateForm
	
	@PostMapping("/addCoffee")
	public ModelAndView submitCreateForm(Product product) {
		Pdao.create(product);
		return new ModelAndView("addCoffee", "title", "Add a Coffee");
	}
	
	// path variable required to identify which food we're editing
	@RequestMapping("/product/updateCoffee")
	public ModelAndView showEditForm(@RequestParam("id") Long id) {
		ModelAndView mav = new ModelAndView("addCoffee");
		mav.addObject("coffee",Pdao.findById(id));
		mav.addObject("title", "Edit Coffee");
		return mav;
	}
	
	// same URL but different method
	@PostMapping("/product/updateCoffee")
	public ModelAndView submitEditForm(Product product) {
		Pdao.update(product);
		return new ModelAndView("admin", "products", Pdao.findAll());
	}
	
	@RequestMapping("/product/delete")
	public ModelAndView delete(@RequestParam("id") Long id) {
		Pdao.delete(id);
		return new ModelAndView("admin", "products", Pdao.findAll());
	}//end delete
	
	@RequestMapping("/register-form")
	public ModelAndView register(User user, HttpSession session) {	
		session.setAttribute("user", user);
		return new ModelAndView("register-form");
	}
	
	@PostMapping("/register-form")
	public ModelAndView addSubmit(User user) {
		Udao.register(user);
		return new ModelAndView("register-result");
	}	
		
	@RequestMapping("/register-result")
	public ModelAndView showResult( 
			@SessionAttribute(name = "user", required = false) User user) {
		ModelAndView mv = new ModelAndView("register-results");
		mv.addObject("name", user.getFirstName());
		  return mv;
	}

	@RequestMapping("/session")
    public ModelAndView menu() {
        ModelAndView mv = new ModelAndView("session");
        mv.addObject("products", Pdao.findAll());
        return mv;
    }//end list
}//end classs
