package DataStructure;


import org.apache.log4j.Logger;

public class MyStack2 {
   private static Logger logger = Logger.getLogger(MyStack2.class);
   
   private int top = -1;
   private Integer[] myStack = new Integer[10];
   
   private MyStack2() {}
   
   private static class lazyHolder {
      private static final MyStack2 instance = new MyStack2();
   }
   
   public static MyStack2 getInstance() {
      return lazyHolder.instance;
   }
   
   public synchronized void push(int i) {
      if(top == myStack.length - 1) {
         logger.info("----------------스택이 가득 찼습니다. 스레드를 일시정지합니다.----------------");
         try {
            wait();
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      } else {
         myStack[++top] = i;
         notifyAll();
         logger.info("push 값 : " + i);
      }
   }
   
   public synchronized int pop() {   
      if(isEmpty()) {
         logger.info("----------------스택이 비어 있습니다. 스레드를 일시정지합니다.----------------");
         try {
            wait();
         } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         return -1;
      } else {
         int temp = myStack[top];
         myStack[top--] = null;
         logger.info("pop 값 : " + temp);
         notifyAll();
         return temp;
      }
   }
   
   public boolean isFull() {
      return top == myStack.length - 1;
   }
   
   public boolean isEmpty() {
      return top == -1;
   }
   
   public Integer[] show() {
      return myStack;
   }
}