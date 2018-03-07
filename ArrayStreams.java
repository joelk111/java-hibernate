package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayStreams {

	public static void main(String[] args) {
	
		//https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html
		
		int [] arr1= new int[]{1,2,3,4,5,1,1,1};
		int [] arr2= new int[]{1,2,3,4,5,1,1,1};
		
		
		
	       List  mylist = new ArrayList();
	        mylist.add(1);
	        mylist.add(2);
	        mylist.add(3);
	        mylist.add(3);
	        mylist.add(8);
	        mylist.add(8);
	        mylist.add(8);
		
	        
	        
	    //multiply two arrays
	        
	        int[] result = IntStream.range(0, arr1.length).map(i -> arr1[i] * arr2[i]).toArray();
	                       //an IntStream for a range in teh array

		
	        
	    IntSummaryStatistics summary = IntStream.range(0, arr1.length).map(i -> arr1[i] * arr2[i]).summaryStatistics();
	      // System.out.println( summary.getCount());
	        
	// Object data = mylist.stream().filter(i -> Collections.frequency(mylist, i) >1).collect(Collectors.toSet());
	
	    
	    IntStream.range(0, arr1.length).iterator().hasNext();
	    
	    
	 
	     //get duplicates   
	        Integer[] numbers = new Integer[] { 1, 2, 1, 3, 4, 4 };
	 
	 Set<Integer> allItems = new HashSet<>();
	 Set<Integer> duplicates = Arrays.stream(numbers)
	         .filter(n -> !allItems.add(n)) //Set.add() returns false if the item was already in the set.
	         .collect(Collectors.toSet());
	 System.out.println(duplicates); // [1, 4]
	 
	 
	 Arrays.parallelSetAll( arr1, x -> x * 100 );
	 
	 

	 Arrays.parallelSort( arr1 );
	 
	 Arrays.parallelPrefix( arr1, ( x, y ) -> x + y );


	// also using parallel streams
	 Arrays.stream( arr1 ).filter( x -> x > 10 ).parallel().forEach( System.out::println );
	 
	 
	 
		
	 //Collections.rotate(arr, 10);
	
	}
	
	
	public static boolean isPrime(int number) {  //range from 2 -> number/2
		return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
	}
	
	//Create new array and copy the data from the old one with an offset:
	int[] rotate(final int[] unOrderedArr, final int orderToRotate) {
	    final int length = unOrderedArr.length;
	    final int[] rotated = new int[length];
	    for (int i = 0; i < length; i++) {
	        rotated[(i + orderToRotate) % length] = unOrderedArr[i];
	    }
	    return rotated;
	}

}
