package com.virtual.real_estate.entity;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetail implements UserDetails{

	private static final long serialVersionUID = 1L;
	private String userId;
	private String pass;
	private String authId;
	private String nickname;
	private String address;
	private String eMail;
	private String point;
	private String singUpDate;
	private String secessionState;
	private String phNumber;
	private String nation;
	
	
	public MyUserDetail(Member member) {
		this.userId = member.getUserId();
		this.pass = member.getPass();
		this.authId = member.getAuthId();
		this.nickname = member.getNickname();
		this.address = member.getAddress();
		this.eMail = member.getEMail();
		this.point = member.getPoint();
		this.phNumber = member.getPhNumber();
		this.nation = member.getNation();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(this.authId));
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

}
