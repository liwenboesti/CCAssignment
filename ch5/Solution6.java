package Chapter5;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/10/02
 */

public class Solution6 
{
	public int conversion(int num1, int num2) 
	{
		int diffCount = 0;
		for (int diffBits = num1^num2; diffBits != 0; diffBits = diffBits>>1) // diffBits is the binary representation of num1 xor num2, in other words, it contains the number of 1s different between num1 and num2
			diffCount = diffCount + (diffBits&1); // (diffBits & 1) is checking whether the least significant bit is '1', an iterative approach to count how many 1s in the diffBits representation
		
		return diffCount;
	}
	
	public static void main(String[] args)
	{
		int num1 = Integer.parseInt("11101", 2); // 29
		int num2 = Integer.parseInt("01111", 2); // 15
		
		Solution6 test = new Solution6();
		
		System.out.println(test.conversion(num1, num2));
	}
}
