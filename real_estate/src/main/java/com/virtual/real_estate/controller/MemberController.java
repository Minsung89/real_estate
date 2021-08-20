package com.virtual.real_estate.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.virtual.real_estate.utils.SecurityUtil;
import com.virtual.real_estate.utils.UuidUtil;

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
        return "member/login"; 
    }

	@PostMapping("/login")
    public String loginPagePost() {
        return "member/login"; 
    }
	
	@GetMapping("/logout")
	  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
	    new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
	    return "redirect:/login";
	  }
	
	@GetMapping("/forgot-password")
    public String forgotPassword() {
        return "member/forgot_password"; 
    }

	@GetMapping("/my_profile")
    public String myProfile(Model model) {
		
        return "member/my_profile/my_profile"; 
    }
	
	@GetMapping("/my_profile/edit")
    public String myProfileEdit(Model model) {
		
        return "member/my_profile/my_profile_edit"; 
    }
	@ResponseBody
	@PostMapping("my_profile/auth-email")
	public String myProfileAuthEmail(@RequestParam Map<String, Object> param) {
		//임의의 authKey 생성 & 이메일 발송
		String email = String.valueOf((String) param.get("email"));
		System.out.println("email=" + email);
		String authKey = mss.sendAuthMail(param);
		System.out.println(authKey);
//      member.setAuthKey(authKey);


//      Map<String, String> map = new HashMap<String, String>();
//      map.put("email", memberDTO.getEmail());
//      map.put("authKey", memberDTO.getAuthKey());
//      System.out.println(map);

    //DB에 authKey 업데이트
//    memberService.updateAuthKey(map);
		return authKey;
	}
	@ResponseBody
	@GetMapping("my_profile/auth-success")
	public void myProfileAuthSuccess(@RequestParam Map<String, Object> param) {
		 //email, authKey 가 일치할경우 authStatus 업데이트
		String email = String.valueOf( (String) param.get("email"));
	}
	
	@GetMapping("/settings")
    public String setting(Model model, HttpServletRequest request) {
		File dir = new File(request.getServletContext().getRealPath("resources/assets/image/nation/"));
//	 	SecurityUtil.userInfoUpdate();
	    File[] fileList = dir.listFiles();

	    ArrayList<String> nation = new ArrayList<>();
	    for(int i=0; i<fileList.length; i++) {
	      File file = fileList[i]; 

	      if(file.isFile()){
	          nation.add(file.getName().split("\\.")[0]);
	      }
	    }
		model.addAttribute("nation",nation);
		System.out.println(UuidUtil.uuidTen());
        return "member/settings/settings"; 
    }
	
	@ResponseBody
	@PostMapping("/settings/update")
    public String settingUpdate(@RequestParam Map<String, Object> param) {
		customUserDetailService.update(param);
        return "success"; 
    }
	
	@GetMapping("/settings/password")
    public String settingPassowrd(Model model) {
        return "member/settings/password_settings"; 
    }
	
	@ResponseBody
	@PostMapping("/settings/password")
    public String settingPassowrdVal(@RequestParam Map<String, Object> param) {
		String userId = String.valueOf( (String) param.get("userId"));
		String password = String.valueOf( (String) param.get("password"));
		System.out.println(userId);
		System.out.println(password);
		if(customUserDetailService.passwordCheck(userId, password)) {
			return "passwordConfirmOk"; 
		}
        return "passwordConfirmNo";
    }
	
	@GetMapping("/password_change")
    public String changePassowrd() {
        return "member/password_change"; 
    }
	
	@PostMapping("/password_change")
	public String changePassowrd(Member member, HttpServletRequest request, HttpServletResponse response) {
		customUserDetailService.passwordChange(member);
		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/password-change-success";
	}
	
	@GetMapping("/password-change-success")
	public String passwordChangeSuccess() {
		return "member/password-change-success";
	}
	@GetMapping("/alarm")
    public String alarm(Model model) {
		
        return "member/alarm"; 
    }
}
