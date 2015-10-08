package Chapter6;

import java.util.*;
import Chapter6.Bottle;
import Chapter6.TestStrip;

public class Solution10 
{
	/* This is the Follow Up part of Solution10
	 */
	
	// the main simulation function, to find the poison bottle
	public int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) 
	{
		runTests(bottles, strips);
		ArrayList<Integer> positive = getPositiveOnDay(strips, 7);
		
		return setBits(positive);
	}	
	
	// add bottles to test strips
	public void runTests(ArrayList<Bottle> bottles, ArrayList<TestStrip> testStrips) 
	{
		for (Bottle bottle : bottles) 
		{
			int id = bottle.getId();
			int bitIndex = 0;
			while (id > 0) 
			{
				if ((id & 1) == 1)
					testStrips.get(bitIndex).addDropOnDay(0, bottle);
				
				bitIndex++;
				id = id >> 1;
			}
		}
	}
	
	// get test strips that are positive on a particular day
	public ArrayList<Integer> getPositiveOnDay(ArrayList<TestStrip> testStrips, int day) 
	{
		ArrayList<Integer> positive = new ArrayList<Integer>();
		for (TestStrip testStrip : testStrips) 
		{
			int id = testStrip.getId();
			if (testStrip.isPositiveOnDay(day))
				positive.add(id);
		}
		
		return positive;
	}
	
	// create number by setting bits with indices specified in positive
	private int setBits(ArrayList<Integer> positive) 
	{
		int id = 0;
		for (Integer bitIndex : positive)
			id = id | (1<<bitIndex);
		
		return id;
	}
	
	// helper function to create bottles
	private ArrayList<Bottle> createBottles(int nBottles, int poisoned) 
	{
		ArrayList<Bottle> bottles = new ArrayList<Bottle>();
		
		for (int i=0; i<nBottles; i++)
			bottles.add(new Bottle(i));
		
		if (poisoned == -1) // add poison to a random bottle
		{
			Random random = new Random();
			poisoned = random.nextInt(nBottles);
		}
		
		bottles.get(poisoned).setAsPoisoned(); // add poison to the designated bottle
		
		return bottles;
	}
	
	// helper function to create test strips
	private ArrayList<TestStrip> createTestStrips(int nTestStrips) 
	{
		ArrayList<TestStrip> testStrips = new ArrayList<TestStrip>();
		for (int i=0; i<nTestStrips; i++)
			testStrips.add(new TestStrip(i));
		
		return testStrips;
	}
	
	public static void main(String[] args)
	{
		int nBottles = 1000; // the total number of bottles
		int nTestStrips = 10; // the total number of test strips
		
		int poisoned = -1; // get a random poison bottle
		
		/* int poisoned = 998; // set the poisoned bottle
		 */
		
		Solution10 test = new Solution10();
		
		ArrayList<Bottle> bottles = test.createBottles(nBottles, poisoned);
		ArrayList<TestStrip> testStrips = test.createTestStrips(nTestStrips);
		
		System.out.println(test.findPoisonedBottle(bottles, testStrips));
		
	}
}
