package com.toa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Program5 {

		public static void main(String[] args) {

			List<String> listofwords = Arrays.asList("lazy", "dog", "jumps", "over", "brown", "the", "fox");
			  System.out.println(topKFrequencyStrings(listofwords, 2));
		}

		 static List<String> topKFrequencyStrings(List<String> words, int k) {
		        Map<String, Integer> map = new HashMap<>();
		        for (String word : words) {
		            if (map.get(word) == null) {
		                map.put(word, 0);
		            }
		            map.put(word, map.get(word) + 1);
		        }

		        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
		            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
		                if (e1.getValue() != e2.getValue()) {
		                    return e1.getValue().compareTo(e2.getValue());
		                } else {
		                    return e2.getKey().compareTo(e1.getKey());
		                }
		            }
		        });

		        for (Map.Entry<String, Integer> entry : map.entrySet()) {
		            minHeap.offer(entry);
		            if (minHeap.size() > k) {
		                minHeap.poll();
		            }
		        }
		        List<String> ret = new ArrayList<>();
		        while (!minHeap.isEmpty()) {
		            ret.add(minHeap.poll().getKey());
		        }

		        Collections.reverse(ret);
		        return ret;
		    }
	}
