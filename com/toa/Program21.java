package com.toa;

import java.util.Arrays;
import java.util.List;

public class Program21 {
	
		public static void main(String args[]) {
		
			    List<Integer> arr = Arrays.asList(5, 1, 10, 100, 10, 15,6,9,4,3,2);
				System.out.println("The max product of subArray is: " +maxSubarrayProduct(arr));
		}
	
		static int maxSubarrayProduct(List<Integer> nums) {
        
			int result = nums.get(0);
			int n = nums.size();

			for (int i = 0; i < n; i++) {
				int mul = nums.get(i);
           
				for (int j = i + 1; j < n; j++) {
                
					result = Math.max(result, mul);
					mul *= nums.get(j);
				}
          
            result = Math.max(result, mul);
        }
        return result;
    }
}
