package Chapter1;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

public class Solution6 
{
	public String stringCompression(String str)
	{
		/* Assume the string has only uppercase and lowercase letters (a-z).
		 */
		
		int repeat = 0;
		String result = "";
		
		// Walk through string and accumulate the count of repeating chars before each char change point.
		for (int i=0; i<str.length(); i++)
		{
			repeat++;
			
			if (i+1 >= str.length() || str.charAt(i) != str.charAt(i+1))
			{
				result = result + str.charAt(i) + repeat; // format the string compression result.
				repeat = 0; //clear count of repeating chars.
			}		
		}
		
		// return either the string or the compressed string, which ever is shorter.
		if (result.length() < str.length())
			return result;
		else
			return str;
	}

	public static void main(String[] args)
	{
		String str = "aabcccccaaa";
		
		Solution6 test = new Solution6();
		
		System.out.println(test.stringCompression(str));
	}
}


//Alternatively, we can also solve the problem using StringBuilder as well.
