package com.virtual.real_estate.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtual.real_estate.entity.TwoverseMember;
import com.virtual.real_estate.service.CustomUserDetailService;
import com.virtual.real_estate.service.MailSendService;

@Controller
public class TwoverseMemberController {
	
	@Autowired
	CustomUserDetailService customUserDetailService;
    @Autowired
    private MailSendService mss;
	
	@GetMapping("/signup")
    public String signup() {
		
        return "twoverseMember/signup"; 
    }
	
	@PostMapping("/signup")
	public String sigup(TwoverseMember twoverseMember) {
		
		customUserDetailService.save(twoverseMember);
		System.out.println(twoverseMember.toString());
		return "redirect:/signup-success";
	}
	
	@GetMapping("/signup-success")
	public String signupSuccess() {
		return "twoverseMember/signup-success";
	}
	
	@ResponseBody
	@PostMapping("/signup/id-check")
	public Boolean idCheck(@RequestParam Map<String, Object> param) {
		System.out.println(param.get("userId").toString());
		return customUserDetailService.isTwoverseMember(param.get("userId").toString());
	}
//	
//	@PostMapping(""){
//		
//		/임의의 authKey 생성 & 이메일 발송
//        String authKey = mss.sendAuthMail(twoverseMember.getEMail());
//        twoverseMember.setAuthKey(authKey);
//
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("email", twoverseMemberDTO.getEmail());
//        map.put("authKey", twoverseMemberDTO.getAuthKey());
//        System.out.println(map);
//
//      //DB에 authKey 업데이트
//      twoverseMemberService.updateAuthKey(map);
//		
//		
//	}
	
	
	@GetMapping("/login")
    public String loginPage() {
        return "twoverseMember/login"; 
    }

	@PostMapping("/login")
    public String loginPagePost() {
        return "twoverseMember/login"; 
    }
	
	@GetMapping("/logout")
	  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
	    new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
	    return "redirect:/login";
	  }
	
	@GetMapping("/forgot-password")
    public String forgotPassword() {
        return "twoverseMember/forgot_password"; 
    }

	@GetMapping("/my_profile")
    public String myProfile(Model model) {
		
        return "twoverseMember/my_profile/my_profile"; 
    }
	
	@GetMapping("/my_profile/edit")
    public String myProfileEdit(Model model) {
		
        return "twoverseMember/my_profile/my_profile_edit"; 
    }
	@ResponseBody
	@PostMapping("my_profile/auth-email")
	public String myProfileAuthEmail(@RequestParam Map<String, Object> param) {
		//임의의 authKey 생성 & 이메일 발송
		String email = String.valueOf((String) param.get("email"));
		System.out.println("email=" + email);
		String authKey = mss.sendAuthMail(param);
		System.out.println(authKey);
//      twoverseMember.setAuthKey(authKey);


//      Map<String, String> map = new HashMap<String, String>();
//      map.put("email", twoverseMemberDTO.getEmail());
//      map.put("authKey", twoverseMemberDTO.getAuthKey());
//      System.out.println(map);

    //DB에 authKey 업데이트
//    twoverseMemberService.updateAuthKey(map);
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
        return "twoverseMember/settings/settings"; 
    }
	
	@ResponseBody
	@PostMapping("/settings/update")
    public String settingUpdate(@RequestParam Map<String, Object> param) {
		customUserDetailService.update(param);
        return "success"; 
    }
	
	@GetMapping("/settings/password")
    public String settingPassowrd(Model model) {
        return "twoverseMember/settings/password_settings"; 
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
        return "twoverseMember/password_change"; 
    }
	
	@PostMapping("/password_change")
	public String changePassowrd(TwoverseMember twoverseMember, HttpServletRequest request, HttpServletResponse response) {
		customUserDetailService.passwordChange(twoverseMember);
		new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
		return "redirect:/password-change-success";
	}
	
	@GetMapping("/password-change-success")
	public String passwordChangeSuccess() {
		return "twoverseMember/password-change-success";
	}
	@GetMapping("/alarm")
    public String alarm(Model model) {
		
        return "twoverseMember/alarm"; 
    }
}
