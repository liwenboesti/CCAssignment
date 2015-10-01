package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

public class Solution1 
{
	/* Assume both arrays are not pure zeros  
	 */
	
	public void sortedMerge(int[] arrA, int[] arrB, int lastA, int lastB) 
	{
		int lastPos = lastB + lastA - 1; // the index of the last position of merged arrays
		int ptrA = lastA - 1; // the index of the last element in arrA
		int ptrB = lastB - 1; // the index of last element in arrB
	
		// Merge arrA and arrB, starting from the last element in each arrays
		while (ptrB >= 0) 
		{
			if (ptrA >= 0 && (arrA[ptrA] > arrB[ptrB])) // element form arrA > element from arrB
			{
				arrA[lastPos] = arrA[ptrA]; // copy element
				ptrA--; 
			} 
			else // element form arrA < element from arrB
			{
				arrA[lastPos] = arrB[ptrB]; // copy element
				ptrB--;
			}
			lastPos--; // move indices			
		}
	}
	
	public static void main(String[] args)
	{
		int[] arrA = {2, 4, 6, 8, 10, 0, 0, 0, 0, 0};
		int[] arrB = {1, 3, 5, 7, 9};
		int lastA = 5;
		int lastB = 5;
		
		Solution1 test = new Solution1();
		
		test.sortedMerge(arrA, arrB, lastA, lastB);
		
		for (int num : arrA)
			System.out.print(num + ",");
	}
}
