package Chapter5;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/10/02
 */

public class Solution3
{
	/*	Assume sequence length doesn't exceed 32 bits
	 */
	private int seqLength = 32;
	
	public int flipBitToWin(int num) 
	{
		int maxSeq = 0;
		
		for (int i=0; i < seqLength; i++)
			maxSeq = Math.max(maxSeq, longestSeqOf1s(num, i));
		
		return maxSeq;
	}
	
	// helper function
	public int longestSeqOf1s(int num, int currPtr) // assume the current pointer is 1 no matter what it actually shows in the sequence
	{
		int max1s = 0;
		int counter = 0;
		
		for (int i=0; i<seqLength; i++)
		{
			if ((i == currPtr) || getBit(num, i)) 
			{
				counter++;
				max1s = Math.max(counter, max1s);
			} 
			else
				counter = 0;
		}
		
		return max1s;
	}
	
	// helper function, returns the bit of current index
	private boolean getBit(int num, int i) 
	{
		return ((num & (1 << i)) != 0);
	}
	
	public static void main(String[] args)
	{
		int num = Integer.parseInt("11011101111", 2);
	
		Solution3 test = new Solution3();
		
		System.out.println(test.flipBitToWin(num));
	}
	
}
