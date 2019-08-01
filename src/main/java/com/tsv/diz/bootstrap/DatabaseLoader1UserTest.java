/*
package com.tsv.diz.bootstrap;

import com.tsv.diz.model.Role;
import com.tsv.diz.model.User;
import com.tsv.diz.repository.OptionRepository;
import com.tsv.diz.repository.RoleRepository;
import com.tsv.diz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader1UserTest implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private OptionRepository optionRepository;

    @Override
    public void run(String... args) throws Exception {
        addUsersAndRoles();
    }

    private void addUsersAndRoles() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String secret = "{bcrypt}" + encoder.encode("password");

        Role userRole = new Role("ROLE_USER");
        roleRepository.save(userRole);

        User user1 = new User("test1@gmail.com", secret, true);
        user1.addRole(userRole);
        userRepository.save(user1);
    }
}
*/
