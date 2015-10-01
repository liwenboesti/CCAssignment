package Chapter10;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/29
 */

public class Solution6 
{
	/* The solution of this question is embedded into this runnable code 
	 */
	public String sortBigFile(String bigSizeFile)
	{
		String solution = "1st:divide file into chunks of the size of memory. \n"
				+ "2nd: sort each chunk of partial file. \n"
				+ "3rd: store the partial file on disk. \n"
				+ "4th: repeat teps 1-3 until all chuncks are sorted. \n"
				+ "5th: merge all sorted chunks.";
		return solution;
	}
	
	public static void main(String[] args)
	{
		String bigSizeFile = "20GB_File";
		
		Solution6 test = new Solution6();
		
		System.out.println(test.sortBigFile(bigSizeFile));
	}
}
