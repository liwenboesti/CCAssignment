package Chapter1;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

import java.util.Arrays;

public class Solution2 
{
	public boolean checkPermutation(String str1, String str2)
	{
		/* Assuming both strings (str1 and str2) are case sensitive, thus 'Abc' is 
		 * not a permutation of "cba". Additionally, assuming whitespace
		 * is not negligible, thus "abc" is also not a permutation of 
		 * "abc ".
		 */
		
		// Two strings can not be permutation of each other id they don't share the same length.
		if (str1.length() != str2.length())
			return false;
		
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		
		// Sort both arrays in the same manner and check if one array is identical to the other array.
		Arrays.sort(arr1);
		Arrays.sort(arr2);
				
		return Arrays.equals(arr1, arr2);
	}
	
	public static void main(String[] args) 
	{
		// not a permutation
		String str1A = "Abc123";
		String str2A = "321abc ";
		
		// permutation
		String str1B = "abc123";
		String str2B = "123cba";
		
		Solution2 test = new Solution2();
		
		System.out.println(test.checkPermutation(str1A, str2A));
		System.out.println(test.checkPermutation(str1B, str2B));
	}
}


// Alternatively, we can also solve the problem by check if the two strings have identical char counts.
