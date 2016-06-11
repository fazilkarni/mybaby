import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		ConcurrentHashMap map = new ConcurrentHashMap();
		map.put("a","fazil");
		map.put("karni", null);
		
		System.out.println(map.get("a"));

	}

}
