package trees;

public class AncestorMatrix {
	
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
		Node root = null;
		for ( int i = 0 ; i < ROW ; i++)	{
			for ( int j = 0 ; j < COL ; j++)	{
				root = buildTree( i , j , root , treeMap);
			}
		}
		
		//root = Node.createTree();
		
		levelOrderTraversal(root);
	}

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

	private static Node buildTree(int i, int j, Node root, Node[] treeMap) {
		// TODO Auto-generated method stub
		if (ancestor[i][j] == 1)	{
			if ( treeMap [i] == null && treeMap[j] == null)	{
				treeMap[i] = new Node(i);
				treeMap[j] = new Node(j);
				treeMap[i].setLeftNode(treeMap[j]);
			}
			else if (treeMap[i] != null && treeMap[j] == null)	{
				treeMap[j] = new Node(j);
				if (treeMap[i].getLeftNode() == null)	{
					treeMap[i].setLeftNode(treeMap[j]);
				}
				else if(treeMap[i].getRightNode() == null) {
					treeMap[i].setRightNode(treeMap[j]);
				}
				else	{
					// do Nothing // Any other node will take care of this node.
				}
			}
			else	{
				
			}
			// If condition to keep track of the root node
			if ( root == null)	{
				root = treeMap[i];
			}
			else 	{
				if (ancestor[i][root.getData()] == 1)	{
					root = treeMap[i];
				}
			}
		}
		return root;
	}

}
