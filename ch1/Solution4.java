package Chapter1;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

public class Solution4 
{	
	public boolean palindromePermutation(String str)
	{
		/* Assume not case sensitive, only alphabet chars and ignore whitespaces,
		 * e.g. "Tact Coa" can be transformed into a palindrome permutation. 
		 */
		
		// Convert all char into lowercase and filter out the non-alphabet char to simplify process.
		boolean[] table = new boolean[26];
		String lcStr = str.toLowerCase();
		
		for (int i=0; i<lcStr.length(); i++)
		{
			int index = (int) lcStr.charAt(i) - 'a';
			
			if (index >= 0 && index <= 25) // Mark all the odd number of occurrence char true. 
			{
				if (!table[index])
					table[index] = true;
				else
					table[index] = false;
			}
		}
	
		int count = 0;
		for (int j=0; j<26; j++) // Note: a valid palindrome permutation can have at most 1 odd number of occurrence char.
		{
			if (table[j] == true)
				count++;
			if (count > 1)
				return false;
		}
					
		return true;
	}
	
	public static void main(String[] args) 
	{
		String str1 = "Tact Coa";
		String str2 = "aabbcde";
		
		Solution4 test = new Solution4();
		
		System.out.println(test.palindromePermutation(str1));
		System.out.println(test.palindromePermutation(str2));
	}
}


//Alternatively, we can also solve the problem with bit manipulation approach.
