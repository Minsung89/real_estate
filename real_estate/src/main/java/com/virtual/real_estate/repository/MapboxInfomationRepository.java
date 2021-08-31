package com.virtual.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtual.real_estate.entity.MapboxInformation;

public interface MapboxInfomationRepository extends JpaRepository<MapboxInformation, String>{

	public MapboxInformation findByAssetsNumber(String assetsNumber);
}
