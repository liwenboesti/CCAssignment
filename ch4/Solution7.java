package Chapter4;

/* 
 * Name: Wenbo (Esti) Li
 * Date: 2015/09/19
 */

import java.util.*;

public class Solution7 
{
	public char[] buildOrder(char[] projects, char[][] dependencies)
	{
		HashMap<Character, HashSet<Character>> dMap = new HashMap<Character, HashSet<Character>>();
		HashSet<Character> pSet = new HashSet<Character>();
		
		for (char project : projects)
			pSet.add(project);
		
		for (int i=0; i<dependencies.length; i++)
		{
			if (dMap.containsKey(dependencies[i][0]))
			{
				HashSet<Character> cProjectList = dMap.get(dependencies[i][0]);
				cProjectList.add(dependencies[i][1]);
			} 
			else 
			{
				HashSet<Character> cProjectList = new HashSet<Character>();
				cProjectList.add(dependencies[i][1]);
				dMap.put(dependencies[i][0], cProjectList);
			}
		}
		
		LinkedList<Character> queue = new LinkedList<Character>();
		for (char cProject : pSet)
		{
			if (!dMap.containsKey(cProject))
				queue.add(cProject);
		}
		
		int index = 0;
		char[] answer = new char[projects.length];
		while (!queue.isEmpty())
		{
			char cProject = queue.poll();
			removeCProject(cProject, dMap, queue);
			answer[index] = cProject;
			index++;
		}
		
		if (index == projects.length)
			return answer;
		else
		{
			char[] error = {'e','r','r','o','r'};
			return error;
		}
	}

	private void removeCProject(char cProject, HashMap<Character, HashSet<Character>> dMap, LinkedList<Character> queue)
	{
		for (HashMap.Entry<Character, HashSet<Character>> entry : dMap.entrySet())
		{
			HashSet<Character> cProjectList = entry.getValue();
			
			if (cProjectList.contains(cProject))
			{
				cProjectList.remove(cProject);
				
				if (cProjectList.isEmpty())
					queue.add(entry.getKey());
			}
		}
	}
	
	public static void main(String[] args)
	{
		char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};
		char[][] dependencies = {{'d', 'a'}, {'b', 'f'}, {'d', 'b'}, {'a', 'f'}, {'c', 'd'}};
		
		Solution7 test = new Solution7();
		
		System.out.println(test.buildOrder(projects, dependencies));
	}
}
