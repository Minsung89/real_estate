package com.virtual.real_estate.service;

import java.util.Map;

import com.virtual.real_estate.data.MapboxPersingData;


public interface RealEstateService {

	public Boolean save(Map<String, Object> param);
	
	public MapboxPersingData mapAll();
	
}
