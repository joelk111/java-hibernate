package com;

import java.util.HashMap;
import java.util.Stack;

public class BalancedParams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean result =isBalanced("(asdfasdf)");
System.out.println(result);
	}
	
	
	
	 static boolean isBalanced(String s) {
	        
	        Stack stack = new Stack();
	        HashMap<Character, Character> map = new HashMap();
	    	map.put('(', ')');
	    	map.put('[', ']');
	    	map.put('{', '}');
	        
//here we divide the map into KEY open and VALUE closed
	        
	        char [] stringChar = s.toCharArray();  //convert the string to an array
	        
	        
	        
	        //remember the middle is a boolean test
	        for(int i=0; i<stringChar.length; i++){
	            
	        	char current = stringChar[i];  //create a variable called current
	        	
	        	
	        	
	        	if(map.isEmpty()){
	        		
	        		return false;
	        	}
	        	
	        	if (map.keySet().contains(current)){  ///check the key which is teh open param

	        		 stack.push(current);  //to access teh value, remember to referecne the array name inside of loop
	        		 
	        		 
	        	 }
	        	 
	        	
	        	
	        	else if (map.containsValue(current)){  //now we check for the closed
	        		
	        		return true;
	        		//if the 
	        		
/*	        		if(map.get(stack.peek()) == current){
	        			
	        			stack.pop();
	        		}
	        		*/
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        		
	        	}
	        	 
	        	 
	        	 
	        	 
	        	 
	        	 
	        	 
	        	 
	        	 
	        	 
	            
	            
	            
	        }
			return false;

	        
	        
	        
	        
	        // Complete this function
	    }
	
	
	 
	   public void rotate(int[] nums, int k) {
	        int[] a = new int[nums.length];
	        for (int i = 0; i < nums.length; i++) {
	            a[(i + k) % nums.length] = nums[i];
	        }
	        for (int i = 0; i < nums.length; i++) {
	            nums[i] = a[i];
	        }
	    }

}
