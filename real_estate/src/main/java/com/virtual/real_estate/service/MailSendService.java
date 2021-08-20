package com.virtual.real_estate.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.virtual.real_estate.utils.MailUtils;

@Service("mms")
public class MailSendService {
	 @Autowired
	 private JavaMailSender mailSender;

	 int size;
	 
	 //인증키 생성
	 private String getKey(int size) {
	    this.size = size;
	    return getAuthCode();
	 }
	
	 //인증코드 난수 발생
	 private String getAuthCode() {
	    Random random = new Random();
	    StringBuffer buffer = new StringBuffer();
	    int num = 0;
	
	    while(buffer.length() < size) {
	        num = random.nextInt(10);
	        buffer.append(num);
	    }
	
	    return buffer.toString();
	 }	
	
	 //인증메일 보내기
	 public String sendAuthMail(Map<String, Object> param) {
		//6자리 난수 인증번호 생성
		String authKey = getKey(6);
		String email = String.valueOf((String) param.get("email"));
		String nickname = String.valueOf((String) param.get("nickname"));
		//인증메일 보내기
		try {
		    MailUtils sendMail = new MailUtils(mailSender);
		    sendMail.setSubject("2verse Verify Email Address");
		    sendMail.setText(new StringBuffer().append("<h2>Hi!"+ nickname +"</h2>")
		    .append("<p>Enter the code to complete the 2Verse account setup.<br/><br/>")
		    .append("<h1>code :")
		    .append(authKey+"</h1><br/>")
		    .append("Log in now to see where your Explorer is, and which awesome properties are available for you to purchase right now.<br/><br/>")
		    .append("Thank you for being with us.<br/>")
		    .append("For life through digital assets, freedom, and your new property.<br/><br/>")
		    .append("Regards <br/>")
		    .append("2Verse </p>")
		    .toString());
		    sendMail.setFrom("minsung0217@gmail.com", "admin");
		    sendMail.setTo(email);
		    sendMail.send();
		} catch (MessagingException e) {
		    e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
		    e.printStackTrace();
		}
		
		  return authKey;
	 }
}
