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
@Table(name = "suggestion_history")
public class SuggestionHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "seq")
	private Long seq;

	@Column(name = "assets_number")
	private String assetsNumber;

	@Column(name = "suggested_user")
	private String suggestedUser;

	@Column(name = "offer_price")
	private String offerPrice;

	@Column(name = "offer_date")
	private String offerDate;

}