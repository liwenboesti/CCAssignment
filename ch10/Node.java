package Chapter10;

public class Node 
{
	/* Self-defined (Tree) Node class
	 * Assumption: return -1 when specific element is not found in the stream/BST
	 */
	protected Node left;
	protected Node right;
	protected int data = 0;
	protected int leftSize = 0; // keeps the count of all the nodes of the current node
	
	protected Node(int val) 
	{
		data = val;
	}
	
	// function to insert a node (in the BST)
	protected void insertNode(int val) 
	{
		if (val <= data) 
		{
			if (left != null)
				left.insertNode(val);
			else
				left = new Node(val);
			
			leftSize++;
		} 
		else 
		{
			if (right != null)
				right.insertNode(val);
			else
				right = new Node(val);
		}
	}
	
	// function which returns the rank/in-order place of searched value within a stream/BST
	protected int getRank(int val) 
	{
		if (val == data)
			return leftSize;
		else if (val < data) 
		{
			if (left == null)
				return -1;
			else
				return left.getRank(val);
		} 
		else 
		{
			int rightRank;
			
			if (right == null)
				rightRank = -1;
			else
				rightRank = right.getRank(val);
			
			if (rightRank == -1) 
				return -1;
			else 
				return leftSize + 1 + rightRank;
		}
	}
}
