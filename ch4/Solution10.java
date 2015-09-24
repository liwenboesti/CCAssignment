package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

public class Solution10 
{
	public boolean checkSubtree(TreeNode treeA, TreeNode treeB) 
	{
		if (treeB == null) 
			return true; // The empty tree is a subtree of every tree.

		return subTree(treeA, treeB);
	}
	
	// checks if the binary tree rooted at rootA contains the binary tree rooted at rootB as a subtree somewhere within it.
	private boolean subTree(TreeNode rootA, TreeNode rootB) 
	{
		if (rootA == null)
			return false; // the case when the big tree empty and the subtree still not found.
		else if (rootA.data == rootB.data && matchTree(rootA, rootB))
			return true;

		return (subTree(rootA.left, rootB) || subTree(rootA.right, rootB)); 
	}

	// checks if the binary tree rooted at rootA contains the binary tree rooted at rootB as a subtree starting at rootA.
	private boolean matchTree(TreeNode rootA, TreeNode rootB) 
	{
		if (rootA == null && rootB == null)
			return true; // nothing left in the subtree
		else if (rootA == null || rootB == null)  
			return false; // the case when the big tree empty and the subtree still not found
		else if (rootA.data != rootB.data)   
			return false;  // not equal
		else
			return (matchTree(rootA.left, rootB.left) && matchTree(rootA.right, rootB.right));
	}
	
	public static void main(String[] args)
	{
		Solution10 test = new Solution10();
		
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(0);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(0);
		
		System.out.println(test.checkSubtree(root1, root2));
	}
}
