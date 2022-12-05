package sdu.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sdu.registration.entity.Role;
import sdu.registration.entity.User;
import sdu.registration.repository.RoleRepository;
import sdu.registration.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user;
    }

    public void saveUserWithDefaultRole(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role userRole = roleRepository.findByRoleName("USER");
        user.addRole(userRole);
        userRepository.save(user);
    }

    public List<User> listAllUsers() {
        return  userRepository.findAll();
    }

}
