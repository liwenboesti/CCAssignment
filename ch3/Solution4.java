package Chapter3;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import java.util.Stack;

public class Solution4 
{
	public static class MyQueue //Queue via Stacks
	{
		/* Assume stacks only takes integer inputs
		 */
		
		private Stack<Integer> newestStack = new Stack<Integer>();
	    private Stack<Integer> oldestStack = new Stack<Integer>();
	    
	    // Push element val to the back of queue.
	    public void add(int val) 
	    {
	        while (!oldestStack.isEmpty())
	        	newestStack.push(oldestStack.pop());
	        
	        newestStack.push(val);
	    }

	    // Removes the element from in front of queue.
	    public void remove() 
	    {
	        while (!newestStack.isEmpty())
	        	oldestStack.push(newestStack.pop());

	        oldestStack.pop();
	    }

	    // Get the front element.
	    public int peek() 
	    {
	        while (!newestStack.isEmpty())
	        	oldestStack.push(newestStack.pop());

	        return oldestStack.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean isempty() 
	    {
	        return newestStack.isEmpty() && oldestStack.isEmpty();    
	    }
	}
	
	public static void main(String[] args)
	{
		Solution4.MyQueue queue = new Solution4.MyQueue();
		
		System.out.println(queue.isempty());
		queue.add(1);
		System.out.println(queue.isempty());
		System.out.println(queue.peek());
		queue.remove();
		System.out.println(queue.isempty());
	}
}
