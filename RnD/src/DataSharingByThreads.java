
public class DataSharingByThreads {

	public static void main(String[] args) {
		Temp temp = new Temp();
		Task t1 = new Task(temp);
		Task t2 = new Task(temp);
		Task t3 = new Task(temp);
		Task t4 = new Task(temp);
		t1.start();
		try {
			t1.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
		t3.start();
		t4.start();
		


	}

}

class Temp{
	public volatile int tempValue;
	public  int nonVolatileTempValue;
}

class Task extends Thread{
	Temp temp;
	public Task(Temp temp){
		this.temp=temp;
	}
	public  volatile int sharedData;
	public int nonShared;
	@Override
	public void run() {
		temp.tempValue++;
		temp.nonVolatileTempValue++;
		
		System.out.println(Thread.currentThread().getName()+" volatile  :  "+temp.tempValue+" NonVolatile :"+temp.nonVolatileTempValue);
		
		
	}
	
}