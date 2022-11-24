package com.my.spring.chart.handler;

import java.lang.management.ManagementFactory;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.sun.management.OperatingSystemMXBean;

public class ChartHandler extends TextWebSocketHandler {

	private static final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	HashMap<String, WebSocketSession> sessionMap = new HashMap<String, WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Socket 연결");
		super.afterConnectionEstablished(session);
		sessionMap.put(session.getId(), session);

	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		String sessionId = session.getId();
		System.out.println("sessionId" + sessionId);
		String payload = (String) message.getPayload();
		System.out.println("받아온값 : " + payload);
		if (sessionId != null) {
			WebSocketSession webSocketSession = sessionMap.get(sessionId);
			int usingCPU = (int) (Math.random() * 100);
			String cpu = "1";
			logger.info(" int type usingCPU random num : " + usingCPU);
			String CPUData = Integer.toString(usingCPU);
			logger.info("String type CPUData : " + CPUData);
				
//		    OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
//			System.out.println("===================");
//			System.out.println("CPU Usage : " + String.format("%.2f", osBean.getSystemCpuLoad() * 100));
//			
//			double usedCPU = osBean.getSystemCpuLoad();
//			CPUData = String.format("%.2f", osBean.getSystemCpuLoad() * 100);
			Gson gson = new Gson();
			TextMessage textMessage = new TextMessage(CPUData);
			webSocketSession.sendMessage(textMessage);
		}

		super.handleMessage(session, message);
	}

}
