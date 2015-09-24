package Chapter3;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import java.util.Stack;

public class Solution5 
{
	public void sortStack(Stack<Integer> resultSt) 
	{
		/* Assume stacks only takes integer inputs
		 */
		
		Stack<Integer> sortedSt = new Stack<Integer>();
		while(!resultSt.isEmpty()) 
		{
			// Insert each element from the unsorted stack into the sorted stack in sorted order from small(bottom) -> large(top)
			int temp = resultSt.pop();
			
			while(!sortedSt.isEmpty() && sortedSt.peek() > temp) 
				resultSt.push(sortedSt.pop());
			sortedSt.push(temp);
		}
		
		// reformat the result stack from small(bottom) -< large(top) into large(bottom) -> small(top)
		while (!sortedSt.isEmpty())
			resultSt.push(sortedSt.pop());
	}
	
	public static void main(String[] args)
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(4);
		stack.push(2);
		stack.push(3);
		stack.push(1);
		
		Solution5 test = new Solution5();
		
		test.sortStack(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());		
	}
}
