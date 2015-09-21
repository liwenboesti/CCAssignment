package Chapter2;

/*
Name: Wenbo (Esti) Li
Date: 2015/09/12
*/

import Chapter2.LinkedListNode;

public class Solution7 
{
	public LinkedListNode intersection(LinkedListNode headA, LinkedListNode headB) 
    {
        if (headA == null || headB == null)
            return null;

        int lenA = 0;
        int lenB = 0;
        LinkedListNode lenforA = headA;
        LinkedListNode lenforB = headB;

        //get both linkedlists length
        while (lenforA != null)
        {
            lenforA = lenforA.next;
            lenA++; //length of linkedlist A
        }
    
        while (lenforB != null)
        {
            lenforB = lenforB.next;
            lenB++; //length of linkedlist B
        }
    
        //line up both linkedlist from the back, 
        //set both pointers to the "head" the same distance from tail
        if (lenA > lenB)
        {
            int moveB = lenA-lenB;
            while (moveB != 0)
            {
                headA = headA.next; 
                moveB--;
            }
        }

        if (lenA < lenB)
        {
            int moveB = lenB-lenA;
            while (moveB != 0)
            {
                headB = headB.next;
                moveB--;
            }
        }

        //find match
        while (headA != null && headB != null)
        {
            if (headA == headB)
                return headA;
        
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
	
	public static void main(String[] args)
	{
		System.out.println("Intersection");
	}
}
