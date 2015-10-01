package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

public class Solution3 
{
	public int searchInRotatedArray(int[] arr, int target) 
    {
		/* Assume if the target element is not in the array, return -1
		 */
        if (arr.length == 0)
            return -1;
            
        int left = 0;
        int right = arr.length-1;
        int mid;
        
        while (left <= right)
        {
            mid = (left+right) / 2;
            
            if (arr[mid] == target)
                return mid;
            else if (arr[left] <= arr[mid]) // left part of the array is sorted
            {
                if (arr[left] <= target && target < arr[mid]) // target lies within the sorted range
                    right = mid-1;
                else 
                    left = mid+1;
            }
            else // right part of the array is sorted
            {
                if (arr[mid] < target && target <= arr[right]) // target lies within the sorted range
                    left = mid+1;
                else
                    right=mid-1;
            }
        }
        return -1;
    }
	
	public static void main(String[] args)
	{
		int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		int target1 = 5;
		int target2 = 100;
		
		Solution3 test = new Solution3();
		
		System.out.println(test.searchInRotatedArray(arr, target1));
		System.out.println(test.searchInRotatedArray(arr, target2));
	}
}
