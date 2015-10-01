package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

import java.util.Arrays;

public class Solution11 
{
	public void sortValleyPeak(int[] arr) 
	{
		// rearrange the array into a sorted one
		Arrays.sort(arr);
		
		// every two numbers in the sorted array, sway the position to satisfy the peak valley property
		for (int i=1; i<arr.length; i+=2) 
			swapNums(arr, i-1, i);
	}
	
	// the helper function, sway two numbers
	private void swapNums(int[] arr, int leftNum, int rightNum) 
	{
		int temp = arr[leftNum];
		arr[leftNum] = arr[rightNum];
		arr[rightNum] = temp;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {5, 3, 1, 2, 3};
		
		Solution11 test = new Solution11();
		
		test.sortValleyPeak(arr);
		
		for (int num : arr)
			System.out.print(num + ",");
	}
}
