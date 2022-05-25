package com.codingdojo.lino.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.lino.models.Algorithm;
import com.codingdojo.lino.models.Answer;
import com.codingdojo.lino.models.LoginUser;
import com.codingdojo.lino.models.User;
import com.codingdojo.lino.models.Video;
import com.codingdojo.lino.repositories.AlgorithmRepository;
import com.codingdojo.lino.repositories.AnswerRepository;
import com.codingdojo.lino.repositories.UserRepository;
import com.codingdojo.lino.repositories.VideoRepository;

@Service
public class AppService {

	@Autowired
	private UserRepository repositorio_user;
	
	@Autowired
	private AlgorithmRepository repositorio_algorithm;
	
	@Autowired
	private AnswerRepository repositorio_answer;
	
	@Autowired
	private VideoRepository repositorio_video;
	
	public User register(User nuevoUsuario, BindingResult result) {
		
		String nuevoEmail = nuevoUsuario.getEmail();
		
		//Revisamos si existe el correo electrónico en BD
		if(repositorio_user.findByEmail(nuevoEmail).isPresent()) {
			result.rejectValue("email", "Unique", "Email already registered.");
		}
		
		if(!nuevoUsuario.getPassword().equals(nuevoUsuario.getConfirm()) ) {
			result.rejectValue("confirm", "Matches", "Wrong Password.");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			//Encriptamos contraseña
			String contra_encr = BCrypt.hashpw(nuevoUsuario.getPassword(), BCrypt.gensalt());
			nuevoUsuario.setPassword(contra_encr);
			//Guardo usuario
			return repositorio_user.save(nuevoUsuario);
		}
		
	}
	
	public User login(LoginUser nuevoLogin, BindingResult result) {
		
		if(result.hasErrors()) {
			return null;
		}
		
		//Buscamos por correo
		Optional<User> posibleUsuario = repositorio_user.findByEmail(nuevoLogin.getEmail());
		if(!posibleUsuario.isPresent()) {
			result.rejectValue("email", "Unique", "Correo ingresado no existe");
			return null;
		}
		
		
		User user_login = posibleUsuario.get();
		
		//Comparamos contraseñas encriptadas
		if(! BCrypt.checkpw(nuevoLogin.getPassword(), user_login.getPassword())) {
			result.rejectValue("password", "Matches", "Contraseña inválida");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			return user_login; 
		}		
	}
	
	//Save User
	public User save_user(User updatedUser) {
		return repositorio_user.save(updatedUser);
	}
	
	
	public User find_user(Long id) {
		Optional<User> optionalUser = repositorio_user.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	//Save an Algorithm
	public Algorithm save_algorithm(Algorithm thisAlgorithm) {
		return repositorio_algorithm.save(thisAlgorithm);
	}
	
	//Save an Answer
	public Answer save_answer(Answer thisAnswer) {
		return repositorio_answer.save(thisAnswer);
	}
		
	//Save a Video
	public Video save_video(Video thisVideo) {
		return repositorio_video.save(thisVideo);
	}
	
	//Find Algorithm by id
	public Algorithm find_algo(Long id) {
        Optional<Algorithm> optionalAlgo = repositorio_algorithm.findById(id);
        if(optionalAlgo.isPresent()) {
            return optionalAlgo.get();
        } else {
            return null;
        }
    }
	
	//Find Answer by id
	public Answer find_answer(Long id) {
	        Optional<Answer> optionalAns = repositorio_answer.findById(id);
	        if(optionalAns.isPresent()) {
	            return optionalAns.get();
	        } else {
	            return null;
	        }
	}
	
	
	//Add Answer to an algorithm
	public void save_answer_algo(Long algo_id, Long answer_id) {
		Algorithm myAlgo = find_algo(algo_id);
		Answer myAns = find_answer(answer_id);
		
		myAlgo.getTheAnswers().add(myAns);
		
		repositorio_algorithm.save(myAlgo);	
	}
	
	//Add Video to an algorithm
	public void save_video_algo(Long algo_id, Long answer_id) {
		Algorithm myAlgo = find_algo(algo_id);
		Answer myAns = find_answer(answer_id);
		
		myAlgo.getTheAnswers().add(myAns);
		
		repositorio_algorithm.save(myAlgo);	
	}
	
	//Get all algorithms
	public List<Algorithm> allAlgorithms(){
		return repositorio_algorithm.findAll();
	}
}

