package DataStructure;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import java.util.Properties;

public class MyStack {
	
	
    private static MyStack singletonMyStack = new MyStack();
    
    //저장용량 
	private static int capacity = 10 ;

	// 데이터가 담길 private 정적 인스턴스 생성 
	private static List<Integer> list = new ArrayList<>(); 
		
	private static final Logger logger = Logger.getLogger(MyStack.class);
	//private static Properties logProperties = new Properties();
	
	
	//생성자 메서드
	private MyStack() {};
	
	
	// 싱글톤 객체 getter 메서드
	
	public static MyStack getInstance() {
		return singletonMyStack;
	}
	
	public void setCapacity(int capacity) {
		
		this.capacity = capacity;
	}

	public void push(Integer obj) {
		
		synchronized (this) {
						

				while(getCount() >=capacity) {
					
					
					logger.debug("MyStack에 객체를 넣으려고 했으나 용량이 차서 기다립니다. 현재 갯수: " + getCount());
					
					try {
						wait();
					} catch (InterruptedException ex) {
						return;
					}	
					
				}
				
				add(obj);
				int value = obj.intValue();

				logger.debug("MyStack에 " + value+"를 집어넣었습니다.");
				
				//count가 0인 경우 (비어있는 경우) 객체 추가 후 기다리는 converter 스레드에게 알려줌
				notifyAll();

			}
		
	}	
	
	
	public Integer pop() {
		
		synchronized (this) {
			
				
				while(getCount()==0 ) {
					
					logger.debug("객체를 꺼내려던 중 MyStack이 텅 비어서 기다립니다.");

					
					try {
						wait();
					} catch (InterruptedException ex) {
						System.out.print(ex);
					}
					
				} 
					Integer obj = remove();
					int value = obj.intValue();
					logger.debug("MyStack에서 "+ value + "를 꺼냈습니다. Stack 빈공간을 기다리는 Producer를 깨우겠습니다");
					notifyAll();
					return obj;
			}		
		
		
	}
	
	
	// 현재 저장중 데이터 수 반환 메서드
	public int getCount() {
		int count  = list.size();
		return count;
	}
	
	//  Stack에 데이터를 넣기 위해 push 메서드 내에서 호출하는 메서드 
	private void add(Integer obj) {
		list.add(obj);
	}
	
	//Stack에서 데이터를 꺼내기 위해 pop 메서드 내에서 호출하는 메서드
	private Integer remove() {
		
		
		int index = getCount() - 1 ;
		
		Integer obj = list.remove(index);
		
		return obj;
		
	}
	
	
	
}
