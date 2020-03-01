package SamplePrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionSample {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> arrayList2D = new ArrayList<ArrayList<String>>();
		arrayList2D.add((ArrayList<String>) Arrays.asList("r1c1", "r1c2","r1c3"));
		arrayList2D.add((ArrayList<String>) Arrays.asList("r2c1", "r2c2","r2c3"));
		
		System.out.println(arrayList2D.get(1));
	}
	
	/*public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>() {{
		    add(new ArrayList<>(Arrays.asList(1,2,3,4)));
		    add(new ArrayList<>(Arrays.asList(5,6,7,8)));
		    add(new ArrayList<>(Arrays.asList(9,10,11,12)));
		}};
		lists.add(Arrays.asList(13, 14, 15, 16));
		//lists.remove(3);
		//System.out.println(lists);
		
		List<List<Integer>> lists1 = new ArrayList<List<Integer>>();
		lists1 = lists;
		
		for(int i=0; i<lists.size(); i++) {
			for(int j=0; j<lists.size(); j++) {
				System.out.print(lists.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
		System.out.println("**************************");
		
		for(int i=0; i<lists1.size(); i++) {
			for(int j=0; j<lists1.size(); j++) {
				System.out.print(lists1.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}*/
}
