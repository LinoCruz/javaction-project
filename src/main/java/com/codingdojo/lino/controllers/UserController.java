package com.codingdojo.lino.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.lino.models.Algorithm;
import com.codingdojo.lino.models.LoginUser;
import com.codingdojo.lino.models.Type;
import com.codingdojo.lino.models.User;
import com.codingdojo.lino.services.AppService;

@Controller
public class UserController {

	@Autowired
	private AppService servicio;
	
	//Landing Page
	@GetMapping("/")
	public String index(@ModelAttribute("nuevoUsuario") User nuevoUsuario,
						@ModelAttribute("nuevoLogin") LoginUser nuevoLogin) {
		/*model.addAttribute("nuevoUsuario", new User());
		model.addAttribute("nuevoLogin", new LoginUser());*/
		
		return "index.jsp";
	}
	
	//Add new User
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("nuevoUsuario") User nuevoUsuario,
						   BindingResult result, Model model, HttpSession session) {
		
		servicio.register(nuevoUsuario, result);
		if(result.hasErrors()) {
			model.addAttribute("nuevoLogin", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("user_session", nuevoUsuario);
		return "redirect:/dashboard";
		
	}
	
	//Log in a user
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("nuevoLogin") LoginUser nuevoLogin,
						BindingResult result, Model model, HttpSession session) {
							
		User user = servicio.login(nuevoLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("nuevoUsuario", new User());
			return "index.jsp";
		}
		
		if(user.getLevel() == 2) {
			session.setAttribute("user_session", user);
			return "redirect:/admin";
		}
		
		
		session.setAttribute("user_session", user);
		return "redirect:/dashboard";
							
	}
	
	
	//Admin create algorithms dashboard
	@GetMapping("/admin")
	public String new_project(@ModelAttribute("algorithm") Algorithm algorithm, 
			HttpSession session, Model model) {
		/*check if session exists*/
		User currentUser = (User)session.getAttribute("user_session");
		
		if(currentUser == null) {
			return "redirect:/";
		}
		
		model.addAttribute("types", Type.Types);
		return "new.jsp";
		
	}
	
	
	//Main dashboard for all users
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		
		/*check if session exists*/
		User currentUser = (User)session.getAttribute("user_session");
		
		if(currentUser == null) {
			return "redirect:/";
		}
		
		List <Algorithm> allAlgos = servicio.allAlgorithms();
		
		model.addAttribute("algorithms", allAlgos);

		return "dashboard.jsp";
	}
	
	//Close Session
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_session");
		return "redirect:/";
	}
	
}
