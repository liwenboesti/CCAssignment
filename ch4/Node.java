package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import java.util.ArrayList;

public class Node 
{
	/* Self created Node class
	 * 
	 */
	protected ArrayList<Node> adjacentNodes;
	protected boolean state;
	protected int adjacentCount;
	
	protected Node()
	{
		adjacentNodes = new ArrayList<Node>();
	}
	
	protected ArrayList<Node> getAdjacent()
	{
		return adjacentNodes;
	}
	
	protected void addAdjacent(Node x) 
	{
        if (adjacentCount < 15) 
        {
            adjacentNodes.add(x);
            adjacentCount++;
        } 
        else 
            System.out.print("No more adjacent can be added");
    }
}
