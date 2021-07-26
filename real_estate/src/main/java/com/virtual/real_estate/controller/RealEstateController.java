package com.virtual.real_estate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RealEstateController {
	
	@RequestMapping("/map")
    public String map(Model model) {
		
        return "/real_estate/trading"; 
    }
	
	@RequestMapping("/notice")
    public String notice(Model model) {
		
        return "/real_estate/notice"; 
    }
	
	@RequestMapping("/market")
    public String market(Model model) {
		
        return "/real_estate/market"; 
    }
	
}
