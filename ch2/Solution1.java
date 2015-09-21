package Chapter2;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/12
 */

import Chapter2.LinkedListNode; 
import java.util.HashSet;

public class Solution1 
{
	public void removeDups(LinkedListNode node)
	{
		/* Follow up: if no buffer allowed, we would then need to use two pointers to iterate through the linked list and check all the subsequent nodes for duplicates
		 * 
		 */
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		LinkedListNode previous = null;
		
		while (node != null)
		{
			if (hashSet.contains(node.data))
			{
				previous.next = node.next;
			}
			else
			{
				hashSet.add(node.data);
				previous = node;
			}
			
			node = node.next;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println("RemoveDups");
	}
}
