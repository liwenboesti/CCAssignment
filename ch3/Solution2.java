package Chapter3;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import java.util.Stack;

public class Solution2 
{
	public static class stackMin
	{
		/* Assume stacks only takes integer inputs
		 */
		
		private Stack<Integer> stack = new Stack<Integer>();
	    private Stack<Integer> min_stack = new Stack<Integer>();

	    // using two stacks to maintain the min property when doing push
	    public void push(int val) 
	    {
	        if (min_stack.isEmpty() || min_stack.peek() >= val) // when the min stack is empty or the new value is the true min -> add to min stack, else add to regular stack
	            min_stack.push(val); 
	        stack.push(val);
	    }
	    
	    // using two stacks to maintain the min property when doing pop
	    public void pop() 
	    {
	        if (stack.peek().equals(min_stack.peek())) // when the min element is on the top -> pop min stack, else pop regular stack
	            min_stack.pop();
	        stack.pop();
	    }
	    
	    // regular stack peek method
	    public int peek() 
	    {
	        return stack.peek();
	    }

	    // the min stack method, returns the minimum element of the stack
	    public int min() 
	    {
	        return min_stack.peek();
	    }
	}
	
	public static void main(String[] args)
	{
		Solution2.stackMin stack = new Solution2.stackMin();
		
		stack.push(1);
		stack.push(2);
		System.out.println(stack.peek());
		System.out.println(stack.min());
		stack.pop();
		stack.push(0);		
		System.out.println(stack.peek());
		System.out.println(stack.min());
	}
}
