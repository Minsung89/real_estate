package com.virtual.real_estate.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.virtual.real_estate.entity.Member;
import com.virtual.real_estate.entity.MyUserDetail;
import com.virtual.real_estate.repository.MemberRepository;
import com.virtual.real_estate.utils.SecurityUtil;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	MemberRepository memberRepository;
	@Autowired
	UsersService users;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException { // 로그인 시

		Member member = memberRepository.findByUserId(userId);

		if (member == null)
			throw new UsernameNotFoundException("사용자가 입력한 아이디에 해당하는 사용자를 찾을 수 없습니다.");
		users.userAdd(userId);
		
		List<String> u = users.userAll();
		for (int i = 0; i < u.size(); i++) {
			System.out.println(u.get(i));
		}
		System.out.println(member.toString());
		
//		memberRepository.save(member);
		return new MyUserDetail(member);
	}

	public Boolean save(Member member) { // 회원 가입
		Member m = memberRepository.findByUserId(member.getUserId());
		if (m != null) //아이디 중복 체크
			return false;
		BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
		member.setPass(bEncoder.encode(member.getPass()));
		try {
			member.setEMail(member.getUserId());
			memberRepository.save(member);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean isMember(String userId) {//아이디 중복 체크
		Member m = memberRepository.findByUserId(userId);
		if (m != null) 
			return false;
		return true;
	}
	
	public Boolean passwordCheck(String userId, String password) { //비밀번호 체크
		Member m = memberRepository.findByUserId(userId);
		if (m != null) {
			return new BCryptPasswordEncoder().matches(password, m.getPass()); //유저O 비밀번호 O : true
		}
		return false;
	}
	
	public void passwordChange(Member member) { //비밀번호 변경
		BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
		Member m = memberRepository.findByUserId(member.getUserId());
		m.setPass(bEncoder.encode(member.getPass()));
		memberRepository.save(m);
	}
	
	public void update(Map<String,Object> param) {//수정
		MyUserDetail myUserDetail = SecurityUtil.getCustomUser();
		if(myUserDetail != null) {
			Member m = memberRepository.findByUserId(myUserDetail.getUserId());
			if(param.containsKey("nickname")) {
				m.setNickname(param.get("nickname").toString());
				myUserDetail.setNickname(param.get("nickname").toString());
			}
			if(param.containsKey("nation")) {
				m.setNation(param.get("nation").toString());
				myUserDetail.setNation(param.get("nation").toString());
			}
			if(param.containsKey("auth_state")) {
				m.setAuthState(param.get("auth_state").toString());
				myUserDetail.setAuthState(param.get("auth_state").toString());
			}
			memberRepository.save(m);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Authentication newAuth = new UsernamePasswordAuthenticationToken(myUserDetail, auth.getCredentials(), auth.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(newAuth);
		}

	}
}