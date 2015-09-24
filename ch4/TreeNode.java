package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

public class TreeNode 
{
	/* Self created TreeNode class
	 * 
	 */
	
	protected int data;
    protected TreeNode left;
    protected TreeNode right;
    protected TreeNode parent;
    
    protected TreeNode() 
    { 
    }
    
    protected TreeNode(int val) 
    { 
         data = val;
    }
    
    @Override
    public String toString()
    {
    	return data + "";
    }
}
