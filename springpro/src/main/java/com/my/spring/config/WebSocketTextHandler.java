package com.my.spring.config;

import java.lang.management.ManagementFactory;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import com.sun.management.OperatingSystemMXBean;


public class WebSocketTextHandler extends TextWebSocketHandler {
	
	private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("connect!");
		sessions.add(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub

		 com.sun.management.UnixOperatingSystemMXBean  osBean = (com.sun.management.UnixOperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
			 Double cpuuseamount = osBean.getSystemCpuLoad()*100;
			 String cpudata =String.format("%.2f", cpuuseamount);
			session.sendMessage(new TextMessage(cpudata));
		
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("discconect");
		sessions.remove(session);
	}
	
}
