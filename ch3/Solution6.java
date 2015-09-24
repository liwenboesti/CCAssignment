package Chapter3;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import Chapter3.AnimalShelter; 

public class Solution6 
{
	/* In order to run solution code, I've put the Cat, Dog, Animal and AnimalShelter classes into different java class files
	 * 
	 */
	
	public static void main(String[] args)
	{
		AnimalShelter queue = new AnimalShelter();
		
		queue.enqueue(new Cat("Cat1"));
		queue.enqueue(new Cat("Cat2"));
		queue.enqueue(new Dog("Dog1"));
		queue.enqueue(new Dog("Dog2"));
		queue.enqueue(new Cat("Cat3"));
		queue.enqueue(new Dog("Dog3"));
		queue.enqueue(new Dog("Dog4"));
		queue.enqueue(new Cat("Cat4"));
		
		System.out.println(queue.dequeueCat().name);
		System.out.println(queue.dequeueDog().name);
		System.out.println(queue.dequeueCat().name);
		System.out.println(queue.dequeueAny().name);
		System.out.println(queue.dequeueAny().name);
	}
}
