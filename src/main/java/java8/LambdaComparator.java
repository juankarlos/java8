package java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaComparator {

	public static void main(String[] args) {
		
		List<Developer> listDevs = getDevelopers();

		System.out.println("****************************************");
		System.out.println("Before Sort");
		printDevelopers(listDevs);
		
		System.out.println("\n\n****************************************");
		System.out.println("Before java 8");
		beforeJava8Sort(listDevs);
		
		System.out.println("\n\n****************************************");
		System.out.println("After java 8");
		LambdaSort(listDevs);
	}
	
	private static List<Developer> getDevelopers() {

		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("tesla", new BigDecimal("7000"), 33));
		result.add(new Developer("araya", new BigDecimal("8000"), 20));
		result.add(new Developer("juan", new BigDecimal("10000"), 10));
		result.add(new Developer("carlos", new BigDecimal("200000"), 55));

		return result;

	}
	
	public static void printDevelopers(List<Developer> listDevs) {
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}
	}
	
	/**
	 * Classic sort using collections before Java 8.
	 * @param listDevs
	 */
	public static void  beforeJava8Sort(List<Developer> listDevs) {
		
		//sort by age
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getAge() - o2.getAge();
			}
		});
	
		System.out.println("\nAfter Sort by age: ");
		printDevelopers(listDevs);
		
		//sort by name
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		System.out.println("\nAfter Sort by name: ");
		printDevelopers(listDevs);
		
		//sort by salary
		Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getSalary().compareTo(o2.getSalary());
			}
		});		
		System.out.println("\nAfter Sort by salary: ");
		printDevelopers(listDevs);
			
	}
	
	/**
	 * Sort with Lambda after java 8.
	 * @param listDevs
	 */
	public static void LambdaSort(List<Developer> listDevs) {
		

		System.out.println("\nAfter Sort by age: ");

		// Option 1
		//listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());

		// Option 2
		listDevs.sort((o1, o2)->o1.getAge() - o2.getAge());
		printLambdaList(listDevs);
		
		
		System.out.println("\nAfter Sort by name: ");

		// Option 1
		//listDevs.sort((Developer o1, Developer o2)->o1.getName().compareTo(o2.getName()));
		
		// Option 2
		listDevs.sort((o1, o2)->o1.getName().compareTo(o2.getName()));		
		printLambdaList(listDevs);
		
		System.out.println("\nAfter Sort by salary: ");

		// Option 1
		//listDevs.sort((Developer o1, Developer o2)->o1.getName().compareTo(o2.getName()));
		
		// Option 2
		listDevs.sort((o1, o2)->o1.getSalary().compareTo(o2.getSalary()));
		
		// Option 3
		//Comparator<Developer> salaryComparator = (o1, o2)->o1.getSalary().compareTo(o2.getSalary());
		//listDevs.sort(salaryComparator);
		
		printLambdaList(listDevs);
		
		System.out.println("\nAfter Sort by salary in reversed order: ");
		Comparator<Developer> salaryComparator = (o1, o2)->o1.getSalary().compareTo(o2.getSalary());
		listDevs.sort(salaryComparator.reversed());
		printLambdaList(listDevs);
	}

	private static void printLambdaList(List<Developer> listDevs) {
		listDevs.forEach((developer) -> System.out.println(developer));
	}
	
}