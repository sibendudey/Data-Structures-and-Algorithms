package trees;

import java.util.HashMap;

public class PrintTopView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Boolean> colCheck = new HashMap<Integer , Boolean>();
		Node root = Node.createTree();
		printTopView(root,colCheck,0);
		
	}

	private static void printTopView(Node root, HashMap<Integer, Boolean> colCheck, int col) {
		// TODO Auto-generated method stub
		if ( root != null && colCheck.get(col) == null){
			System.out.print(root.data);
			colCheck.put(col, true);
		}
		
		if (root.getleftNode() != null)	{
			printTopView(root.leftNode , colCheck , col - 1);
		}
		
		if ( root.getRightNode() != null)	{
			printTopView(root.getRightNode(), colCheck, col + 1);
		}
	}

}
