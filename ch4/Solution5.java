package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import Chapter4.TreeNode;

public class Solution5 
{
	public boolean validateBST(TreeNode root) 
    {
        if (root == null)    
            return true;
            
        boolean left;
        boolean right;
        
        if (root.left == null)
            left = true;
        else
        {
            if (getMax(root.left) < root.data)
                left = validateBST(root.left);
            else
                left = false;
        } 
            
        if (root.right == null)
            right = true;
        else
        {
            if (getMin(root.right) > root.data)
                right = validateBST(root.right);
            else
                right = false;
        }
        
        return left && right;
    }

    private int getMin(TreeNode node)
    {
        while (node.left != null)
            node = node.left;
            
        return node.data;
    }
    
    private int getMax(TreeNode node)
    {
        while (node.right != null)
            node = node.right;
            
        return node.data;
    }
	
	public static void main(String[] args)
	{
		Solution5 test = new Solution5();
		
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(1);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(0);
		
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(0);
		root2.left.left = new TreeNode(3);
		
		System.out.println(test.validateBST(root1));
		System.out.println(test.validateBST(root2));
	}
}
