package Threads;

import DataStructure.MyStack;
import java.util.Random;

public class Producer  extends Thread{

	private MyStack stack;
	private static Random rand = new Random();
		
	public Producer(MyStack stack) {
		this.stack = stack;
	} 
	

	//0~99까지 정수 한개를 랜덤하게 생성해 Integer객체로 반환하는 메서드
	private Integer generateData() {
		
	 int randInt =rand.nextInt(100);
	 Integer obj = new Integer(randInt);
	 return obj;
	}
	
	@Override
	public void run() {
		while (true) {
			
		  Integer obj = generateData();
		  stack.push(obj);
		  
		}
	}
	
}


/*
public void push(int data) {
	
	synchronized (stack) {
					
		Integer obj = new Integer(data);

		if (stack.getCount() < MyStack.capacity ) {
			
			
			stack.add(obj);
			stack.notifyAll();
			
		} else {
			while(stack.getCount() >= MyStack.capacity) {
				
				try {
					stack.wait();
				} catch (InterruptedException ex) {
					return;
				}			
			} stack.add(obj); 
			stack.notifyAll();

			
		}
		

	}
}*/
