package com.virtual.real_estate.entity;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.ToString;

@ToString
public class MyUserDetail implements UserDetails{

	private static final long serialVersionUID = 1L;
	private String userId;
	private String pass;
	private String authority;
	private String nickname;
	private String address;
	private String eMail;
	private String point;
	private String singUpDate;
	private String secessionState;
	private String phNumber;
	private String nation;
	private String authState;
	private String referralCode;
	
	public MyUserDetail(Member member) {
		this.userId = member.getUserId();
		this.pass = member.getPass();
		this.authority = member.getAuthority();
		this.nickname = member.getNickname();
		this.address = member.getAddress();
		this.eMail = member.getEMail();
		this.point = member.getPoint();
		this.phNumber = member.getPhNumber();
		this.nation = member.getNation();
		this.authState = member.getAuthState();
		this.referralCode = member.getReferralCode();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(this.authority));
	}

	@Override
	public String getPassword() {
		return this.pass;
	}

	@Override
	public String getUsername() {
		return this.userId;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public String getPoint() {
		return this.point;
	}

	public String getNickname() {
		return nickname;
	}

	public String getAddress() {
		return address;
	}

	public String geteMail() {
		return eMail;
	}

	public String getSingUpDate() {
		return singUpDate;
	}

	public String getPhNumber() {
		return phNumber;
	}

	public String getNation() {
		return nation;
	}

	public String getAuthState() {
		return authState;
	}

	public String getReferralCode() {
		return referralCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getSecessionState() {
		return secessionState;
	}

	public void setSecessionState(String secessionState) {
		this.secessionState = secessionState;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public void setSingUpDate(String singUpDate) {
		this.singUpDate = singUpDate;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public void setAuthState(String authState) {
		this.authState = authState;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	
}
