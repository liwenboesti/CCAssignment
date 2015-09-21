package Chapter2;

/*
Name: Wenbo (Esti) Li
Date: 2015/09/12
*/

import Chapter2.LinkedListNode;
import java.util.Stack;

public class Solution6 
{
	public boolean palindrome(LinkedListNode head)
	{
		/*
		 * 
		 */
		if (head == null)
			return true;
		
		LinkedListNode fastPtr = head; // x2 the speed of slowPtr
		LinkedListNode slowPtr = head;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		while (fastPtr != null && fastPtr.next != null)
		{
			stack.push(slowPtr.data);
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		if (fastPtr != null)
		{
			slowPtr = slowPtr.next;
		}
		
		while (slowPtr != null)
		{
			int top = stack.pop().intValue();
			
			if (top != slowPtr.data)
				return false;
			slowPtr = slowPtr.next;
		}
			
		return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Palindrome");
	}
}
