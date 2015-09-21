package Chapter1;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

public class Solution3 
{
	public void urlify(char[] arr, int length)
	{
		/* Assume the string (char[] arr) has enough space (at the back) to fit all the replaced '%20's.
		 */
		
		// Count the total number of whitespaces in the string.
		int count = 0;
		for (int i=0; i<length; i++)
		{
			if (arr[i] == ' ')
				count++;
		}
		
		int newLength = length + count*2;
		int index = newLength;
	
		// work backwards (from the end to the beginning of the string/array), copy the none-whitespace chars from the end of string 
		// to the end of array, and replace the whitespace car with '0', then add '%' and '2' before this index.
		for (int j=length-1; j>=0; j--)
		{
			if (arr[j] == ' ')
			{
				arr[index-1] = '0';
				arr[index-2] = '2';
				arr[index-3] = '%';
				index = index-3;
			}
			else
			{
				arr[index-1] = arr[j];
				index--;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		String str = " abc 123 ";
		int whiteSpace = 3;
		int length = str.length();
		int fullLength = length + whiteSpace*2;
		
		char[] arr = new char[fullLength];
		
		for (int i = 0; i < str.length(); i++) 
			arr[i] = str.charAt(i);
		
		Solution3 test = new Solution3();
		
		test.urlify(arr, length);
		
		for (int k=0; k<fullLength; k++)
		{
			System.out.print(arr[k]);
		}
	}
}
