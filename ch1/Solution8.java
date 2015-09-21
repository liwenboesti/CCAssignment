package Chapter1;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

public class Solution8 
{
	public void zeroMatrix(int[][] matrix)
	{
		boolean[] rows = new boolean[matrix.length];	
		boolean[] columns = new boolean[matrix[0].length];

		// Store the rows and columns indices with 0 by inserting 'true' at corresponding matrix positions.
		for (int i=0; i<matrix.length; i++) 
		{
			for (int j=0; j<matrix[0].length; j++) 
			{
				if (matrix[i][j] == 0) 
				{
					rows[i] = true; 
					columns[j] = true;
		 		}
			}
		}
		
		// Change selected/marked rows into 0s
		for (int i=0; i<rows.length; i++) 
		{
			if (rows[i]) 
			{
				changeRows(matrix, i);
			}
		}
		
		// Change selected/marked columns into 0s
		for (int j=0; j<columns.length; j++) 
		{
			if (columns[j]) 
			{
				changeColumns(matrix, j);
			}
		}
	}
	
	// Helper function #1, traverse the designated row and change all elements within this row into 0s.
	private void changeRows(int[][] matrix, int row) 
	{
		for (int i=0; i<matrix[0].length; i++) 
		{
			matrix[row][i] = 0;
		}		
	}

	// Helper function #2, traverse the designated column and change all elements within this column into 0s.
	private void changeColumns(int[][] matrix, int col) 
	{
		for (int j=0; j<matrix.length; j++) 
		{
			matrix[j][col] = 0;
		}		
	}	
	
	public static void main(String[] args)
	{
		int m = 4;
		int n = 3;
		int[][] matrix = new int[m][n];
		
		for (int i=0; i<m; i++)
		{
			for (int j=0; j<n; j++)
			{
				matrix[i][j] = 1;
			}
		}
		
		matrix[1][2] = 0;
		matrix[2][0] = 0;
		
		for (int i=0; i<m; i++)
		{
			for (int j=0; j<n; j++)
			{
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
		
		Solution8 test = new Solution8();
		
		System.out.print("\n");
		
		test.zeroMatrix(matrix);
		
		for (int i=0; i<m; i++)
		{
			for (int j=0; j<n; j++)
			{
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
	}
}
