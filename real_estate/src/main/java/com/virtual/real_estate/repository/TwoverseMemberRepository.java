package com.virtual.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtual.real_estate.entity.TwoverseMember;

public interface TwoverseMemberRepository extends JpaRepository<TwoverseMember, String>{

	public TwoverseMember findByUserId(String userId);
	
	public TwoverseMember findByReferralCode(String referralCode);
}
