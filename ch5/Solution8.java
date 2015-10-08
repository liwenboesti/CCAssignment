package Chapter5;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/10/02
 */

public class Solution8 
{
	/* Assume x1 and x2 are in range of [ 0, (screen.length)*8 ),
	 * y is in range of [ 0, (screen.length)/(width/8) )
	 */
	public void drawLine(byte[] screen, int width, int x1, int x2, int y) 
	{
        int pos1 = y*width + x1; // starting position, in terms of bits/pixels
        int pos2 = y*width + x2; // ending position, in terms of bits/pixels
        
        int start = pos1;
        
        while (start <= pos2)
        {
            int row = start / 8; // in terms of bytes
            int col = start % 8; // in terms of bits/pixels
            
            // the "coloring" process of each byte is actually started from right to left in terms of bits/pixels 
            screen[row] = (byte) (screen[row] | (1<<col));
            start++; // increment in terms of bits/pixels
        } 
	}
	
	// helper function, to print the 'screen'
	private void printScreen(byte[] screen, int width)
	{
        int w = width / 8;
        int ctr = 0;
        
        for (int i=0; i<screen.length; i++)
        {
            for (int j=0; j<8; j++)
            {
                if ((screen[i] & 1<<j) != 0)
                    System.out.print("1");
                else
                    System.out.print("0");
            }
            
            System.out.print(",");
            ctr++;
            
            if (ctr == w)
            {
                System.out.println();
            	ctr = 0;
            }
        }
    }
	
	public static void main(String[] args)
	{
		byte screen[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		int width = 24; // in terms of bits/pixels
		int x1 = 9; // in terms of bits/pixels
		int x2 = 22; // in terms of bits/pixels
		int y = 1; // indicates the (y+1) row
		
		Solution8 test = new Solution8();
		
		test.printScreen(screen, width);
		
		test.drawLine(screen, width, x1, x2, y);
		
		System.out.println("------");
		
		test.printScreen(screen, width);
	}
}
