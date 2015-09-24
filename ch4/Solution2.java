package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import Chapter4.TreeNode;

public class Solution2 
{
	public TreeNode minimalTree(int[] arr)
	{
		return createMinimalBST(arr, 0, arr.length-1);
	}
	
	private TreeNode createMinimalBST(int[] arr, int start, int end)
	{
		if (end < start)
			return null;
		
		int midPoint = (start + end) / 2;
		TreeNode node = new TreeNode(arr[midPoint]);
		
		node.left = createMinimalBST(arr, start, midPoint-1);
		node.right = createMinimalBST(arr, midPoint+1, end);
		
		return node;
	}
	
	public static void main(String[] args)
	{
		int length = 5;
		int[] arr = new int[length];
		for (int i=0; i<length; i++)
			arr[i] = i;
		
		Solution2 test = new Solution2();
		
		//test.minimalTree(arr);
		
		System.out.println(test.minimalTree(arr));
		System.out.print(test.minimalTree(arr).left);
		System.out.print(",");
		System.out.println(test.minimalTree(arr).right);
		System.out.print(test.minimalTree(arr).left.left);
		System.out.print(",");
		System.out.print(test.minimalTree(arr).left.right);
		System.out.print(",");
		System.out.print(test.minimalTree(arr).right.left);
		System.out.print(",");
		System.out.print(test.minimalTree(arr).right.right);
		
	}
}
