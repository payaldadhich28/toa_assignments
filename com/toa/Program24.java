package com.toa;

import java.util.Arrays;
import java.util.List;

public class Program24 {

		public static void main(String[] args) {
	
				List<Integer> arr = Arrays.asList(5, 1, 10, 100, 10, 15, 6, 9, 4, 3, 2);
				System.out.println("The max sum of subArray is: " +findMaxSum(arr, 0, arr.size(), 6));
		}
	
		static int findMaxSum(List<Integer> nums, int i, int N, int adj) {
			if (i >= N)
				return 0;
				return Math.max(nums.get(i) + findMaxSum(nums, i + adj, N, adj), findMaxSum(nums, i + 1, N, adj));
		}
}
