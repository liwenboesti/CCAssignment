package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

import java.io.*;
import java.util.Scanner;

public class Solution7 
{
	/* See ReadMe.md for Follow Up question
	*/
	
	// the total number of integers (4 billion integers input)
	private long totalNumOfInts = ((long) Integer.MAX_VALUE) + 1; // 2^(31) distinct integers
	private int[] bitfield = new int[(int) (totalNumOfInts/32)]; // 1 integer is 8x4=32 bits, in other words, 1 space of integer can be used to hold 32 bits
	private String fileName = "solution_7_test_case.txt";
	
	public void missingInt() throws FileNotFoundException 
	{
		Scanner in = new Scanner(new FileReader(fileName));
		
		while (in.hasNextInt()) 
		{
			int thisInt = in.nextInt ();
			/* Finds the corresponding number in the bitfield by using
			 * the OR operator to set the nth bit of a byte 
			 */
			bitfield[thisInt/32] = bitfield[thisInt/32] | (1 << (thisInt%32));
		}

		in.close();
		
		for (int i=0; i<bitfield.length; i++) // index of the bitfield
		{
			for (int j=0; j<32; j++) // index of each position
			{
				/* Retrieves the individual bits of each 32 bits. When 0 bit
				 * is found, finds the corresponding value. 
				 */
				if ((bitfield[i] & (1 << j)) == 0) 
				{
					System.out.println(i*32+j);
					return;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		Solution7 test = new Solution7();
		
		try 
		{
			test.missingInt();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("FileNoteFoundException!");
		}
	}
}
