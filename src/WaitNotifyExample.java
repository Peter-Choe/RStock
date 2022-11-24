import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import DataStructure.MyStack;
import Threads.Converter;
import Threads.Producer;
import DataStructure.MyQue;
import Threads.Consumer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class WaitNotifyExample {

	private static final Logger logger = Logger.getLogger(WaitNotifyExample.class);
	private static Properties properties = new Properties();
	private static Properties logProperties = new Properties();

    private static MyStack stack = MyStack.getInstance();
    private static MyQue que = MyQue.getInstance();
    
    private static int threadPoolMaxValue;
    private static int myStackCapacity;
    private static int myQueCapacity;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	try {
		logProperties.load(new FileInputStream("src/log4j.properties"));
		PropertyConfigurator.configure(logProperties);
		logger.info("Stack-Que 프로그램이 실행되었습니다");
		
		properties.load(new FileInputStream("src/config.properties"));

	} catch (FileNotFoundException e) {
		logger.error("Properties 파일이 존재하지 않습니다.", e);

	} catch (IOException e) {
		logger.error("Properties 파일을 읽어오는 과정에서 오류가 발생하였습니다.", e);

	}	
	try {
		threadPoolMaxValue = Integer.parseInt(properties.getProperty("threadPoolMaxValue"));
		myStackCapacity = Integer.parseInt(properties.getProperty("myStackCapacity"));
		myQueCapacity = Integer.parseInt(properties.getProperty("myQueCapacity"));
	} catch (Exception e) {
		logger.error("설정값을 읽어오던 중 에러가 발생했습니다.", e);
	}

	
	stack.setCapacity(myStackCapacity);
    que.setCapacity(myQueCapacity);
	
	ExecutorService executorProducer = Executors.newFixedThreadPool(threadPoolMaxValue);
	ExecutorService executorConverter = Executors.newFixedThreadPool(threadPoolMaxValue);
	ExecutorService executorConsumer = Executors.newFixedThreadPool(threadPoolMaxValue);

		
     for (int i=0; i< threadPoolMaxValue+1 ; i++) {
         Producer producer = new Producer(stack);
         Converter converter = new Converter(stack, que);
         Consumer consumer = new Consumer(que);
         
         executorProducer.submit(producer);
         executorConverter.submit(converter);
         executorConsumer.submit(consumer);
         
     }
     
     //print();
    
	}
/*
 public static void print() {
    	 
     
     while (true) {
    	 
    	 int stackCount = stack.getCount();
    	 int queCount = que.getCount();
    	 
    	 logger.debug("MyStack 현재 갯수: "+stackCount);
    	 logger.debug("MyQue 현재 갯수: "+queCount);

    	 try {
        	 Thread.sleep(3000);

    	 } catch (InterruptedException e) {
    		 
    	 }
    	 
     } 
     


}*/
}
