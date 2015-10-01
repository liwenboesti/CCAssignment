package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

public class Solution5 
{
	public int spareSearch(String[] arr, String targetStr) 
	{
		/* Assumption: if the target String is "", return -1
		 */
		
		if (arr == null || targetStr == null || targetStr.isEmpty())
			return -1;
		
		// binary search
		int left = 0;
	    int right = arr.length-1;
	    int mid;
	        
	    while (left <= right)
        {
	    	if (left > right)
	    		return -1;
	    	
            mid = (left+right) / 2;
            
            if (arr[mid].isEmpty())
            {
            	// expand to both left-hand side and right-hand side, and search for next available non-empty string
                int goLeft = mid-1;
                int goRight = mid+1;
            
                while (true)
                {
                	if (goLeft < left && goRight > right)
                		return -1;
                	else if (goLeft >= left && !arr[goLeft].isEmpty())
                	{
                		mid = goLeft;
                		break; // no need to go right anymore, one available non-empty string found
                	}
                	else if (goRight <= right && !arr[goRight].isEmpty()) 
                	{
        				mid = goRight;
        				break;	// no need to go right anymore, one available non-empty string found
                	}
                	
                	goLeft--;
                	goRight++;	
                }
            }
            
            if (targetStr.equals(arr[mid]))
    			return mid;
    		else if (arr[mid].compareTo(targetStr) < 0) // search right
    			left = mid+1;
    		else // search left
    			right = mid-1;
        }
	    
	    return -1;
	}
	
	public static void main(String[] args)
	{
		String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		String targetStr1 = "ball";
		String targetStr2 = "helloWorld";
		
		Solution5 test = new Solution5();
		
		System.out.println(test.spareSearch(arr, targetStr1));
		System.out.println(test.spareSearch(arr, targetStr2));
	}
}
