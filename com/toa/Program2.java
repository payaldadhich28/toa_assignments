package com.toa;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Program2 {

	public static void main(String[] args) {

		String str = "lazydogjumpsoverthebrownfox";
		System.out.println(longestPalindrome(str));

	}

	static int longestPalindrome(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		Map<Character, Integer> freq = new HashMap<>();
		for (char ch : str.toCharArray()) {
			freq.put(ch, freq.getOrDefault(ch, 0) + 1);
		}

		String mid_char = "";
		StringBuilder left = new StringBuilder();

		for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
			char ch = entry.getKey();
			int count = entry.getValue();

			if (count % 2 == 1) {
				mid_char = String.valueOf(ch);
			}
			left.append(String.join("", Collections.nCopies(count / 2, String.valueOf(ch))));
		}

		StringBuilder right = new StringBuilder(left).reverse();
		if (right != null)
			return ("" + left + mid_char + right).length();
		else
			return 0;
	}

}
