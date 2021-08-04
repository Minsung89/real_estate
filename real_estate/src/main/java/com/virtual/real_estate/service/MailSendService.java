package com.virtual.real_estate.service;

import java.io.UnsupportedEncodingException;
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
	 public String sendAuthMail(String email) {
		//6자리 난수 인증번호 생성
		String authKey = getKey(6);
		
		//인증메일 보내기
		try {
		    MailUtils sendMail = new MailUtils(mailSender);
		    sendMail.setSubject("2verse Verify Email Address");
		    sendMail.setText(new StringBuffer().append("<h1>Hello!</h1>")
		    .append("<p>Please click the link below to verify your email address.</p>")
		    .append("<a href='http://localhost:9080/my_profile/auth-success?email=")
		    .append(email)
		    .append("&authKey=")
		    .append(authKey)
		    .append("' target='_blenk'>Verify Email Address</a>")
		    .toString());
		    sendMail.setFrom("minsung0217@gmail.com", "ADMIN");
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
