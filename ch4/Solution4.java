package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import Chapter4.TreeNode;

public class Solution4 
{
	public boolean checkBalanced(TreeNode root) 
    {
        if (root == null)
            return true;

        boolean leftBalance = true; 
        boolean rightBalance = true; 
        
        int leftHeight = 0;
        int rightHeight = 0;
        
        leftHeight = getHeight(root.left);
        rightHeight = getHeight(root.right);
        
        leftBalance = checkBalanced(root.left);
        rightBalance = checkBalanced(root.right);
        
        if (Math.abs(leftHeight-rightHeight) <= 1)
        	return leftBalance && rightBalance;
        else
            return false;
    }
    
    private int getHeight(TreeNode root)
    {
        if (root == null)
            return 0;

        int leftHeight = 0;
        int rightHeight = 0;
        
        leftHeight = getHeight(root.left);
        rightHeight = getHeight(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
	
	public static void main(String[] args)
	{
		Solution4 test = new Solution4();
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(0);
		
		System.out.println(test.checkBalanced(root));
	}
}
