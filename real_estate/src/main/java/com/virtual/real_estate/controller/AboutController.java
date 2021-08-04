package com.virtual.real_estate.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutController {
	
	@RequestMapping("/about_2verse")
    public String about() {
        return "/about/about_2verse"; 
    }
	
	@RequestMapping("/contact_us")
    public String contactUs() {
        return "/about/contact_us"; 
    }
	
	@RequestMapping("/update")
    public String update() {
        return "/about/update"; 
    }
}
