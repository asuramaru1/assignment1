package assign1;

import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int max = 0  , curr =0 ;
		char last = 'a' ;
		for(int i = 0 ; i<str.length() ; i++){
			if(i==0){
				max = 1 ;
				curr=max;
			}else{
				curr = last == str.charAt(i)? curr+1:1;
				max = Math.max(curr,max);

			}
			last = str.charAt(i);

		}

		return max;
	}


	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String result = "";
		for(int i = 0 ;i<str.length() ; i++){
			if(Character.isDigit(str.charAt(i))){
				if(i!=str.length()-1)
					for(int j = 0 ; j<str.charAt(i)-'0' ; j++)
						result+=str.charAt(i+1);
			}else{
				result+=str.charAt(i);
			}
		}
		return result;
	}

	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> set = new HashSet<String>();
		for(int i = 0 ; i<=a.length()-len ; i++){
			set.add(a.substring(i , i+len));
		}
		for(int i = 0 ; i<=b.length()-len ; i++){
			if(set.contains(b.substring(i , i+len)))
				return true;
		}

		return false; // TO DO ADD YOUR CODE HERE
	}
}