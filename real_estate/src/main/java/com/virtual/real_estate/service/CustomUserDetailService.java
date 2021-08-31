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

import com.virtual.real_estate.entity.TwoverseMember;
import com.virtual.real_estate.entity.MyUserDetail;
import com.virtual.real_estate.repository.TwoverseMemberRepository;
import com.virtual.real_estate.utils.SecurityUtil;
import com.virtual.real_estate.utils.UuidUtil;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	TwoverseMemberRepository twoverseMemberRepository;
	@Autowired
	UsersService users;
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException { // 로그인 시

		TwoverseMember twoverseMember = twoverseMemberRepository.findByUserId(userId);

		if (twoverseMember == null)
			throw new UsernameNotFoundException("사용자가 입력한 아이디에 해당하는 사용자를 찾을 수 없습니다.");
		users.userAdd(userId);
		
		List<String> u = users.userAll();
		for (int i = 0; i < u.size(); i++) {
			System.out.println(u.get(i));
		}
		System.out.println(twoverseMember.toString());
		
//		twoverseMemberRepository.save(twoverseMember);
		return new MyUserDetail(twoverseMember);
	}

	public Boolean save(TwoverseMember twoverseMember) { // 회원 가입
		TwoverseMember m = twoverseMemberRepository.findByUserId(twoverseMember.getUserId());
		if (m != null) //아이디 중복 체크
			return false;
		BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
		twoverseMember.setPass(bEncoder.encode(twoverseMember.getPass()));
		try {
			while (true) { //추천인 코드 생성
				String referralCode = UuidUtil.uuidTen();
				TwoverseMember isReferalCode = twoverseMemberRepository.findByReferralCode(referralCode);
				if(isReferalCode == null) {
					twoverseMember.setReferralCode(referralCode);
					break;
				}
			}
			twoverseMember.setEMail(twoverseMember.getUserId());
			twoverseMemberRepository.save(twoverseMember);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public Boolean isTwoverseMember(String userId) {//아이디 중복 체크
		TwoverseMember m = twoverseMemberRepository.findByUserId(userId);
		if (m != null) 
			return false;
		return true;
	}
	
	public Boolean passwordCheck(String userId, String password) { //비밀번호 체크
		TwoverseMember m = twoverseMemberRepository.findByUserId(userId);
		if (m != null) {
			return new BCryptPasswordEncoder().matches(password, m.getPass()); //유저O 비밀번호 O : true
		}
		return false;
	}
	
	public void passwordChange(TwoverseMember twoverseMember) { //비밀번호 변경
		BCryptPasswordEncoder bEncoder = new BCryptPasswordEncoder();
		TwoverseMember m = twoverseMemberRepository.findByUserId(twoverseMember.getUserId());
		m.setPass(bEncoder.encode(twoverseMember.getPass()));
		twoverseMemberRepository.save(m);
	}
	
	public void update(Map<String,Object> param) {//수정
		MyUserDetail myUserDetail = SecurityUtil.getCustomUser();
		if(myUserDetail != null) {
			TwoverseMember m = twoverseMemberRepository.findByUserId(myUserDetail.getUserId());
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
			twoverseMemberRepository.save(m);
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Authentication newAuth = new UsernamePasswordAuthenticationToken(myUserDetail, auth.getCredentials(), auth.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(newAuth);
		}

	}
}