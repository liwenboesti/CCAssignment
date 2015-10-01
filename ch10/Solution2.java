package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

import java.util.*;

public class Solution2 
{
	public void groupAnagrams(String[] arr) 
	{
		HashMap<String, ArrayList<String>> mapAnagrams = new HashMap<String, ArrayList<String>>();
		
		// group words by anagram
		for (String str : arr) 
		{
			String key = sortChars(str);
			
			// group similar anagrams into a list
			if (mapAnagrams.containsKey(key))
			{
				ArrayList<String> listAnagrams = mapAnagrams.get(key);
				listAnagrams.add(str);
			} 
			else // create a new list and group corresponding anagrams
			{
				ArrayList<String> newlistAnagrams = new ArrayList<String>();
				newlistAnagrams.add(str);
				mapAnagrams.put(key, newlistAnagrams);
			}
		}
		
		// convert the hash table to array
		int index = 0;
		for (String key : mapAnagrams.keySet()) 
		{
			ArrayList<String> currList = mapAnagrams.get(key);
			for (String str : currList) 
			{
				arr[index] = str;
				index++;
			}
		}
	}
	
	private String sortChars(String str) 
	{
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		
		return new String(chars);
	}
	
	public static void main(String[] args)
	{
		String[] array = {"abcd", "mn", "nm", "ele", "dabc", "x", "eel", "lee"};
		
		Solution2 test = new Solution2();
		
		test.groupAnagrams(array);
		
		for (String str : array)
			System.out.print(str + ",");
	}
}
