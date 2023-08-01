package com.lumen.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class States {
	public static void main(String[] args) {
		Map<String, List<String>> states = new HashMap<>();
		states.put("Karnataka", Arrays.asList("Bangalore","Hubli","Dharwad","Ooty"));
		states.put("Himachal Pradesh", Arrays.asList("Shimla","Dharamshala","Khulu","Manali","Bir"));
		states.put("Dheli", Arrays.asList("Majnu Ka Tilla","New Dheli","Noida","Oompa"));
		
		Set<Map.Entry<String, List<String>>> mapEntries = states.entrySet();
		for(Map.Entry<String, List<String>> mapEntry: mapEntries) {
			System.out.println("State : "+mapEntry.getKey());
			System.out.print("Cities: ");
			mapEntry.getValue().forEach(city->System.out.print(city+" "));
			System.out.println();
		}
	}
}
