package sdu.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sdu.registration.entity.User;
import sdu.registration.repository.UserRepository;
import sdu.registration.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@Controller
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping("")
    public String viewHomePage() {
        return "home";
    }
    
    @GetMapping("/register")
    public String viewRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration_page";
    }

    @PostMapping("/process_register")
    public String processRegistration(User user) {
        if (user.getEmail().equals(service.findByEmail(user.getEmail()))) {
            return "redirect:/process_register";
        }
        service.saveUserWithDefaultRole(user);
        return "register_success";
    }


    @GetMapping(value = {"/login"})
    public String login(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap){

        User oldUser = service.login(email, password);

        if(Objects.nonNull(oldUser)){
            return "main";
        }
        else{
            modelMap.addAttribute("msg","Invalid credentials");

            return "redirect:/login";
        }
    }

//    @PostMapping("/login")
//    public String check(User user, Model model) {
//        if (service.login(user.getEmail(), user.getPassword()) == null) {
//            model.addAttribute("errorMessage", "Email or password not valid!");
//            return "login";
//        }
//        return "/list_users";
//    }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/login";
    }



    @GetMapping("/list_users")
    public String viewUsersList(Model model) {
        List<User> userList = service.listAllUsers();
        model.addAttribute("listUsers", userList);

        return "users";
    }

    @GetMapping("/mypage")
    public String viewMyPage() {
        return "mypage";
    }
}
