package Chapter2;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

import Chapter2.LinkedListNode;

public class Solution5 
{
	public LinkedListNode sumLists(LinkedListNode listA, LinkedListNode listB, int carryOver)
	{
		/*
		 * 
		 */
		
		if (listA == null && listB == null && carryOver == 0)
			return null;
		
		LinkedListNode result = new LinkedListNode();
		int value = carryOver;
		
		if (listA != null)
			value = value + listA.data;
		if (listB != null)
			value = value + listB.data;
		
		result.data = value % 10;
		
		if (listA != null || listB != null)
		{
			LinkedListNode more = sumLists(listA == null ? null : listA.next,
										   listB == null ? null : listB.next,
										   value >= 10 ? 1 : 0);
			result.next = more;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println("SumLists");
	}
}
