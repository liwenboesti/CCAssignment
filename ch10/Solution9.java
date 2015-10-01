package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

public class Solution9 
{
	public boolean sortedMatrixSearch(int[][] matrix, int target) 
	{
		int row = 0;
		int column = matrix[0].length - 1;
		
		// start from the top-right corner of the matrix and narrow down to the bottom-left side
		while (row < matrix.length && column >= 0) 
		{
			if (matrix[row][column] == target)
				return true;
			else if (matrix[row][column] > target)
				column--;
			else
				row++; 
		} 
		return false; 
	}
	
	public static void main(String[] args)
	{
		int[][] matrix = {{15, 20, 30, 40}, {20, 35, 55, 80}, {40, 80, 95, 100}, {85, 95, 105, 120}};
		int target1 = 55;
		int target2 = 121;
		
		Solution9 test = new Solution9();
		
		System.out.println(test.sortedMatrixSearch(matrix, target1));
		System.out.println(test.sortedMatrixSearch(matrix, target2));
	}
}
