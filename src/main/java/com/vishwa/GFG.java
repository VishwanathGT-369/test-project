package com.vishwa;

//Java program to find all substring that 
//contain all vowels 
import java.util.HashSet;
import java.util.Set; 

public class GFG { 

	private static Set<String> set = new HashSet<>();
	private static int count = 0;
	// Returns true if x is vowel. 
	static boolean isVowel(char x) { 
		// Function to check whether a character is 
		// vowel or not 
		return (x == 'a' || x == 'e' || x == 'i'
				|| x == 'o' || x == 'u'); 
	} 

	// Function to FindSubstrings of string 
	static void findSubstring(String str) { 
		HashSet<Character> hash = new HashSet<Character>(); 
		// To store vowels 

		int start = 0; 
		for (int i = 0; i < str.length(); i++) { 
			// If current character is vowel then 
			// insert into hash , 
			if (isVowel(str.charAt(i)) == true) { 
				hash.add(str.charAt(i)); 

				// If all vowels are present in current 
				// substring 
				if (hash.size() == 5) {
					String substring = str.substring(start, i + 1);
					if(!set.contains(substring)) {
						
						count++;
						set.add(substring);
					}
					findSubstring(substring.substring(1));
					findSubstring(substring.substring(0, substring.length()-1));
				}
					
			} else { 
				start = i + 1; 
				hash.clear(); 
			} 
		} 
	} 


	// Driver Code 
	public static void main(String[] args) { 
		String str = "aeoibsddaaeiouudb"; 
		// aaeiouu
		// aeiouu
		// aeiou
		// aaeiou
		//findSubstring(str); 
		System.out.println(System.currentTimeMillis());
	} 

} 
