package Chapter5;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/10/02
 */

public class Solution1 
{
	public int insertion(int N, int M, int i, int j) // N, M are both 32-bit numbers, j=start, i=end
	{
		/* Assume, whenever an exception is reached, returns -1
		 */
		
		if (i >= 32 || j < i)
			return -1;
		
		int seriesOfOnes = ~0; // 11111111111111111111111111111111
		
		int rigtZeros = seriesOfOnes << (j+1); // create a sequence of 11111111111111111111111111000000 which consist (32-j) 1s and j 0s	
	  	int leftZeros = ((1 << i) - 1); // create a sequence of  00000000000000000000000000000011 which consist (32-i) 0s and i 1s
		int mask = rigtZeros | leftZeros; // creating a sequence of 11111111111111111111111111000011 with position i to j (from right to left) are 0s, rest of the sequences are 1s

		int clearedN = N & mask; // clear bits from position i to j (from right to left) of N
		int shiftedM = M << i; // move M into the desired position
		
		return clearedN | shiftedM; // inserts M into N between the positions i and j
	}
	
	public static void main(String[] args)
	{
		int N = Integer.parseInt("10000000000", 2); // 00000000000000000000010000000000
		int M = Integer.parseInt("10011", 2); // 0000000000000000000000000010011
		int i = 2; // from right to left, position 2
		int j = 6; // from right to left, position 6
		
		Solution1 test = new Solution1();
				
		int result = test.insertion(N, M, i, j);
		
		int binary[] = new int[32];
		int index = 0;
		while (result > 0)
		{
			binary[index] = result % 2;
		    result = result / 2;
		    index++;
		}
		
		for (int k=index-1; k>=0; k--)
		       System.out.print(binary[k]);
	}
}
