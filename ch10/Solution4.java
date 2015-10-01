package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

import Chapter10.Listy;

public class Solution4 
{
	/* This solution utilize the self-defined Listy class
	 */
	public int sortedSearchNoSize(Listy list, int targetVal) 
	{
		// finds the last element/size of the sorted array
		int index = 1;
		while (list.elementAt(index) != -1 && list.elementAt(index) < targetVal)
			index = index*2;
		
		// binary search
		int left = index/2;
	    int right = index;
	    int mid;
	        
	    while (left <= right)
        {
            mid = (left+right) / 2;
            int currVal = list.elementAt(mid);
            
            if (currVal > targetVal || currVal == -1)
                right = mid-1;
            else if (currVal < targetVal)
            	left = mid+1;
            else
            	return mid;
        }
	    
        return -1;
	}
	
	public static void main(String[] args)
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int targetVal1 = 7;
		int targetVal2 = 15;
		
		Listy list = new Listy(arr);
		
		Solution4 test = new Solution4();
		
		System.out.println(test.sortedSearchNoSize(list, targetVal1));
		System.out.println(test.sortedSearchNoSize(list, targetVal2));
	}
}
