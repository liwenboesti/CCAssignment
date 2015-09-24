package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import Chapter4.Node;
import java.util.LinkedList;

public class Solution1 
{
	public boolean routeBetweenNodes(Node start, Node end)
	{
	    if (start == null || end == null) 
	    	return false;
	    if (start == end) 
	    	return true;
	    
	    LinkedList<Node> queue = new LinkedList<Node>();
	    start.state = true;
	    queue.add(start);
	    
	    while (!queue.isEmpty())
	    {
	        Node thisNode = queue.removeFirst();
	        if (thisNode != null)
	        {	
		        for (Node nextNode : thisNode.getAdjacent())
		        {
		            if (nextNode.state == false)
		            {
		                if (nextNode == end) 
		                	return true;
		                else
		                {
		                    nextNode.state = true;
		                    queue.add(nextNode);
		                }
		            }
		        }
	        }
	        thisNode.state = true;
	    }
	    
	    return false;
	}
	
	public static void main(String[] args)
	{
		Node start = new Node();
		Node nextNode1 = new Node();
		Node nextNode2 = new Node();
		Node end = new Node();
		
		start.addAdjacent(nextNode1);
		nextNode1.addAdjacent(nextNode2);
		nextNode2.addAdjacent(end);
		
		Solution1 test = new Solution1();
		
		System.out.println(test.routeBetweenNodes(start, end));
	}
}
