package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import Chapter4.TreeNode;

public class Solution8 
{
	/* Assume all the TreeNode have link to its parents
	 */
	
	public TreeNode firstCommonAncestor(TreeNode nodeP, TreeNode nodeQ)
	{
		if (nodeP == nodeQ)
			return null;
		
		TreeNode ancestor = nodeP;
		while (ancestor != null)
		{
			if (onItsPath(ancestor, nodeQ))
				return ancestor;
			
			ancestor = ancestor.parent;
		}
		
		return null;
	}
	
	private boolean onItsPath(TreeNode ancestor, TreeNode nodeQ)
	{
		while (nodeQ != ancestor && nodeQ != null)
			nodeQ = nodeQ.parent;
		
		return nodeQ == ancestor;
	}
	
	public static void main(String[] args)
	{
		Solution8 test = new Solution8();
		
		TreeNode root = new TreeNode(2);
		TreeNode nodeA = root.left = new TreeNode(1);
		TreeNode nodeB = root.right = new TreeNode(3);
		TreeNode nodeC = root.left.left = new TreeNode(0);
		nodeA.parent = root;
		nodeB.parent = root;
		nodeC.parent = nodeA;
		
		System.out.println(test.firstCommonAncestor(nodeB, nodeA));
	}
}
