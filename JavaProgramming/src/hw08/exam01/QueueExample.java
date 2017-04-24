package hw08.exam01;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		Queue<Message> queue = new LinkedList<Message>();
		
		queue.offer(new Message("SendMail", "Hong"));
		queue.offer(new Message("SendSMS", "Shin"));
		queue.offer(new Message("SendKakaoTalk", "Hong"));
		
		while(!queue.isEmpty()) {
			Message message = queue.poll();
			switch(message.command) {
			case "SendMail":
			case "SendSMS" :
				
			}
		}
	}

}
