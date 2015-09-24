package Chapter3;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import java.util.LinkedList;
import Chapter3.Animal;

public class AnimalShelter 
{
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	
	private int sequence = 0;
	
	// add animals
	public void enqueue(Animal newAnimal)
	{
		newAnimal.setSequence(sequence); // set arrival sequence for all animals
		sequence++;
		
		if (newAnimal instanceof Dog)
			dogs.add((Dog) newAnimal); 
		else if (newAnimal instanceof Cat)
			cats.add((Cat) newAnimal);
	}
	
	// remove which ever came first
	public Animal dequeueAny()
	{
		if (dogs.size() == 0) 
			return dequeueCat();
		else if (cats.size() == 0)
			return dequeueDog();
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		
		if (dog.isFirst(cat))
			return dogs.poll();
		else 
			return cats.poll();
	}
	
	// remove dog
	public Animal dequeueDog()
	{	
		return dogs.poll();
	}
	
	// remove cat
	public Animal dequeueCat()
	{
		return cats.poll();
	}
}
