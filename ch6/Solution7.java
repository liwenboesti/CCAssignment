package Chapter6;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/10/06
 */

import java.util.Random;

public class Solution7 
{
	/* This is the simulation code that corresponds to the solution for "The Apocalypse" problem
	 */
	public double simulateNFamilies(int N) 
	{
		int male = 0;
		int female = 0;
		
		for (int i=0; i<N; i++) 
		{
			Random random = new Random();
			
			int boys = 0;
			int girls = 0;
			
			while (girls == 0) // until we have a girl as the next new born baby
			{ 
				if (random.nextBoolean()) // if the baby is a girl
					girls++;
				else // if the baby is a boy
					boys++;
			}
			
			int[] family = {girls, boys}; // the gender of all the kids with respect to girls and boys
			girls = girls + family[0]; // the count of all the girls
			boys = boys + family[1]; // the count of all the boys
		}
		
		double ratio = female / (double) (male + female);
		
		return ratio; 
	}
	
	public static void main(String[] args) 
	{
		int N = 10000; // the population
		
		Solution7 test = new Solution7();
				
		System.out.println(test.simulateNFamilies(N));
	}
}
