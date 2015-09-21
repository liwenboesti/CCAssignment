package Chapter1;

/*
 Name: Wenbo (Esti) Li
 Date: 2015/09/12
*/

public class Solution7 
{
	public void rotateMatrix(int[][] matrix, int n)
	{
		/* Assuming we are rotating the matrix 90 degrees to the right. 
		 */
		
		// Essentially, we are rotating the matrix from the outer layer to the inner layer, swapping element by element
		for (int layer=0; layer < n/2; layer++)
		{
			int first = layer;
			int last = n-1 - layer;
			
			for (int i=first; i<last; i++)
			{
				int offSet = i - first;
				
				int temp = matrix[first][i];
				// left -> top
				matrix[first][i] = matrix[last-offSet][first];
				// bottom -> left
				matrix[last-offSet][first] = matrix[last][last-offSet];
				// right -> bottom
				matrix[last][last-offSet] = matrix[i][last];
				// top -> right
				matrix[i][last] = temp;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int n = 4;
		int[][] matrix = new int[n][n];
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
			{
				matrix[i][j] = j;
			}
		}
		
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
			{
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
		
		Solution7 test = new Solution7();
		
		System.out.print("\n");
		
		test.rotateMatrix(matrix, n);
		
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
			{
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}		
	}
}
