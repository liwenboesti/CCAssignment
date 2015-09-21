package Chapter2;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

import Chapter2.LinkedListNode;

public class Solution3 
{
	public boolean deleteMiddleNode(LinkedListNode node)
	{
		/*
		 * 
		 */
		
		if (node == null || node.next == null)
			return false;
		
		LinkedListNode nextNode = node.next;
		node.data = nextNode.data;
		node.next = nextNode.next;
		
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println("DeleteMiddleNode");
	}
}
