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
@Table(name = "transaction_history")
public class TransactionHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "seq")
	private Long seq;

	@Column(name = "assets_number")
	private String assetsNumber;

	@Column(name = "purchase_user")
	private String purchaseUser;

	@Column(name = "sell_user")
	private String sellUser;

	@Column(name = "purchase_price")
	private String purchasePrice;

	@Column(name = "sell_price")
	private String sellPrice;

	@Column(name = "fees")
	private String fees;

	@Column(name = "transaction_date")
	private String transactionDate;

}