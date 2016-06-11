import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkarni.stock.bo.StockBo;
import com.mkarni.stock.model.Stock;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Free memory at teh begining"+Runtime.getRuntime().freeMemory());
    	System.out.println("Hello");
    	ApplicationContext appContext = 
    	  new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	
    	StockBo stockBo = (StockBo)appContext.getBean("stockBo");
    	
    	/** insert **/
    	Stock stock = new Stock();
    	int random = (int) (Math.random()*1000);
    	stock.setStockCode("1"+random);
    	stock.setStockName("HAIO"+random);
    	stockBo.save(stock);
    	
//    	/** select **/
//    	Stock stock2 = stockBo.findByStockCode("7668");
//    	System.out.println("new stock create"+stock2);
//    	
//    	/** update **/
//    	stock2.setStockName("HAIO-1");
//    	stockBo.update(stock2);
//    	
//    	/** delete **/
//    	stockBo.delete(stock2);
    	ArrayList a = new ArrayList();
    	try{
    		System.out.println("Before loops");
    		for(long i =0;i<1000000000;i++){
    			App app = new App();
    			a.add(app);
    		}
    		
    		for(long i =0;i<1000000000;i++){
    			App app = new App();
    			a.add(app);
    		}
    		
    		for(long i =0;i<1000000000;i++){
    			App app = new App();
    			a.add(app);
    		}
    		
    		for(long i =0;i<1000000000;i++){
    			App app = new App();
    			a.add(app);
    		}
    		
    		for(long i =0;i<1000000000;i++){
    			App app = new App();
    			a.add(app);
    		}
    		
    	}catch(Throwable excecptio){
    		System.out.println("OutofMemory exception");
    		a = null;
    		
    		System.out.println("Free memory"+Runtime.getRuntime().freeMemory());
    		System.gc();
    	}
//    	A = NEW ARRAYLIST();
//    	FOR(LONG I =0;I<1000000000;I++){
//			APP APP = NEW APP();
//			A.ADD(APP);
//		}
    	System.out.println("Done");
    	System.out.println("Free memory"+Runtime.getRuntime().freeMemory());
    	System.out.println("Send fatal mails to sys admin");
    }
}