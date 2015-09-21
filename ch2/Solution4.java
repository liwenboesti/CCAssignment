package Chapter2;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

import Chapter2.LinkedListNode;

public class Solution4 
{
	public LinkedListNode partition(LinkedListNode node, int pivot)
	{
		/*
		 * 
		 */
		
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		while (node != null)
		{
			LinkedListNode nextNode = node.next;
			
			if (node.data < pivot)
			{
				node.next = head;
				head = node;
			}
			else
			{
				tail.next = tail;
				tail = node;
			}
			node = nextNode;
		}
		tail.next = null;
		
		return head;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Partition");
	}
}
