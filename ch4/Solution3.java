package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import Chapter4.TreeNode;
import java.util.*;

public class Solution3 
{
	
	public ArrayList<LinkedList<TreeNode>> listOfDepths(TreeNode root) 
	{
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		LinkedList<TreeNode> currLvl = new LinkedList<TreeNode>();
		
		if (root != null)
			currLvl.add(root);
		
		while (currLvl.size() > 0) 
		{
			// Add all nodes (list) from current(root level) or previous level into 'result' list
			result.add(currLvl);
			
			// Move to next (downward) level
			LinkedList<TreeNode> parents = currLvl;
			currLvl = new LinkedList<TreeNode>();
			
			// Collect all the nodes from current(root/leaves level) or next level into 'current level' list
			for (TreeNode parent : parents) 
			{
				if (parent.left != null)
					currLvl.add(parent.left);

				if (parent.right != null)
					currLvl.add(parent.right);
			}
		}

		return result;
	}
	
	public static void main(String[] args)
	{
		Solution3 test = new Solution3();
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(0);
		
		test.listOfDepths(root);
		
		ArrayList<LinkedList<TreeNode>> answer = test.listOfDepths(root);
		
		for (LinkedList<TreeNode> curList : answer)
		{
			for (TreeNode node : curList)
				System.out.print(node + ", ");
			System.out.println();
		}
	}
}
