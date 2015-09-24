package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import Chapter4.TreeNode;

public class Solution12 
{
	public int pathsWithSum(TreeNode root, int targetVal) 
	{
		if (root == null) 
			return 0;
		
		// count paths with sum starting from the root
		int pathsFromRoot = partialSum(root, targetVal, 0);
		
		// try the nodes on the left and right
		int pathsOnLeft = pathsWithSum(root.left, targetVal);
		int pathsOnRight = pathsWithSum(root.right, targetVal);
		
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}
	
	// returns the number of paths with this sum starting from this node 
	private int partialSum(TreeNode node, int targetVal, int currSum) 
	{
		if (node == null) 
			return 0;
	
		currSum = currSum + node.data;
		
		int pathsCount = 0;
		if (currSum == targetVal) // found a path from the root
			pathsCount++;
		
		pathsCount = pathsCount + partialSum(node.left, targetVal, currSum); // go left
		pathsCount = pathsCount + partialSum(node.right, targetVal, currSum); // go right
		
		return pathsCount;
	}	
	
	public static void main(String[] args)
	{
		Solution12 test = new Solution12();
		
		int targetVal = 5; 
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(0);
		
		System.out.println(test.pathsWithSum(root, targetVal));
	}
}
