import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockAndConditionThreadCommunication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue q = new BlockingQueue(10);
		Lock lock = new ReentrantLock();
		Consumer10 c1 = new Consumer10(q,"thread1",lock);
		Consumer10 c2 = new Consumer10(q,"thread2",lock);
		Consumer10 c3 = new Consumer10(q,"thread3",lock);
		Consumer10 c4 = new Consumer10(q,"thread4",lock);
		Producer10 p = new Producer10(q,"Producer",lock);
		
		c1.start();
		p.start();
		
	}

}

class Consumer10 extends Thread{
	BlockingQueue q;
	
	
	public  Consumer10(BlockingQueue q,String name,Lock lock){
		super(name);
		this.q = q;
		q.subscribe(name,lock.newCondition());
	}
	
	
	
	public void run(){
		
		while(true){
			try {
				System.out.println(" Consumed "+q.dequeue());
				Thread.currentThread().sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

class Producer10 extends Thread{
	BlockingQueue q;
	public Producer10(BlockingQueue q,String name,Lock lock){
		super(name);
		this.q = q;
		q.subscribe(name,lock.newCondition());
	}
	
	public void run(){
		
		while(true){
			try {
				double p = Math.random()*100;
				System.out.println(" Product added "+p);
				q.enqueue("Product"+p);
				//Thread.currentThread().sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}


 class BlockingQueue {
	 Map<String,Condition> threads = new HashMap<String,Condition>();
	  private List queue = new LinkedList();
	  private int  limit = 10;

	  public BlockingQueue(int limit){
	    this.limit = limit;
	  }

	  public void subscribe(String threadName,Condition condition){
		  threads.put(threadName, condition);
	  }
	  public void enqueue(Object item)
	  throws InterruptedException  {
	    while(this.queue.size() == this.limit) {
	    	System.out.println("Wating to have items be consumed");
	      Condition condition = threads.get("thread2");
	      condition.signal();
	    }
	    if(this.queue.size() == 0) {
	    	threads.get("producer").await();;
	    }
	    this.queue.add(item);
	  }


	  public synchronized Object dequeue()
	  throws InterruptedException{
	    while(this.queue.size() == 0){
	    	System.out.println("Wating to have items in Q");
	      wait();
	    }
	    if(this.queue.size() == this.limit){
	      notifyAll();
	    }

	    return this.queue.remove(0);
	  }

	}
