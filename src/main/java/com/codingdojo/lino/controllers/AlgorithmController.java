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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.lino.models.Algorithm;
import com.codingdojo.lino.models.Answer;
import com.codingdojo.lino.models.Type;
import com.codingdojo.lino.models.User;
import com.codingdojo.lino.models.Video;
import com.codingdojo.lino.services.AppService;

@Controller
@RequestMapping("/algorithms")
public class AlgorithmController {

	@Autowired
	private AppService servicio;
	
	//New Algorithm
	@PostMapping("/create")
	public String create_algorithm(@Valid @ModelAttribute("algorithm")Algorithm algorithm,
							   BindingResult result, Model model, HttpSession session) {
		/*check session exists*/
		User currentUser = (User)session.getAttribute("user_session");
		if(currentUser == null) {
			return "redirect:/";
		}
		
		
		if(result.hasErrors()) {
			
			User myUser = servicio.find_user(currentUser.getId());
			//Send types of class Type
			model.addAttribute("types", Type.Types);
			model.addAttribute("user", myUser);
			
			return "new.jsp";
		}
		
		Algorithm newalgo= servicio.save_algorithm(algorithm);
		Long algo_id = newalgo.getId();
		return "redirect:/algorithms/answers/"+algo_id;
	}
	

	//Second part of the form
	@GetMapping("/answers/{id_algo}")
	public String form_answer(@PathVariable("id_algo") Long id_algo,
			@ModelAttribute("answer") Answer answer, HttpSession session, 
			@ModelAttribute("video") Video video, 
			Model model) {
		/*check session exists*/
		User currentUser = (User)session.getAttribute("user_session");
		if(currentUser == null) {
			
			return "redirect:/";
		}
		
		
		Algorithm algo_edit = servicio.find_algo(id_algo);
		model.addAttribute("algorithm", algo_edit.getId());
		session.setAttribute("algo_id", id_algo);
		
		return "answer.jsp";
		
	}

	//Add answer to the algorithm
	@PostMapping("/answer")
	public String addAnswer(@Valid @ModelAttribute("answer") Answer answer,
							   BindingResult result, Model model, 
							   HttpSession session) {
		
		/*check session exists*/
		User currentUser = (User)session.getAttribute("user_session");
		if(currentUser == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			model.addAttribute("video", new Video());
			return "answer.jsp";
		
		}
		
		servicio.save_answer(answer);
	
		return "redirect:/algorithms/answers/"+session.getAttribute("algo_id");
	}
	
	
	
	//Add video to the algorithm
	@PostMapping("/video")
	public String addVideo (@Valid @ModelAttribute("video") Video video,
								   BindingResult result, Model model, 
								   HttpSession session) {
		/*check session exists*/
		User currentUser = (User)session.getAttribute("user_session");
		if(currentUser == null) {
				return "redirect:/";
			}
			
		if(result.hasErrors()) {
			model.addAttribute("answer", new Answer());
			return "answer.jsp";
		}
			
			
		servicio.save_video(video);
			
		return "redirect:/algorithms/answers/"+session.getAttribute("algo_id");
		}
	
	
	//Go to every code challenge
	@GetMapping("/{algo_id}")
	public String show_challenge(@PathVariable("algo_id") Long algo_id, 
			HttpSession session, Model model) {
		
		/*check if session exists*/
		User currentUser = (User)session.getAttribute("user_session");
		if(currentUser == null) {
			return "redirect:/";
		}
		
		Algorithm algo = servicio.find_algo(algo_id);
		List<Video> videos = algo.getTheVideos();
		model.addAttribute("algo", algo);
		model.addAttribute("videos", videos);
		return "show.jsp";
	}
	
	
	
	
}