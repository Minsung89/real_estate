package com.virtual.real_estate.entity;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
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
	
	@Column(name = "auth_id")
	private String authId;

	
}