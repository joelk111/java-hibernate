package com;

import java.util.Arrays;

public class SortArrays {

	
	static int[] inputArray= new int [] {0, 1, 2, 0, 1, 2};
	
	static int[] arr= new int [] {0, 1, 2, 3, 4, 5};
	
	public static void swap(int a, int b) {
		
		//TEMP - A -B
		
		/**
		 * 1. TEMP-declare a temp variable that the array with the value to be swapped array[a]
		 * 2. SWAP A to b, array[a] = array[b]
		 * 3. SET B  to temp (where the previous value of a exists)
		 */
		
		int temp = inputArray[a]; //create a temp value to hold array[a] that we will replace
		inputArray[a] = inputArray[b]; //a-easy, just set this element to the new value  
		inputArray[b] = temp;   //as b does not exist for its value, we have to use the temp value
		
		
		
		
		
		//(x%2)==0 EVEN
		
	}
	
	
	
	public static void main(String[] args) {

		
		
		
		int[]  result =rotate(arr, 3);
		
		
		System.out.println(Arrays.toString(result));
		
		
		
		//Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last
		/*swap(1,2);
		

		System.out.println(Arrays.toString(arr1));
		*/
		
		//Collections.reverse(Arrays.asList(array));
		
		String data ="how are you";
		String[] arrArray = data.split(" ");
		
        String temp;
        
        // Iterate over only half of the inputArray (inputArray.length / 2)
        
        
        //REVERSE AN ARRAY
        for (int i = 0; i < arrArray.length/2; i++) 
        {
            
        	//For every ith element, swap it with (inputArray.length-1-i)th element.
        	
        	temp = arrArray[i];  //TEMP
             
        	//use arrArray.length - 1 when you need to access the last element.
            arrArray[i] = arrArray[arrArray.length-1-i];   //SWAP
             
            arrArray[arrArray.length-1-i] = temp;           //SET
        }
         
        System.out.println("Array After Reverse : "+Arrays.toString(arrArray));
		
		
		int arr[] = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int n = arr.length;
	
		rearrangeEvenAndOdd(arr, n);
	
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
		
        


	
	/**FIND EQUAL SUM OF ELEMENTS IN AN ARRAY
	 * 
	 * We calculate the sum of the whole array except the first element in right_sum, 
	 * considering it to be the partitioning element. Now, we traverse the array from left to right, 
	 * subtracting an element from right_sum and adding an element to left_sum. 
	 * 
	 * The point where right_sum equals left_sum, we get the partition
	 * @param arr
	 * @param size
	 * @return
	 * 
	 * 
	 * STEPS
	 * 
	 * 1. SUM THE RIGHT SIDE AND ITERATE- except 1, so we have int i=1
	 * 2. SUM THE LEFT- except j =1
	 * 
	 * 
	 * 
	 *
	 */
	
	
	
	   // Function to compute partition
    static int findElement(int arr[], int size)
    {
        int right_sum = 0, 
        left_sum = 0;
      
        // Computing right_sum
        for (int i = 1; i < size; i++)
            right_sum += arr[i];
      
        // Checking the point of partition
        // i.e. left_Sum == right_sum
        for (int i = 0, j = 1; j < size; i++, j++) {
            right_sum -= arr[j];
            left_sum += arr[i];
      
            if (left_sum == right_sum)
                return arr[i + 1];
        }
      
        return -1;
    }

    
 // fuction is rearrange the array in given way.
    

    
    /** RE-ARRANGE EVEN AND ODD IN AN ARRAY
     * 
     * 
		A Lomuto partition based scheme to segregate
     */
    

 	static void rearrangeEvenAndOdd(int arr[], int n)
 	{
 		// create variables, a temp variable for the swap and a index called j
 		int j = -1;  //this has to start at -1 so the first iteration is a 0 for an array
 		int temp;
 	
 		// quick sort method
 		for (int i = 0; i < n; i++) {
 	
 			// if array of element
 			// is odd then swap
 			if (arr[i] % 2 == 0) {
 	
 				// increment j by one
 				j++;
 	
 				// swap the element
 				temp = arr[i];
 				arr[i] = arr[j];
 				arr[j] = temp;
 			}
 		}
 	}
    
 	
 	/**rotate/shift an array in place
 	 * 
 	 * @param nums
 	 * @param k
 	 * @return
 	 */
	public static int[] rotate(int[] nums, int k) {
		
		//1. CREATE NEW ARRAY to hold the data based on the old arrays length
        int[] a = new int[nums.length];
        
        
        //2 ITERATE over the Array and set the values to a[i+k%nums.legnth]
        
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }

        
        //Arrays.copyOf takes args as the array to copy and the legnth
        a=Arrays.copyOf(nums, nums.length);
        
        
     
		return a;
    }

}
