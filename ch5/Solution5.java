package Chapter5;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/10/02
 */

public class Solution5 
{
	/* Essentially, (n & (n-1)) == 0 checks whether n and n-1 have 1s in common
	 */
	
	public String debugger(String expression)
	{
		return "It checks if n is a power of 2.";
	}
	
	public static void main(String[] args)
	{
		String expression = "(n & (n-1)) == 0";
		
		Solution5 test = new Solution5();

		System.out.println(expression + " means:");

		System.out.println(test.debugger(expression));
	}
}
