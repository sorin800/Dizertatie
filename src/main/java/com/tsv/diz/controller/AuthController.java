package com.tsv.diz.controller;

import com.tsv.diz.model.Role;
import com.tsv.diz.model.SavedAd;
import com.tsv.diz.model.SearchHistory;
import com.tsv.diz.model.User;
import com.tsv.diz.repository.RoleRepository;
import com.tsv.diz.repository.SavedAdRepository;
import com.tsv.diz.repository.SearchHistoryRepository;
import com.tsv.diz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class AuthController {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private SavedAdRepository savedAdRepository;
	@Autowired
	private SearchHistoryRepository searchHistoryRepository;

	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("success", true);
		return "auth/register";
	}
	
	@GetMapping("/profile")
	public String profile(Principal principal, Model model) {

		if(principal!=null){
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<SavedAd> ads = savedAdRepository.findSavedAdsByUserId(user.getId());
			List<SearchHistory> searchHistoryList = searchHistoryRepository.findSearchHistoryAdsByUserId(user.getId());
			model.addAttribute("listaHistory", searchHistoryList);
			model.addAttribute("lista",ads);
		}

		return "auth/profile";
	}

	@PostMapping("/registerUser")
	public String register(@ModelAttribute("user") User user, Model model){

		Optional<User> userRetrieved = userRepository.findByEmail(user.getEmail());
		if(userRetrieved.isPresent()){

			model.addAttribute("success",false);
			return "auth/register";

		}else{
			Role userRole = new Role("ROLE_USER");
			roleRepository.save(userRole);

			user.setPassword(encoder.encode(user.getPassword()));
			user.addRole(userRole);
			user.setEnabled(true);
			userRepository.save(user);

			return "auth/login";
		}


	}
}
