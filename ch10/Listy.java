package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

public class Listy 
{
	/* Self-defined List class with only elementAt method
	 */
	
	protected int[] listyArr;
	
	protected Listy(int[] arr) 
	{
		listyArr = arr.clone();
	}
	
	// returns the element of a specific index in the list/array
	protected int elementAt(int index) 
	{
		if (index >= listyArr.length) 
		{
			return -1;
		}
		
		return listyArr[index];
	}
}
