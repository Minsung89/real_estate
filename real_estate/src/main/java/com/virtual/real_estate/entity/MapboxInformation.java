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
@Table(name = "mapbox_information")
public class MapboxInformation {

	@Id
	@Column(name = "assets_number")
	private String assetsNumber;

	@Column(name = "building_type")
	private String buildingType;

	@Column(name = "coordinates")
	private String coordinates;

	@Column(name = "building_height")
	private String buildingHeight;

	@Column(name = "nation")
	private String nation;

	@Column(name = "district")
	private String district;

	@Column(name = "rmks")
	private String rmks;

}