
public class DeadLockCreationAndAvoiding extends Thread{
	
	private MyClass obj;
	public DeadLockCreationAndAvoiding(MyClass obj){
		this.obj = obj;
	}
	public static void main(String[] args) {
		/*MyClass obj1 = new MyClass();
		//MyClass obj2 = new MyClass();
		
		DeadLockCreationAndAvoiding t1 = new DeadLockCreationAndAvoiding(obj1);
		DeadLockCreationAndAvoiding t2 = new DeadLockCreationAndAvoiding(obj1);
		t1.start();
		t2.start();*/
		
		hunderedMeterRaceTest();
		
	}
	
	public static void hunderedMeterRaceTest(){
		HundredMetersTrack obj = new HundredMetersTrack();
		
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		t1.start();
		t2.start();
	}
	

	@Override
	public void run() {
		obj.aMethod();
		obj.bMethod();

	}
	
	

}

class MyClass{
	public MyClass(){
		System.out.println("Object of MyClass created.");
	}
	public synchronized void aMethod(){
		
		synchronized (String.class) {
			System.out.println("in aMethod String.class lock obtained by"+Thread.currentThread().getName());
			
			synchronized (Integer.class) {
				System.out.println("in aMethod Integer.class lock obtained"+Thread.currentThread().getName());
				
			}
			
		}
		
	}
	
public  void bMethod(){
		
		synchronized (Integer.class) {
			System.out.println("in bMethodInteger.class lock obtained"+Thread.currentThread().getName());
			
			
			synchronized (String.class) {
				System.out.println("in bMethod String.class lock obtained"+Thread.currentThread().getName());
				
			}
			
		}
		
	}
}

class HundredMetersTrack implements Runnable{
	public ThreadLocal tl = new ThreadLocal();
	@Override
	public void run() {
		for(int i=0;i<=1000;i++){
			tl.set(i);
			if((Integer)tl.get()==10 ){
					System.out.println(Thread.currentThread().getName());
				}
			}
		}
		
	}

