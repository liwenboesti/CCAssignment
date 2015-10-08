package Chapter6;

public class Bottle 
{
	protected boolean poisoned = false;
	protected int ID;
	
	protected Bottle(int id) 
	{
		this.ID = id;
	}
	
	protected int getId() 
	{
		return ID;
	}
	
	protected void setAsPoisoned() 
	{
		poisoned = true;
	}
	
	protected boolean isPoisoned() 
	{
		return poisoned;
	}
}
