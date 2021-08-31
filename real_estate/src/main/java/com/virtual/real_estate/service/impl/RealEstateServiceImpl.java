package com.virtual.real_estate.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtual.real_estate.data.MapboxPersingData;
import com.virtual.real_estate.entity.MapboxInformation;
import com.virtual.real_estate.entity.TwoverseMember;
import com.virtual.real_estate.entity.RealEstateInformation;
import com.virtual.real_estate.entity.TransactionHistory;
import com.virtual.real_estate.repository.MapboxInfomationRepository;
import com.virtual.real_estate.repository.TwoverseMemberRepository;
import com.virtual.real_estate.repository.RealEstateInformationRepository;
import com.virtual.real_estate.repository.TransactionHistoryRepository;
import com.virtual.real_estate.service.RealEstateService;
import com.virtual.real_estate.utils.CurrentDateTimeUtil;
import com.virtual.real_estate.utils.SecurityUtil;

import lombok.extern.java.Log;

@Service("resalestate")
public class RealEstateServiceImpl implements RealEstateService{

	@Autowired
	MapboxInfomationRepository mir;
	
	@Autowired
	RealEstateInformationRepository reir;
	
	@Autowired
	TwoverseMemberRepository mri;
	
	@Autowired
	TransactionHistoryRepository thr;
	
	@Override
	public Boolean save(Map<String, Object> param) {
		
		//회원이 아니면 구매 불가
		if(null != SecurityUtil.getUserId()) {
			MapboxInformation mi = mir.findByAssetsNumber(param.get("id").toString());
			String nowDate = CurrentDateTimeUtil.nowDate();
			// 맵박스 정보
			if(null == mi) {
				mi = new MapboxInformation();
				mi.setAssetsNumber(param.get("id").toString());
				mi.setBuildingHeight(((Map<?, ?>)param.get("properties")).get("height").toString());
				mi.setBuildingType(((Map<?, ?>)param.get("properties")).get("type").toString());
				mi.setCoordinates(param.get("geometry").toString());
				mi.setDistrict(((Map<?, ?>)param.get("properties")).get("iso_3166_2").toString());
				mi.setNation(((Map<?, ?>)param.get("properties")).get("iso_3166_1").toString());
				System.out.println(mi.toString());
		//		MapboxPersingData mapboxPersingData = new MapboxPersingData();
		//		List<Map<String,Object>>list = new ArrayList<>();
		//		list.add(param);
		//		mapboxPersingData.setFeatures(list);
		//		Gson test = new Gson();
		//		System.out.println(test.toJson(mapboxPersingData));
				mir.save(mi);
			}
			// 거래 내역 (제안 기능 추가시 변경)
			RealEstateInformation rei = reir.findByAssetsNumber(param.get("id").toString());
			TransactionHistory th = new TransactionHistory();
			TwoverseMember twoverseMember = mri.findByUserId(SecurityUtil.getUserId());
			System.out.println(rei);
			if(null != rei) { //주인 있을 시
				th.setSellUser(rei.getUserId());
				
			}else {// 부동산 주인이 운영자일경우
				th.setSellUser("2verse");
				rei = new RealEstateInformation();
				rei.setAssetsNumber(param.get("id").toString());
			}
			th.setAssetsNumber(rei.getAssetsNumber());
			th.setPurchaseUser(SecurityUtil.getUserId());
			th.setPurchasePrice("1000"); //제안가격 입력받아서 넣어줘야함 테스트는 하드코딩
			th.setSellPrice(param.get("price").toString());
			th.setTransactionDate(nowDate);
			thr.save(th);
			
			// 부동산 정보
			rei.setPrice(param.get("price").toString());
			rei.setNickname(twoverseMember.getNickname());
			rei.setRealRank("1");
			rei.setUserId(SecurityUtil.getUserId());
			rei.setLastTransactionDate(nowDate);
			rei.setPurchaseStatus("N");
			reir.save(rei);
			return true;
		}
		return false;
	}

	@Override
	public MapboxPersingData mapAll() {
		
		List<MapboxInformation> mis = mir.findAll();
		MapboxPersingData mpd = new MapboxPersingData();
		List<Map<String, Object>> features = new ArrayList<>();
		for (int i = 0; i < mis.size(); i++) {
			Map<String, Object> feature = new HashMap<>();
			feature.put("id", Long.valueOf(mis.get(i).getAssetsNumber()));
			feature.put("type", "feature");
			feature.put("properties", mpd.propertisPush(mis.get(i)));
			feature.put("geometry", mpd.geometryPush(mis.get(i).getCoordinates()));
			features.add(feature);
			System.out.println(feature.toString());
		}
		mpd.setFeatures(features);
		mpd.setType("FeatureCollection");
		return mpd;
	}

	
	
}
