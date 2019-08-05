package co.grandcircus.hibernateCoffeeShop;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import co.grandcircus.hibernateCoffeeShop.dao.ProductDao;
import co.grandcircus.hibernateCoffeeShop.dao.UserRepository;
import co.grandcircus.hibernateCoffeeShop.entity.Product;
import co.grandcircus.hibernateCoffeeShop.entity.User;

@Controller	
public class CoffeeShopController {

	@Autowired
	private ProductDao Pdao;

	@Autowired
	private UserRepository userRepo;

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

	// path variable required to identify which product we're editing
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
	public ModelAndView register() {	
		return new ModelAndView("register-form");
	}

	@PostMapping("/register-form")
	public ModelAndView addSubmit(User user, HttpSession session) {
		userRepo.save(user);
		session.setAttribute("user", user);
		return new ModelAndView("register-result");
	}	


	@RequestMapping("/login-form")
	public ModelAndView showLogin() {
		return new ModelAndView("login-form");
	}

	@PostMapping("/login-form")
	public ModelAndView submitLogin(
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpSession session) {
		// check the database for the user that matches both username and password
		User user = userRepo.findByUsernameAndPassword(username, password);
		// if not found, show the form again with error message
		if (user == null) {
			return new ModelAndView("login-form", "message", "Incorrect username or password.");
		}
		// "login" just means adding the user to the session
		session.setAttribute("user", user);
		return new ModelAndView("redirect:/");
	}

	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		// This clears the session and starts a brand new clean one.
		session.invalidate();
		return new ModelAndView("redirect:/");
	}


}//end classs
