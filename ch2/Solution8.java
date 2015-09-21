package Chapter2;

/*
Name: Wenbo (Esti) Li
Date: 2015/09/12
*/

import Chapter2.LinkedListNode;

public class Solution8 
{
	public LinkedListNode loopDetection(LinkedListNode head)
	{
		/*
		 * 
		 */
		
		LinkedListNode slowPtr = head;
        LinkedListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null)
        {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr)
            {
                LinkedListNode slowPtr2 = head; 
                while (slowPtr2 != slowPtr)
                {
                    slowPtr = slowPtr.next;
                    slowPtr2 = slowPtr2.next;
                }
                
                return slowPtr;
            }
        }
        
        return null;
	}
	
	public static void main(String[] args)
	{
		System.out.println("LoopDetection");
	}
}
