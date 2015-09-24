package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import java.util.*;
import Chapter4.TreeNode;

public class Solution9 
{
	// DFS approach
	
	public ArrayList<ArrayList<TreeNode>> bSTSequences(TreeNode root)
	{
		ArrayList<ArrayList<TreeNode>> answer = new ArrayList<ArrayList<TreeNode>>();
		HashSet<TreeNode> nodeSet = new HashSet<TreeNode>();
		nodeSet.add(root);
		
		doAdd(nodeSet, new ArrayList<TreeNode>(), answer);
		return answer;
	}

	private void doAdd(HashSet<TreeNode> nodeSet, ArrayList<TreeNode> curList, ArrayList<ArrayList<TreeNode>> answer)
	{
		if (nodeSet.isEmpty())
		{
			answer.add(curList);
			return;
		}
		
		for (TreeNode curNode : nodeSet)
		{
			// copying the arraylist of treenodes which contains up to the previous level partially constructed result
			ArrayList<TreeNode> nextList = new ArrayList<TreeNode>(curList);
			nextList.add(curNode); // incrementing the partially constructed result with this level of selected treenode 
			
			// copying the hashset of treenodes which contains up to the previous level all available treenodes to be appended
			HashSet<TreeNode> nextSet = new HashSet<TreeNode>(nodeSet);
			nextSet.remove(curNode); // clear this level's (used) treenode
			
			// check left branch and add next level treenode into the hashset
			if (curNode.left != null)
				nextSet.add(curNode.left);
			// check right branch and next level treenode into the hashset
			if (curNode.right != null)
				nextSet.add(curNode.right);
			
			doAdd(nextSet, nextList, answer);
		}
	}
	
	public static void main(String[] args)
	{
		Solution9 test = new Solution9();
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(0);
		
		ArrayList<ArrayList<TreeNode>> answer = test.bSTSequences(root);
		
		for (ArrayList<TreeNode> curList : answer)
		{
			for (TreeNode node : curList)
				System.out.print(node + ", ");
			System.out.println();
		}
	}
}
