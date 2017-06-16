package trees;

public class InorderPreOrder {

	static int preOrderCurr = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int preOrder[] = new int[] {1,2,3,4,5,6,7,8};
		int inOrder[] = new int[] {3,2,1,5,4,7,6,8};
		Node root = createTree(preOrder , inOrder);
		CommomUtilityFunc cuf = new CommomUtilityFunc();
		cuf.inOrderTraversal(root);
		
	}

	private static Node createTree(int[] preOrder, int[] inOrder) {
		// TODO Auto-generated method stub
		Node root = new Node(preOrder[0]);
		int i = 0;
		for ( ; i < inOrder.length && inOrder[i] != preOrder[preOrderCurr] ; i++);
			
		preOrderCurr++;
		root.leftNode = createTreeUtil( preOrder , inOrder , 0 , i - 1 );
		root.rightNode = createTreeUtil( preOrder , inOrder , i+1 , inOrder.length - 1);
		return root;
	}

	private static Node createTreeUtil(int[] preOrder, int[] inOrder, int low, int high) {
		// TODO Auto-generated method stub
		if ( low > high)	{
			return null;
		}
		else	{
			Node subRoot = new Node(preOrder[preOrderCurr]);
			int i = low;
			for ( ; i <= high && inOrder[i] != preOrder[preOrderCurr] ; i++);
			
			preOrderCurr++;
			subRoot.leftNode = createTreeUtil ( preOrder , inOrder , low , i - 1);
			subRoot.rightNode = createTreeUtil(preOrder, inOrder, i+1, high);
			return subRoot;
		}
	}

	private static Node createTree() {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.leftNode = new Node(2);
		root.leftNode.leftNode = new Node(3);
		root.rightNode = new Node(4);
		root.rightNode.leftNode = new Node(5);
		root.rightNode.rightNode = new Node(6);
		root.rightNode.rightNode.leftNode = new Node(7);
		root.rightNode.rightNode.rightNode = new Node(8);
		
		return root;
	}

}
