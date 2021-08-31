package com.virtual.real_estate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WalletController {

	@GetMapping("/wallet/deposit")
    public String deposit(Model model) {
		
        return "twoverseMember/wallet/deposit"; 
    }

	@GetMapping("/wallet/withdraw")
    public String withdraw(Model model) {
		
        return "twoverseMember/wallet/withdraw"; 
    }
	
	@GetMapping("/wallet/details")
    public String details(Model model) {
		
        return "twoverseMember/wallet/details"; 
    }
}
