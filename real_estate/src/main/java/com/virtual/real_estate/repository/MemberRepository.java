package com.virtual.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtual.real_estate.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	public Member findByUserId(String userId);
}
