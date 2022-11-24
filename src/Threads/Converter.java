package Threads;

import DataStructure.MyStack;

import org.apache.log4j.Logger;

import DataStructure.MyQue;


public class Converter extends Thread{
	
	private MyStack stack;
	private MyQue que;
	private static final Logger logger = Logger.getLogger(Converter.class);


	
	public Converter(MyStack stack, MyQue que) {
		this.stack = stack;
		this.que = que ;
	}
	

@Override
public void run() {
	
	while(true) {
		
		Integer obj = stack.pop();
		
		//int value = obj.intValue();

		//logger.debug("Stack에서 꺼낸 " + value+"를 Que에 집어넣겠습니다.");
		
		que.enque(obj);


		//print(obj);
		 
	}
}
	
}
/*
public Integer pop() {
	
	synchronized (stack) {
		
		if(stack.getCount() > 0) {
			
			Integer obj = stack.pop();
			stack.notifyAll();

			
			return obj;
			
		} else {
			
			while(stack.getCount()==0 ) {
				
				try {
					stack.wait();
				} catch (InterruptedException ex) {
					System.out.print(ex);
				}
			} 
				Integer obj = stack.pop();
				stack.notifyAll();

				
				return obj;
		}		
	
}
	
}

private void print(Integer obj) {

    String threadName = Thread.currentThread().getName();
	
	int data = obj.intValue();
	
	//System.out.println(data + " , 스레드 이름: "+threadName);

} */
