package Chapter6;

import java.util.*;
import Chapter6.Bottle;

public class TestStrip 
{
	protected int DAYS_FOR_RESULT = 7; // the days needed to reveal result 
	protected ArrayList<ArrayList<Bottle>> dropsByDay = new ArrayList<ArrayList<Bottle>>();
	protected int ID;
	
	protected TestStrip(int id) 
	{
		this.ID = id;
	}
	
	protected int getId() 
	{
		return ID;
	}
	
	// resize list of days/drops to be large enough
	protected void sizeDropsForDay(int day) 
	{
		while (dropsByDay.size() <= day)
			dropsByDay.add(new ArrayList<Bottle>());
	}
	
	// add drop from bottle on specific day
	protected void addDropOnDay(int day, Bottle bottle) 
	{
		sizeDropsForDay(day);
		ArrayList<Bottle> drops = dropsByDay.get(day);
		drops.add(bottle);
	}
	
	// checks if any of the bottles in the set are poisoned
	protected boolean hasPoison(ArrayList<Bottle> bottles) 
	{
		for (Bottle b : bottles) 
		{
			if (b.isPoisoned())
				return true;	
		}
		
		return false;
	}
	
	// gets bottles that were used in the test DAYS_FOR_RESULT days ago
	protected ArrayList<Bottle> getLastWeeksBottles(int day) 
	{
		if (day < DAYS_FOR_RESULT)
			return null;
		
		return dropsByDay.get(day - DAYS_FOR_RESULT);
	}
	
	// checks if the test strip has had any poisoned bottles since before DAYS_FOR_RESULT
	protected boolean isPositiveOnDay(int day) 
	{
		int testDay = day - DAYS_FOR_RESULT;
		
		if ((testDay < 0) || (testDay >= dropsByDay.size())) 
			return false;
		
		for (int d=0; d<=testDay; d++) 
		{
			ArrayList<Bottle> bottles = dropsByDay.get(d);
			if (hasPoison(bottles)) 
				return true;
		}
		
		return false;
	}
}
