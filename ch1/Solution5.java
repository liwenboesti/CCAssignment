package Chapter1;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

public class Solution5 
{	
	public boolean oneAway(String str1, String str2)
	{
		// Check whether string str1 is one char manipulation (replacement/insertion/removal) away from str2
		if (str1.length() == str2.length())
			return needSwap(str1, str2);
		else if (str1.length()+1 == str2.length())
			return needEdit(str1, str2); // pass parameter in the format of (short string, long string)
		else if (str1.length()-1 == str2.length())
			return needEdit(str2, str1); // pass parameter in the format of (short string, long string)
		else
			return false;
	}
	
	// One replacement away
	private boolean needSwap(String str1, String str2)
	{
		boolean flag = false;
		
		for (int i=0; i<str1.length(); i++)
		{
			if (str1.charAt(i) != str2.charAt(i)) // when two chars from two strings appears to be different.
			{
				if (flag == true) // when there is one char different between the two strings exist already.
					return false;
				flag = true;
			}
		}
		
		return true;
	}
	
	// One edit (insertion/removal) away
	private boolean needEdit(String shortStr, String longStr)
	{
		// initialize two "pointers" to 
		int ptr1 = 0;
		int ptr2 = 0;
		
		while (ptr1 < shortStr.length() && ptr2 < longStr.length())
		{
			if (shortStr.charAt(ptr1) != longStr.charAt(ptr2))
			{
				if (ptr1 != ptr2)
					return false;
				ptr2++; // when two chars from two strings appears to be different, asynchronize the points and continue to check differences.
			}
			else
			{
				ptr1++;
				ptr2++;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) 
	{
		String str1A = "abc123A";
		String str2A = "abc123AB";
		
		String str1B = "abc123A";
		String str2B = "abc123B";
		
		String str1C = "abc123AB";
		String str2C = "abc123BC";
		
		Solution5 test = new Solution5();
		
		System.out.println(test.oneAway(str1A, str2A));
		System.out.println(test.oneAway(str1B, str2B));
		System.out.println(test.oneAway(str1C, str2C));
	}
}
