package com.virtual.real_estate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virtual.real_estate.entity.Member;
import com.virtual.real_estate.entity.MyUserDetail;
import com.virtual.real_estate.service.CustomUserDetailService;

@Controller
public class MemberController {
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@GetMapping("/signup")
    public String signup() {
		
        return "/member/signup"; 
    }
	
	@PostMapping("/signup")
	public String sigup(Member member) {
	
		customUserDetailService.save(member);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+member.toString());
		return "redirect:/login";
	}
	
	@GetMapping("/login")
    public String loginPage() {
        return "/member/login"; 
    }
//	
//	@PostMapping("/loginAuth")
//    public String login(Model model, Authentication authentication ) {
//		System.out.println("11111111111111111111111"+authentication.toString());
////		MyUserDetail myUserDetail = (MyUserDetail)authentication.getPrincipal();
////		model.addAttribute("userId", myUserDetail.getUsername());
//		
//        return "index"; 
//    }
//	
	@GetMapping("/logout")
	  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
	    new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
	    return "redirect:/login";
	  }
	
	
	@RequestMapping("/assets")
    public String assets(Model model) {
		
        return "/member/assets"; 
    }
	
	@RequestMapping("/wallet")
    public String wallet(Model model) {
		
        return "/member/wallet"; 
    }
	
	@RequestMapping("/my_profile")
    public String myProfile(Model model) {
		
        return "/member/my_profile"; 
    }
	
	@RequestMapping("/settings")
    public String setting(Model model) {
		
        return "/member/settings"; 
    }
}
