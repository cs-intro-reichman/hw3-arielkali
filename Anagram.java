/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		// parse the lowerletters
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		
		// creates a found letter array for each letter in str 2 to make sure were not double confirming on the same letter
		boolean[] found_letter_str1 = new boolean[str1.length()];
		boolean[] found_letter_str2 = new boolean[str2.length()];

		// if the length is different then for sure its not an anagram
		if (str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j) && found_letter_str2[j] == false) {
					found_letter_str1[i] = true;
					found_letter_str2[j] = true;
					break;
				} 
			}
			if (found_letter_str1[i] == false) {
				return false;
			}

		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
		String lower_letter = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLowerCase(str.charAt(i))) {
				lower_letter = lower_letter + str.charAt(i);
			}
		}
		return lower_letter;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String randomized_word = "";
		int start_length = str.length();
		str = preProcess(str);
		for (int i = 0; i < start_length; i++) {
			int random_num = (int) (Math.random() * str.length());
			randomized_word = randomized_word + str.charAt(random_num);
			str = str.substring(0, random_num) + str.substring(random_num+1);
		}
		return randomized_word;
	}
}
