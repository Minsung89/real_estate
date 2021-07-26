package com.virtual.real_estate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.virtual.real_estate.entity.Member;
import com.virtual.real_estate.entity.MyUserDetail;
import com.virtual.real_estate.repository.MemberRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException { //로그인 시
		
		Member member = memberRepository.findByUserId(userId);
		if(member == null)
            throw new UsernameNotFoundException("사용자가 입력한 아이디에 해당하는 사용자를 찾을 수 없습니다.");
		
		return new MyUserDetail(member);
	}
	
	public Boolean save(Member member) {	//회원 가입
		BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
		member.setPass(bEncoder.encode(member.getPass()));
		try {
			member.setAuthId("USER");
			memberRepository.save(member);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
