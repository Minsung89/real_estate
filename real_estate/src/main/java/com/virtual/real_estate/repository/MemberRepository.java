package com.virtual.real_estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtual.real_estate.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{

	public Member findByUserId(String userId);
}
