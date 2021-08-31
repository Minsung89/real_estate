package com.virtual.real_estate.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.virtual.real_estate.entity.MapboxInformation;

import lombok.Data;

@Data
public class MapboxPersingData {

	List<Map<String, Object>> features;
	String type;
	
	public Map<String, Object> propertisPush(MapboxInformation mi) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("height", Double.valueOf(mi.getBuildingHeight()));
		properties.put("ios_3166_1", mi.getNation());
		properties.put("ios_3166_2", mi.getDistrict());
		properties.put("min-height", 0);
		properties.put("type", mi.getBuildingType());
		properties.put("underground", "false");
		return properties;
	}
	
	public Map<String,Object> geometryPush(String data) {
		Map<String, Object> geometry = new HashMap<>();
		geometry.put("coordinates", data);
		geometry.put("type","Polygon");
		return geometry;
	}
	
}
