package Chapter5;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/10/02
 */

public class Solution4 
{
	public int nextBigNumber(int num) // signature: xxx[pos]111000, pos = 0
	{
		int numCopy = num; // copy of num, use to get the countOf0s and countOf1s
		int countOf0s = 0; // counts of right most consecutive 0s
		int countOf1s = 0; // counts of tight most consecutive 1s
		
		// check whether the right-most bit of num is 0
		while (((numCopy & 1) == 0) && (numCopy != 0)) 
		{
			countOf0s++;
			numCopy = numCopy >> 1; // update the right-most bit of num to 1 to the left position
		}
		
		// check whether the right-most bit of num is 1
		while ((numCopy & 1) == 1) 
		{
			countOf1s++;
			numCopy = numCopy >> 1; // update the right-most bit of num to 1 to the left position
		}
		
		// return -1 if the num can go bigger, e.g all 1s
		if ((countOf0s+countOf1s) == 31 || (countOf0s+countOf1s) == 0)
			return -1;
		
		int pos = countOf0s + countOf1s; // the position of right-most xxx[pos]111000, where [pos] = 0
		
		num = num | (1<<pos); // flip [pos] bit from 0 to 1
		
		num = num & ~((1<<pos) - 1); // clear all 111000 bits located to the right of [pos]
		
		num = num | (1 << (countOf1s-1)) - 1; // add (countOf1s - 1) 1s back starting from the right-most index to left-hand side
		
		return num;
	}
	
	public int nextSmallNumber(int num) // signature: xxx[pos]000111, pos = 1
	{
		int numCopy = num; // copy of num, use to get the countOf0s and countOf1s
		int countOf1s = 0; // counts of tight most consecutive 1s
		int countOf0s = 0; // counts of right most consecutive 0s
		
		// check whether the right-most bit of num is 1
		while ((numCopy & 1) == 1) 
		{
			countOf1s++;
			numCopy >>= 1;
		}
		
		// return -1 if the num can go smaller, e.g all 0s
		if (numCopy == 0) 
			return -1;
		
		// check whether the right-most bit of num is 0
		while (((numCopy & 1) == 0) && (numCopy != 0)) 
		{
			countOf0s++;
			numCopy >>= 1;
		}

		int pos = countOf0s + countOf1s; // the position of right-most xxx[pos]000111, where [pos] = 1

		// alternatively, flip [pos] bit from 1 to 0 and clear all 000111 bits located to the right of [pos]
		num = num & ((~0) << (pos+1)); // clear all [pos]111000 bits, including the [pos] index
		
		// add (countOf1s + 1) 1s back starting from the left-most index to the right of [pos] to right-hand side
		int mask = (1 << (countOf1s+1)) - 1; 
		num = num | mask << (countOf0s-1);  
		
		return num;		
	}
	
	public static void main(String[] args)
	{
		int num1 = Integer.parseInt("11011001111100", 2);
		int num2 = Integer.parseInt("10011110000011", 2);
		
		Solution4 test = new Solution4();
		
		int result1 = test.nextBigNumber(num1);
		int result2 = test.nextSmallNumber(num2);
		
		int binary1[] = new int[32];
		int index1 = 0;
		while (result1 > 0)
		{
			binary1[index1] = result1 % 2;
		    result1 = result1 / 2;
		    index1++;
		}
		
		for (int k=index1-1; k>=0; k--)
		       System.out.print(binary1[k]);
		
		System.out.println("\n");
		
		int binary2[] = new int[32];
		int index2 = 0;
		while (result2 > 0)
		{
			binary2[index2] = result2 % 2;
		    result2 = result2 / 2;
		    index2++;
		}
		
		for (int j=index2-1; j>=0; j--)
		       System.out.print(binary2[j]);
	}
}
