package Chapter2;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

import Chapter2.LinkedListNode;

public class Solution2 
{	
	public LinkedListNode returnKthToLast(LinkedListNode head, int k)
	{
		/*
		 * 
		 */
		
		LinkedListNode ptr1 = head;
		LinkedListNode ptr2 = head;
		
		for (int i=0; i<k; i++)
		{
			if (ptr1 == null)
				return null;
			ptr1 = ptr1.next;
		}
		
		while (ptr1 != null)
		{
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		
		return ptr2;
	}
	
	public static void main(String[] args)
	{
		System.out.println("ReturnKthToLast");
	}
}
