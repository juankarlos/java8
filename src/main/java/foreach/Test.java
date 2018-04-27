package foreach;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);
		
		System.out.println("Old for each: ");
		oldForeach(items);
		
		System.out.println("\n\nNew for each: ");
		newForEach(items);
		
	}
	
	private static void newForEach(Map<String, Integer> items) {
		
		System.out.println("1. Inline: ");
		items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));
		
		System.out.println("\n\n2. More logic: ");
		items.forEach((k,v)->{
			System.out.println("Item : " + k + " Count : " + v);
			if("E".equals(k)){
				System.out.println("Hello E");
			}
		});
		
	}

	public static void oldForeach(Map<String, Integer> items) {
		for (Map.Entry<String, Integer> entry : items.entrySet())
			System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
	}

}