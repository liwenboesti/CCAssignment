package Chapter5;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/10/02
 */

public class Solution2 
{
	public String binaryToString(double num) 
	{
		if (num >= 1 || num <= 0) // num out of range
			return "ERROR! - Out of range!";
	
		StringBuilder binary = new StringBuilder();
		binary.append("0");
		binary.append(".");
		
		while (num > 0) 
		{
			if (binary.length() > 32) // num exceed 32 bits in order to represent the EXACT value in binary
				return "ERROR!";
			
			// converting the 'fraction' part into binary	
			double remainder = num * 2; // "." -> 1/2, 1/4, 1/8, 1/16... [(number * 2) - 1]
			if (remainder >= 1) 
			{
				binary.append(1);
				num = remainder - 1;
			} 
			else 
			{
				binary.append(0);
				num = remainder;
			}
		}
		
		return binary.toString();
	}
	
	public static void main(String[] args)
	{
		double num1 = 0.72;
		double num2 = 0.75;
		
		Solution2 test = new Solution2();
		
		System.out.println(test.binaryToString(num1));
		System.out.println(test.binaryToString(num2));
	}
	
}
