package Chapter3;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import java.util.EmptyStackException;

public class Solution1 
{	
	public static class threeInOne
	{
		/* Assume stacks only takes integer inputs 
		 */
		
		private int numOfStacks = 3;
		private int eachStackCap;
		private int[] values;
		private int[] sizes;
		
		public threeInOne(int stackSize)
		{
			eachStackCap = stackSize;
			values = new int[eachStackCap*numOfStacks];
			sizes = new int[numOfStacks];
		}
		
		// insert a new element into a specific stack
		public void newPush(int stackNum, int val) 
		{
			if (sizes[stackNum] >= 0 && sizes[stackNum] < eachStackCap)
			{		
				sizes[stackNum]++;
				values[topIndex(stackNum)] = val;
			}
			else
				System.out.println("This stack is full!"); // exception, kind of...
		}
		
		// return and then remove the top element of the specific stack
		public int newPop(int stackNum)
		{
			if (!newIsEmpty(stackNum))
			{
				int topIdx = topIndex(stackNum);
				int topVal = values[topIdx]; // temporary stores the top element of the stack
				values[topIdx] = 0; // clear top element of the stack
				sizes[stackNum]--; // shrink stack size by 1
				
				return topVal;
			}
			else
				throw new EmptyStackException(); // exception
		}
		
		// return the top element of the specific stack
		public int newPeek(int stackNum)
		{
			if (!newIsEmpty(stackNum))
				return values[topIndex(stackNum)];
			else
				throw new EmptyStackException(); // exception
		}
		
		// return whether the specific stack is empty or not
		public boolean newIsEmpty(int stackNum)
		{
			return sizes[stackNum] == 0;
		}
		
		// helper function, get the top element of the specific stack
		private int topIndex(int stackNum)
		{
			int index = stackNum*eachStackCap + sizes[stackNum] - 1;
			return index;
		}
	}
	
	public static void main(String[] args)
	{
		int size = 3;
		Solution1.threeInOne stacks = new Solution1.threeInOne(size);
		
		System.out.println(stacks.newIsEmpty(0));
		stacks.newPush(0, 1);
		System.out.println(stacks.newPeek(0));
		System.out.println(stacks.newIsEmpty(0));
		System.out.println(stacks.newPop(0));
		
		System.out.println("---");
		
		System.out.println(stacks.newIsEmpty(1));
		stacks.newPush(1, 2);
		System.out.println(stacks.newPeek(1));
		System.out.println(stacks.newIsEmpty(1));
		System.out.println(stacks.newPop(1));
		
		System.out.println("---");
		
		System.out.println(stacks.newIsEmpty(2));
		stacks.newPush(2, 3);
		System.out.println(stacks.newPeek(2));
		System.out.println(stacks.newIsEmpty(2));
		System.out.println(stacks.newPop(2));
	}
}
