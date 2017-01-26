package trees.and.graphs;

import java.util.HashMap;
//import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class VerticalSizeTree {
	
	static Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = Node.createTree();
		HashMap<Integer , Integer> levelSums = new HashMap<Integer , Integer>();
		int startLevel = 0; 
		calculateSums(root , startLevel , levelSums);
		printLevelSums(levelSums);

	}
	private static void printLevelSums(HashMap<Integer, Integer> levelSums) {
		// TODO Auto-generated method stub
		for ( Entry<Integer, Integer> sums : levelSums.entrySet()){
			System.out.println("Level:" + sums.getKey() + ", Sum:" + sums.getValue());
		}
		
	}
	private static void calculateSums(Node root, int level , HashMap<Integer , Integer>levelSums) {
		// TODO Auto-generated method stub
		if (levelSums.containsKey(level) == false)	{
			levelSums.put(level , root.getData());
		}
		else	{
			Integer oldValue = levelSums.get(level);
			levelSums.put(level , oldValue + root.getData());
		}
		
		if (root.getLeftNode() != null)
		calculateSums(root.getLeftNode() , level + 1 , levelSums);
		
		if (root.getRightNode() != null)
		calculateSums(root.getRightNode() , level - 1 , levelSums);
	
	}

}

	
}
}

