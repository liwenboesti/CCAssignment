package Chapter1;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

public class Solution9 
{		
	public boolean stringRotation(String str1, String str2)
	{
		/* Assume strings case not sensitive
		 */
		
		// the key idea of this algorithm is to check whether str2 is a substring of str1str2
		int length = str1.length();
		
		if (length == str2.length() && length >0) // Check whether String A and String B are equal length and not empty.
		{
			String newStr = str1 + str1; // Concatenate string A and string B.
			
			return isSubString(newStr, str2);
		}
		
		return false;
	}
	
	// Helper function, check whether one string is a substring of another
	private boolean isSubString(String newStr, String str2)
	{
		if (newStr.indexOf(str2) >= 0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args)
	{
		String str1A = "waterbottle";
		String str2A = "erbottlewat";
		
		
		String str1B = "waterXbottle";
		String str2B = "bottleXwater";
		
		Solution9 test = new Solution9();
		
		System.out.println(test.stringRotation(str1A, str2A));
		System.out.println(test.stringRotation(str1B, str2B));
	}
}
