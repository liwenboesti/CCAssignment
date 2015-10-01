package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

import Chapter10.Node;

public class Solution10 
{
	/* This solution utilize the self-defined Node class
	 */
	private Node root = null;
	
	// the track method, essentially it constructs the stream/BST
	public void track(int num) 
	{
		if (root == null)
			root = new Node(num);
		else
			root.insertNode(num);
	}
	
	// the getRankOfNumber method
	public int getRankOfNumber(int num)
	{
		return root.getRank(num);
	}
	
	public static void main(String[] args)
	{
		Solution10 test = new Solution10();
		
		test.track(5);
		test.track(1);
		test.track(4);
		test.track(4);
		test.track(5);
		test.track(9);
		test.track(7);
		test.track(13);
		test.track(3);		
		
		System.out.println(test.getRankOfNumber(1));
		System.out.println(test.getRankOfNumber(3));
		System.out.println(test.getRankOfNumber(4));
	}
}
