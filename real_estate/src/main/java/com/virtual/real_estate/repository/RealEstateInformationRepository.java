package com.virtual.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtual.real_estate.entity.RealEstateInformation;

public interface RealEstateInformationRepository extends JpaRepository<RealEstateInformation, String>{

	public RealEstateInformation findByAssetsNumber(String assetsNumber);
}
