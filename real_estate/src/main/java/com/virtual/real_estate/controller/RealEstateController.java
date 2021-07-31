package com.virtual.real_estate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
		
		ArrayList<Map<String, String>> test = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			  HashMap<String, String> data = new HashMap<String, String>();
			   data.put("sort", "data"+i+"="+"sell");
			   data.put("nation","data"+i+"="+ "korea");
			   data.put("assetName","data"+i+"="+ "city hall");
			   data.put("data", "data"+i+"="+ "2021-07-29");
			   data.put("price", "data"+i+"="+ "300");
			   data.put("deal", "data"+i+"="+ "6000");
			   data.put("grade", "data"+i+"="+ "1");
			   data.put("proceeds", "data"+i+"="+ "+3000");
			   test.add(data);
		}
		 
		model.addAttribute("data",test);
		
		
        return "/real_estate/market"; 
    }
	
}
