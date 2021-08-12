package com.virtual.real_estate.handler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.virtual.real_estate.service.UsersService;


public class EchoHandler extends TextWebSocketHandler{

	// 로그인중인 개별유저
	Map<String, WebSocketSession> userss = new ConcurrentHashMap<String, WebSocketSession>();
	
//	@Autowired
//	UsersService users;
	
	// 클라이언트가 서버로 연결시
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
//		if(null != users.userAll() && users.userAll().size() < 0) {
//			List<String> u = users.users;
//			for (int i = 0; i < u.size(); i++) {
//				System.out.println(u.get(i));
//			}
//		}
		String senderId = getMemberId(session); // 접속한 유저의 http세션을 조회하여 id를 얻는 함수
		if(senderId!=null) {	// 로그인 값이 있는 경우만
			System.out.println(senderId + " 연결 됨");
			userss.put(senderId, session);   // 로그인중 개별유저 저장
		}
	}
	// 클라이언트가 Data 전송 시
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String senderId = getMemberId(session);
		System.out.println(message.getPayload());
		/*
		 * 유저가 있을 시 실시간으로 보여주기 (오른쪽 상단에 알람 숫자 표기)
		 * 없을 시 데이터만 저장
		 */
		
		
		// 특정 유저에게 보내기
		String msg = message.getPayload();
		if(msg != null) {
			String[] strs = msg.split(",");
			log(strs.toString());
			if(strs != null && strs.length == 4) {
				String type = strs[0];
				String target = strs[1]; // m_id 저장
				String content = strs[2];
				String url = strs[3];
				WebSocketSession targetSession = userss.get(target);  // 메시지를 받을 세션 조회
				
				// 실시간 접속시
				if(targetSession!=null) {
					// ex: [&분의일] 신청이 들어왔습니다.
					TextMessage tmpMsg = new TextMessage("<a target='_blank' href='"+ url +"'>[<b>" + type + "</b>] " + content + "</a>" );
					targetSession.sendMessage(tmpMsg);
				}
			}
		}
	}
	// 연결 해제될 때
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String senderId = getMemberId(session);
		if(senderId!=null) {	// 로그인 값이 있는 경우만
			log(senderId + " 연결 종료됨");
			userss.remove(senderId);
		}
	}
	// 에러 발생시
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log(session.getId() + " 익셉션 발생: " + exception.getMessage());

	}
	// 로그 메시지
	private void log(String logmsg) {
		System.out.println(new Date() + " : " + logmsg);
	}
	// 웹소켓에 id 가져오기
    // 접속한 유저의 http세션을 조회하여 id를 얻는 함수
	private String getMemberId(WebSocketSession session) {
		
		 // security user 가져오기
		if(session.getAttributes().containsKey("SPRING_SECURITY_CONTEXT")) {
			SecurityContext value = (SecurityContext) session.getAttributes().get("SPRING_SECURITY_CONTEXT");
			Authentication authentication = value.getAuthentication();
			System.out.println(session.getAttributes().toString());
			System.out.println(authentication.getName());
			return authentication.getName();
		}
		return null;
	}
	
}
