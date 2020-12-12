package com.telbook.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class AddressBookController {
    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession){
        httpSession.setAttribute("loggedIn",false);
        return "redirect:/";
    }

    @RequestMapping(value = "/addressList")
    public ModelAndView addressList(){
        return new ModelAndView("addressList");
    }

    @RequestMapping(value = "/success")
    public ModelAndView success(){
        return new ModelAndView("success");
    }

    @RequestMapping(value = "/addNew")
    public ModelAndView addNew(){
        return new ModelAndView("addNewContact");
    }

}
