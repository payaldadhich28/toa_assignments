package com.toa;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Program3 {

	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(5, 1, 10, 100, 10, 15, 6, 9, 4, 3, 2);
		System.out.println(togetminSwapsForsortlist(nums));
	}
	
	static int togetminSwapsForsortlist(List<Integer> nums){
	    int len = nums.size();
	    int ans = 0;
	    HashMap<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < len; i++)
	        map.put(nums.get(i), i);

	    Collections.sort(nums);

	    boolean[] visited = new boolean[len];
	    Arrays.fill(visited, false);

	    for (int i = 0; i < len; i++) {
	        if (visited[i] || map.get(nums.get(i)) == i)
	            continue;

	        int j = i, cycle_size = 0;
	        while (!visited[j]) {
	            visited[j] = true;

	           
	            j = map.get(nums.get(j));
	            cycle_size++;
	        }

	        if (cycle_size > 0) {
	            ans += (cycle_size - 1);
	        }
	    }
	    return ans;
	}
}
