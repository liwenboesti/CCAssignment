package Chapter5;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/10/02
 */

public class Solution7 
{
	public int pairwiseSwap(int num)
	{
		// mask odd position bits, move all the odd bits 1 position to the right
		int oddPos = num >>> 1;
		oddPos = oddPos & 0x55555555; // 0b[10...0101] 31 bits
		
		// mask even position bits, move all the even bits 1 position to the left
		int evenPos = num << 1;
		evenPos = evenPos & 0xaaaaaaaa; // 0b[10...1010] 32 bits
		
		// swap all the pairs (odd->even, even->odd 'to the right')
		return oddPos | evenPos;
	}
	
	public static void main(String[] args)
	{
		int num = Integer.parseInt("1010", 2);
		
		Solution7 test = new Solution7();
		
		int result = test.pairwiseSwap(num);
		
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
