package com.virtual.real_estate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WalletController {

	@GetMapping("/wallet/deposit")
    public String deposit(Model model) {
		
        return "member/wallet/deposit"; 
    }

	@GetMapping("/wallet/withdraw")
    public String withdraw(Model model) {
		
        return "member/wallet/withdraw"; 
    }
	
	@GetMapping("/wallet/details")
    public String details(Model model) {
		
        return "member/wallet/details"; 
    }
}
