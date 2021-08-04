package com.virtual.real_estate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import lombok.Data;

@Data
@Entity
@DynamicInsert
@Table(name = "member")
public class Member {

	@Id
	@Column(name = "user_id")
	private String userId;

	@Column(name = "pass")
	private String pass;

	@Column(name = "name")
	private String name;

	@Column(name = "nickname")
	private String nickname;

	@Column(name = "address")
	private String address;

	@Column(name = "e_mail")
	private String eMail;

	@Column(name = "point")
	private String point;

	@Column(name = "sing_up_date")
	private String singUpDate;

	@Column(name = "secession_state")
	private String secessionState;

	@Column(name = "ph_number")
	private String phNumber;
	
	@Column(name = "authority")
	private String authority;
	
	@Column(name = "auth_state")
	@ColumnDefault("N")
	private String authState;
	
	@Column(name = "auth_key")
	private String authKey;
	
	@Column(name = "nation")
	private String nation;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "referral_code")
	private String referralCode;
}