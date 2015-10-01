package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

import java.util.BitSet;

public class Solution8 
{
	public  void findDuplicates(int[] arr) 
	{
		int maxNumIntegers = 32000;
		
		BitSet myBS = new BitSet(maxNumIntegers);
		
		for (int i=0; i<arr.length; i++) 
		{
			int num = arr[i];
			int index = num - 1; // numbers begin at 1, bitset index begins at 0
			
			if (myBS.get(index)) // check whether this number is a duplicate
				System.out.println(num);
			else
				myBS.set(index); // set the num-1 index in the bitset to true				
		}
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1, 2 ,3, 4, 5, 6, 7, 7, 7, 8, 8, 9, 10, 11, 12, 13, 13, 14, 15};
		
		Solution8 test = new Solution8();
		
		test.findDuplicates(arr);
	}
}
