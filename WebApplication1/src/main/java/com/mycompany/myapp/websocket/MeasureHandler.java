package com.mycompany.myapp.websocket;

import java.util.List;
import java.util.Vector;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class MeasureHandler extends TextWebSocketHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(MeasureHandler.class);
	// 멀티스레드 환경에서 사용하기 위하여 vector 활용!
	private List<WebSocketSession> list = new Vector<>();

	@PostConstruct
	public void init() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				int temperature = 0;
				while (true) {
					try {
						for (WebSocketSession session : list) {
							session.sendMessage(new TextMessage(String.valueOf(++temperature)));
						}
						Thread.sleep(1000);
					} catch (Exception e) {
					}
				}
			}
		};
		thread.start();
	}

	// 메소드 이름 = 이 메소드가 언제 시행할지
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		LOGGER.info("");
		list.add(session);
	}

	// 연결이 끊어진 후 시행
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		LOGGER.info("");
		list.remove(session);
	}

	// 메시지를 받았을 때 시행
	// 여기서 사용하는 session은 HTTPSession이 아님!명심하자!
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		LOGGER.info("");
		String strMessage = message.getPayload();
		TextMessage txtMessage = new TextMessage(strMessage);
		session.sendMessage(txtMessage);
	}
}