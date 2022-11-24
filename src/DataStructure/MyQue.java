package DataStructure;

import java.util.List;

import org.apache.log4j.Logger;

import java.util.LinkedList;

public class MyQue {
	
	
	private static MyQue singletonMyQue = new MyQue();
	
	private static int capacity = 10 ;
	
	private static List<Integer> list = new LinkedList<>();
	
	private int count;  // 현재 저장된 데이터 수

	private static final Logger logger = Logger.getLogger(MyStack.class);

	private MyQue() {};
	
	
	
	// 싱글톤 객체 getter 메서드
	
	public static MyQue getInstance() {
		return singletonMyQue;
	}
	
	
	public void setCapacity(int capacity) {
		
		this.capacity = capacity;
	}
	
	
	
public void enque(Integer obj) {
		
		synchronized(this) {
			
				while(getCount() >= capacity) {
					
					logger.debug("MyQue에 객체를 넣으려고 했으나 용량이 차서 기다립니다.");

					
					try {
						wait();
					} catch (InterruptedException ex) {
						return;
					}
				} 
				
				
				add(obj);
				int value = obj.intValue();
				logger.debug("MyQue에 "+ value+"를 집어넣었습니다. 현재 Que Size는 "+ getCount()+"개 입니다.");

				notifyAll();


			}
			
			
			
		}

	
	
/*
	public void enque(Integer obj) {
		
		synchronized(this) {
			
			
			if ( getCount() < capacity) {
				
				add(obj);
				notifyAll();

			} else {
				while(getCount() >= capacity) {
					
					logger.debug("MyQue에 객체를 넣으려고 했으나 용량이 차서 기다립니다.");

					
					try {
						wait();
					} catch (InterruptedException ex) {
						return;
					}
				} 
				logger.debug("꽉 차있던 MyQue에 빈 공간이 확보되었습니다. 현재 용량은 "+getCount()+"개입니다.");// 새로운 객체를 추가하겠습니다.");

               
				//add(obj);
				//notifyAll();
				
			}
			
			
			
		}
		
	}*/
public Integer deque() {
		
		synchronized (this) {

				while(getCount()==0 ) {
					
					logger.debug("객체를 꺼내려던 중 MyQue가 텅 비어서 기다립니다.");

					try {
						wait();
					} catch (InterruptedException ex) {
						System.out.print(ex);
					}
				}
				
				Integer obj = remove();
				//int value = obj.intValue();
				//logger.debug("MyQue에서 "+ value+"를 꺼냈습니다. 현재 Que Size는 "+ getCount()+"개 입니다.");

				notifyAll();

				
				return obj;
				
			}		
		
	}
	
	/*
	public Integer deque() {
		
		synchronized (this) {
			
			if(getCount() > 0) {
				
				Integer obj = remove();
				notifyAll();

				
				return obj;
				
			} else {
				
				while(getCount()==0 ) {
					
					logger.debug("객체를 꺼내려던 중 MyQue가 텅 비어서 기다립니다.");

					
					try {
						wait();
					} catch (InterruptedException ex) {
						System.out.print(ex);
					}
				} //logger.debug("MyQue가 비어서 기다리던 중 새로운 객체가 확보되어 꺼내겠습니다." );
				
				
					Integer obj = new Integer(-1);
				   
					return obj;
			}		
		
	}
}*/
	
	
	// 현재 저장중 데이터 수 반환 메서드
	public int getCount() {
		count  = list.size();
		return count;
	}
	
	
	//  Que에 데이터를 넣기 위해 enque 메서드 내에서 호출하는 메서드 
	private void add(Integer obj) {
		list.add(obj);
	}
	
//  Que에서 첫번째 인덱스의 데이터를 꺼내기 위해 deque 메서드 내에서 호출하는 메서드 
	private Integer remove() {
		
		
		Integer obj = list.remove(0);
		
		return obj;
		
	}
	
	
	
	
	
	

}
