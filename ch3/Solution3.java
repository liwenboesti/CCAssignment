package Chapter3;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import java.util.*;

public class Solution3 
{
	/* See ReadMe.md for Follow Up question
	*/
	public static class SetOfStacks
	{
		/* Assume stacks only takes integer inputs
		 */
		
		private ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
		private int capacity;
		
		public SetOfStacks(int capacity)
		{
			this.capacity = capacity;
		}
		
		// add new element to the stack, when the current stack hit the previously defined threshold, creating a new stack to continue the process
		public void push(int val)
		{
			Stack<Integer> lastSt = getLastStack();
			
			if (lastSt != null && lastSt.size() != capacity)
				lastSt.push(val);
			else
			{
				Stack<Integer> st = new Stack<Integer>();
				st.push(val);
				stacks.add(st);
			}
		}
		
		// return and then remove the top of the (newest) stack
		public int pop()
		{
			Stack<Integer> lastSt = getLastStack();
			
			if (lastSt == null)
				throw new EmptyStackException(); // exception
			
			int val = lastSt.pop();
			if (lastSt.size() == 0)
				stacks.remove(stacks.size()-1);
			
			return val;
		}
		
		// helper function, to switch to the previous stack
		private Stack<Integer> getLastStack()
		{
			if (stacks.size() == 0)
				return null;
			return stacks.get(stacks.size()-1);
		}
	}
	
	public static void main(String[] args)
	{
		int capacity = 3;
		Solution3.SetOfStacks stackOfPlates = new Solution3.SetOfStacks(capacity);
		
		stackOfPlates.push(1);
		stackOfPlates.push(2);
		stackOfPlates.push(3);
		stackOfPlates.push(4);
		System.out.println(stackOfPlates.pop());
		System.out.println(stackOfPlates.pop());
	}
}
