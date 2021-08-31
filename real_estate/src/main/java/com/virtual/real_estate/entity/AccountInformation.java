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
@Table(name = "account_information")
public class AccountInformation {

	@Id
	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "certification_date")
	private String certificationDate;

	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "rmks")
	private String rmks;


}
