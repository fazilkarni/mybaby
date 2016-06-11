import java.util.concurrent.ConcurrentHashMap;

public class VariableArgs {

	public static void main(String[] args) {
		VariableArgs s = new VariableArgs();
		s.variableArgsTest("a","b","c");
		
		ConcurrentHashMap c = new ConcurrentHashMap();
		c.put("s", "s");


	}
	
	public void variableArgsTest(String...strings ){
		
		for(String s: strings){
			System.out.println(s);
		}
	}

}
