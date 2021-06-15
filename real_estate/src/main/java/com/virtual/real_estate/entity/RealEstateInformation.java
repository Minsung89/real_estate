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
@Table(name = "real_estate_information")
public class RealEstateInformation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "assets_number")
	private String assetsNumber;

	@Column(name = "building_name")
	private String buildingName;

	@Column(name = "address")
	private String address;

	@Column(name = "price")
	private String price;

	@Column(name = "rank")
	private String rank;

	@Column(name = "nickname")
	private String nickname;

	@Column(name = "last_transaction_date")
	private String lastTransactionDate;

	@Column(name = "purchase_status")
	private String purchaseStatus;

	@Column(name = "user_id")
	private String userId;

}