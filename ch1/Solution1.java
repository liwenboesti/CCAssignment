package Chapter1;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

public class Solution1 
{	
	public boolean isUnique(String str)
	{
		/* Assuming that the string is constructed using ASCII chars only, hence there are 128 unique chars.
		 */
		
		// More than 128 possible unique characters exist in the string, thus there is at least one repeating char.
		if (str.length() > 128)
			return false;
		
		// Using a size=128 array to keep track of all the possible repeating chars, all index initialized to be 0.
		int[] arr = new int[128];
		
		// Check each index of the array, mark the corresponding index of the array 1 for the 1st time seeing it.
		for (int i=0; i<str.length(); i++) 
		{
			int index = str.charAt(i); 
			if (arr[index] != 0) // If we have visited this particular char before, (the corresponding index of the array has changed from 0 to 1 before) return false indicating a sign of repeating char.
				return false;
			else
				arr[index] = 1;
		}
		return true;
	}
	
	public static void main(String[] args) 
	{
		String str1 = "abc123"; // no repeating char.
		String str2 = "abc123a"; // repeating char. 
		
		Solution1 test = new Solution1();
		
		System.out.println(test.isUnique(str1));
		System.out.println(test.isUnique(str2));
	}
}
