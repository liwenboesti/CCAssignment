package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import Chapter4.TreeNode;

public class Solution6 
{
	/* Assume all the TreeNode have link to its parents
	 */
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode pivotNode) //need to find the 'next' node of the pivot node (in-order)
	{
		TreeNode nextNode;
        if (pivotNode != null && pivotNode.right != null) 
        {
            nextNode = pivotNode.right;
            while (nextNode.left != null) 
            	nextNode = nextNode.left;

            return nextNode;
        }
        
        nextNode = findNext(root, pivotNode);
        return nextNode;
    }

    private TreeNode findNext(TreeNode root, TreeNode pivotNode) 
    {
        if (root == pivotNode)
            return null;

        if (root.data < pivotNode.data) // 'next' node lies within the right branch
            return findNext(root.right, pivotNode);
        else // 'next' node lies within the left branch
        {
            TreeNode leftBranch = findNext(root.left, pivotNode);
            
            if (leftBranch == null) // i.e root.left == pivotNode -> root is the 'next' node
            	return root;
            else
            	return leftBranch; 
        }
    }

	public static void main(String[] args)
	{
		Solution6 test = new Solution6();
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		TreeNode pivotNode = root.left.left = new TreeNode(0);
		
		System.out.println(test.inorderSuccessor(root, pivotNode));
	}
}
