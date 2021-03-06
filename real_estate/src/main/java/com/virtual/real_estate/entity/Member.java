package com.virtual.real_estate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private String useId;

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

}