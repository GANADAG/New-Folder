package day0115;

import java.util.LinkedList;
import java.util.Queue;

public class Message {
	
	public String command;
	public String to;
	
	public Message(String command,String to)
	{
		this.command=command;
		this.to=to;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//컬렉션 생성
		Queue<Message> messageQueue = new LinkedList<>();
		
		//메세지 넣기
		messageQueue.offer(new Message("sendMail","홍길동"));
		messageQueue.offer(new Message("sendSMS","신용권"));
		messageQueue.offer(new Message("sendKAKAO","김자바"));
	}
	
	

}
