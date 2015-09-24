package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import java.util.Random;

public class Solution11 
{
	/* Since we are essentially asked to implement a method of a unique treenode class, it's hard to come up with a test case for this
	 */
	public class TreeNode 
	{
		protected int data;      
		protected TreeNode left;    
		protected TreeNode right; 
		protected int size = 0;

		protected TreeNode(int val) 
		{
			data = val;
		}
		
		private int size()
		{
			return size;
		}
		
		public TreeNode getRandomNode() 
		{
			int leftSize;
			if (left == null)
				leftSize = 0;
			else
				leftSize = left.size();
			
			Random random = new Random();
			int index = random.nextInt(size);
			
			if (index == leftSize)
				return this;		
			else if (index < leftSize)
				return left.getRandomNode();
			else
				return right.getRandomNode();
		}
	} 
	
	
	public static void main(String[] args)
	{
		System.out.println("GetRandomNode");
	}
}
