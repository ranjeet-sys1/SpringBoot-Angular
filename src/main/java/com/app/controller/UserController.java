package com.app.controller;

import com.app.model.User;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/saveUser",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user,Model model){
        if(user!=null){
            User saveUser = userService.saveUser(user);
            model.addAttribute("message",user.getName()+" get saved");
            model.addAttribute("user",new User());
            return "Register";
        }else{
            return null;
        }
    }
    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "Register";
    }
}
