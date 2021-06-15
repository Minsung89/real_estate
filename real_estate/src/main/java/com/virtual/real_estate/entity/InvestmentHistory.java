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
@Table(name = "investment_history")
public class InvestmentHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "possession_assets")
	private String possessionAssets;
	
	@Column(name = "total_possession_assets")
	private String totalPossessionAssets;
	
	@Column(name = "total_purchase")
	private String totalPurchase;
	
	@Column(name = "total_income")
	private String totalIncome;
	
	@Column(name = "total_amount")
	private String totalAmount;
	
	@Column(name = "total_income_rate")
	private String totalIncomeRate;
	
	@Column(name = "additional_income")
	private String additionalIncome;

}