package trees.and.graphs;

import java.util.ArrayList;
//import java.util.HashMap;
import java.util.TreeMap;
//import java.util.TreeSet;

public class AncestorMatrix_2 {
	
	static int ancestor[][] = new int[][]{
			{0, 0 , 0 , 0 , 0,  0} ,
		       {1 ,  0,  0,  0, 1,  0}, 
		       {0 ,  0,  0,  1,  0,  0}, 
		       {0 ,0, 0, 0, 0, 0}, 
		       {0, 0,0, 0, 0, 0}, 
		       {1, 1, 1, 1, 1, 0 }
	};
	
	static final int ROW = 6;
	static final int COL = 6;
	
	public static void main(String args[])	{
		Node treeMap[] = new Node[6];
		boolean parent[] = new boolean[6]; 
		Node root = null;
		TreeMap<Integer, ArrayList<Integer>> count = new TreeMap<Integer , ArrayList<Integer>>();
		
		/*for ( int i = 0 ; i < ROW ; i++)	{
			count.put(i, 0);
		}*/
		for ( int i = 0 ; i < ROW ; i++)	{
			int sum = 0 ;
			for ( int j = 0 ; j < COL ; j++)	{
				//root = buildTree( i , j , root , treeMap);
				if (ancestor[i][j] == 1)	{
						 sum = sum + ancestor[i][j];
				}	
			}
			if (count.containsKey(sum))	{
				ArrayList<Integer> list = count.get(sum);
				list.add(i);
			}
			else	{
				count.put(sum, new ArrayList<Integer>());
				count.get(sum).add(i);
			}
			
		}
		
		for ( int key : count.keySet()){
			ArrayList<Integer> list = count.get(key);
			for ( int node : list)	{
				root = buildTree( node  , root , treeMap , parent);
			}
		}
		
		inOrderTraversal(root);
		
		}
	
	
	private static Node buildTree( int node , Node root , Node[] treeMap , boolean[] parent) {
		// TODO Auto-generated method stub
		root = new Node(node);
		treeMap[node] = root;
		for ( int i = 0 ; i < 6 ;  i++)	{
			if (ancestor[node][i] == 1 && !parent[i])	{
				if (treeMap[node].getLeftNode() == null)	{
					treeMap[node].setLeftNode(treeMap[i]);
					parent[i] = true;
				}
				else if (treeMap[node].getRightNode() == null)	{
					treeMap[node].setRightNode(treeMap[i]);
					parent[i] = true;
				}
			}
		}
		
		return root;
	}
	
	
	private static void inOrderTraversal(Node root)	{
		if (root == null)	{
			return;
		}
		else	{
			if (root.getLeftNode() != null)
				inOrderTraversal(root.getLeftNode());
			System.out.print(root.getData() + " ");
			if (root.getRightNode() != null)
				inOrderTraversal(root.getRightNode());
		}
	}

		
		//root = Node.createTree();

	private static void levelOrderTraversal(Node root) {
		// TODO Auto-generated method stub
		 int height = calculateHeight(root);
		 for ( int i = 1 ; i <= height ; i++)	{
			 printLevelTree(root,i);
		 }
		
	}
	


	private static void printLevelTree(Node root, int level) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		
		if ( level == 1)
			System.out.print(root.getData());
		else	{
			if (root.getLeftNode() != null)
				printLevelTree(root.getLeftNode(), level - 1);
			if (root.getRightNode() != null)
				printLevelTree(root.getRightNode() , level - 1);
		}
		
	}

	private static int calculateHeight(Node root) {
		// TODO Auto-generated method stub
	
		int lHeight = 1;
		int rHeight = 1;
		 
		if (root.getLeftNode() != null)
		  lHeight = lHeight + calculateHeight(root.getLeftNode());
		
		if ( root.getRightNode() != null)
		 rHeight =  lHeight + calculateHeight(root.getRightNode());
		
		if (lHeight >= rHeight)
			return lHeight;
		else
			return rHeight;
	}


}
