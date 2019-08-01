
package com.tsv.diz.bootstrap;

import com.tsv.diz.model.Option;
import com.tsv.diz.model.Role;
import com.tsv.diz.model.User;
import com.tsv.diz.repository.OptionRepository;
import com.tsv.diz.repository.RoleRepository;
import com.tsv.diz.repository.UserRepository;
import com.tsv.diz.service.ScrapperAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class DatabaseLoader implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private OptionRepository optionRepository;		
	
	@Autowired
	private ScrapperAuto scrapperAuto;
	
	
	@Override
	public void run(String... args) throws Exception {
//		scrapperAuto.searchAuto("dacia","duster","", "", "", "", "");
		 addUsersAndRoles();
		
	}

	private void addUsersAndRoles() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String secret = "{bcrypt}" + encoder.encode("password");

		Role userRole = new Role("ROLE_USER");
		roleRepository.save(userRole);
		Role adminRole = new Role("ROLE_ADMIN");
		roleRepository.save(adminRole);

		User user1 = new User("test1@gmail.com", secret, true);
		user1.addRole(userRole);
		userRepository.save(user1);
		
		User user2 = new User("test2@gmail.com", secret, true);
		user2.addRole(userRole);
		userRepository.save(user2);
		
		User user3 = new User("test3@gmail.com", secret, true);
		user3.addRole(userRole);
		userRepository.save(user3);
		
		User user4 = new User("test4@gmail.com", secret, true);
		user4.addRole(userRole);
		userRepository.save(user4);
		
		User user5 = new User("test5@gmail.com", secret, true);
		user5.addRole(userRole);
		userRepository.save(user5);

		User user6 = new User("test6@gmail.com",secret, true);
		user6.addRole(userRole);
		userRepository.save(user6);
		
		User user7 = new User("test7@gmail.com",secret, true);
		user7.addRole(userRole);
		userRepository.save(user7);
		
		User user8 = new User("test8@gmail.com",secret, true);
		user8.addRole(userRole);
		userRepository.save(user8);
		
		User user9 = new User("test9@gmail.com",secret, true);
		user9.addRole(userRole);
		userRepository.save(user9);
		
		User user10 = new User("test10@gmail.com",secret, true);
		user10.addRole(userRole);
		userRepository.save(user10);
		
		//OPTIONS
		Option o1 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 1.5, user1);		
		optionRepository.save(o1);
		
		Option o2 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 1.3, user1);		
		optionRepository.save(o2);
		
		Option o3 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 2.2, user1);		
		optionRepository.save(o3);
		
		Option o4 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 1.8, user1);		
		optionRepository.save(o4);
		Option o5 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 1.8, user2);		
		optionRepository.save(o5);
		Option o6 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 2.5, user2);		
		optionRepository.save(o6);
		
		Option o7 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 2.6, user2);		
		optionRepository.save(o7);
		
		Option o8 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 2.7, user3);		
		optionRepository.save(o8);
		
		Option o9 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 2.9, user3);
		optionRepository.save(o9);
		Option o10 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 2.6, user3);
		optionRepository.save(o10);
		Option o11 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 3.6, user4);
		optionRepository.save(o11);
		Option o12 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 4, user4);
		optionRepository.save(o12);
		Option o13 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 4.5, user4);
		optionRepository.save(o13);
		
		Option o14 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 5.2, user5);
		optionRepository.save(o14);
		
		Option o15 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 5.6, user5);
		optionRepository.save(o15);
		
		Option o16 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 6.1, user5);
		optionRepository.save(o16);
		
		Option o17 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 4.1, user6);
		optionRepository.save(o17);
		
		Option o18 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 4.8, user6);
		optionRepository.save(o18);
		
		Option o19 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 5.2, user6);
		optionRepository.save(o19);
		
		Option o20 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 4.3, user6);
		optionRepository.save(o20);
		
		Option o21 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 2.1, user7);
		optionRepository.save(o21);
		
		Option o22 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 1.9, user7);
		optionRepository.save(o22);
		
		Option o23 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 1.7, user7);
		optionRepository.save(o23);
		
		Option o24 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 1.3, user8);
		optionRepository.save(o24);
		
		Option o25 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 1.5, user8);
		optionRepository.save(o25);
		
		Option o26 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 2.1, user8);
		optionRepository.save(o26);
		
		Option o27 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 1.5, user8);
		optionRepository.save(o27);
		
		Option o28 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 3.5, user9);
		optionRepository.save(o28);
		
		Option o29 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 3.2, user9);
		optionRepository.save(o29);
		
		Option o30 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 3.6, user9);
		optionRepository.save(o30);
		
		Option o31 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 3.4, user9);
		optionRepository.save(o31);
		
		Option o32 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 3.3, user9);
		optionRepository.save(o32);
		
		Option o33 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 5.6, user10);
		optionRepository.save(o33);
		
		Option o34 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 5.4, user10);
		optionRepository.save(o34);
		
		Option o35 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 5.7, user10);
		optionRepository.save(o35);
		
		Option o36 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 5.2, user10);
		optionRepository.save(o36);
		
		Option o37 = new Option("Dacia", "Logan", "2008", "2012", "3000",
				"5000", "Bucuresti", 5.5, user10);
		optionRepository.save(o37);
		User admin = new User("admin@gmail.com", secret, true);
		admin.addRole(adminRole);
		userRepository.save(admin);

		User master = new User("super@gmail.com", secret, true);
		master.addRoles(new HashSet<>(Arrays.asList(userRole, adminRole)));
		userRepository.save(master);
	}

}

