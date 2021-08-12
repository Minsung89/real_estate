package com.virtual.real_estate.controller;

import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtual.real_estate.entity.Member;
import com.virtual.real_estate.entity.MyUserDetail;
import com.virtual.real_estate.service.CustomUserDetailService;
import com.virtual.real_estate.service.MailSendService;

@Controller
public class MemberController {
	
	@Autowired
	CustomUserDetailService customUserDetailService;
    @Autowired
    private MailSendService mss;
	
	@GetMapping("/signup")
    public String signup() {
		
        return "/member/signup"; 
    }
	
	@PostMapping("/signup")
	public String sigup(Member member) {
	
		customUserDetailService.save(member);
		System.out.println(member.toString());
		return "redirect:/signup-success";
	}
	
	@GetMapping("/signup-success")
	public String signupSuccess() {
	
		return "/member/signup-success";
	}
	
	@ResponseBody
	@PostMapping("/signup/id-check")
	public Boolean idCheck(@RequestParam Map<String, Object> param) {
		System.out.println(param.get("userId").toString());
		return customUserDetailService.isMember(param.get("userId").toString());
	}
//	
//	@PostMapping(""){
//		
//		/임의의 authKey 생성 & 이메일 발송
//        String authKey = mss.sendAuthMail(member.getEMail());
//        member.setAuthKey(authKey);
//
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("email", memberDTO.getEmail());
//        map.put("authKey", memberDTO.getAuthKey());
//        System.out.println(map);
//
//      //DB에 authKey 업데이트
//      memberService.updateAuthKey(map);
//		
//		
//	}
	
	
	@GetMapping("/login")
    public String loginPage() {
        return "/member/login"; 
    }

	@PostMapping("/login")
    public String loginPagePost() {
        return "/member/login"; 
    }
	
	@GetMapping("/logout")
	  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
	    new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
	    return "redirect:/login";
	  }
	
	@GetMapping("/forgot-password")
    public String forgotPassword() {
        return "/member/forgot_password"; 
    }

	@GetMapping("/my_profile")
    public String myProfile(Model model) {
		
        return "/member/my_profile/my_profile"; 
    }
	
	@GetMapping("/my_profile/edit")
    public String myProfileEdit(Model model) {
		
        return "/member/my_profile/my_profile_edit"; 
    }
	@ResponseBody
	@PostMapping("my_profile/auth-email")
	public void myProfileAuthEmail(@RequestParam Map<String, Object> param) {
		//임의의 authKey 생성 & 이메일 발송
		String email = String.valueOf( (String) param.get("email"));
		System.out.println("email=" + email);
		String authKey = mss.sendAuthMail("minsung021@naver.com");
		System.out.println(authKey);
//      member.setAuthKey(authKey);


//      Map<String, String> map = new HashMap<String, String>();
//      map.put("email", memberDTO.getEmail());
//      map.put("authKey", memberDTO.getAuthKey());
//      System.out.println(map);

    //DB에 authKey 업데이트
//    memberService.updateAuthKey(map);
	}
	@ResponseBody
	@GetMapping("my_profile/auth-success")
	public void myProfileAuthSuccess(@RequestParam Map<String, Object> param) {
		 //email, authKey 가 일치할경우 authStatus 업데이트
		String email = String.valueOf( (String) param.get("email"));
	
	}
	
	
	
	@GetMapping("/settings")
    public String setting(Model model) {
		
        return "/member/settings/settings"; 
    }
	
	@GetMapping("/alarm")
    public String alarm(Model model) {
		
        return "/member/alarm"; 
    }
}
