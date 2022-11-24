package Threads;

import org.apache.log4j.Logger;

import DataStructure.MyQue;
import DataStructure.MyStack;

public class Consumer extends Thread{
	
	private MyQue que;
	private static final Logger logger = Logger.getLogger(Consumer.class);

	
	public Consumer(MyQue que) {
		
		this.que = que;
	}
	
	
	public void run() {
		
		while(true) {
			
			Integer obj = que.deque();
	
			int value = obj.intValue();
			
			
			logger.debug("Consumer가 "+ value+ "를 큐에서 꺼냈습니다.");
			
			
			//String threadName = Thread.currentThread().getName();
			
			//System.out.println(threadName + " Consumer :"+ value);
			
		}
	}

}
