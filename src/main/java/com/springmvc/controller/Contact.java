package com.springmvc.controller;

import com.springmvc.Model.User;
import com.springmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Contact {

    @Autowired
    private UserService userService;

    @ModelAttribute
    public void common(Model m){
        m.addAttribute("dear","Niraj is best legend");
        m.addAttribute("para","U can call him rush god");
    }

    @RequestMapping("/register")
    public String contact(){
        return "contact";
    }

    @RequestMapping(path = "/processform",method = RequestMethod.POST)
    public String handleForm(@ModelAttribute("user") User user, Model model){
        System.out.println(user);
        userService.createUser(user);
        return "niraj";
    }



}



//    public String handleForm(@RequestParam("email") String userEmail,
//                             @RequestParam("username") String userName,
//                             @RequestParam("password") String userPassword,
//                                Model model){
//
//        User user=new User();
//        user.setEmail(userEmail);
//        user.setUsername(userName);
//        user.setPassword(userPassword);
//
//        System.out.println(user);
//
//        model.addAttribute("user",user);
//
////        model.addAttribute("name",userName);
////        model.addAttribute("email",userEmail);
////        model.addAttribute("password",userPassword);
//
//        return "niraj";
//
//    }
