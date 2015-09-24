package Chapter3;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

public abstract class Animal
{	
	protected String name;
	protected int sequence;
	
	public Animal(String name)
	{
		this.name = name;
	}
	
	// set animal arrival sequence
	public void setSequence(int sq) 
	{
		sequence = sq;
	}
	
	// get animal arrival sequence
	public int getSequence() 
	{
		return sequence;
	}
	
	// determine which animal came first
	public boolean isFirst(Animal animal) 
	{
		return this.sequence < animal.getSequence();
	}
}
