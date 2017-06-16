package trees;

public class SerializeTree {

	static int arrayIterator = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createTree();
		int array[] = new int[999];
		serializeTree(array , root);
		printArray(array);
		arrayIterator = 0;
		Node rootDeserialize = deserializeTree( array);
		preorderTraversal(rootDeserialize);
	}

	private static void preorderTraversal(Node rootDeserialize) {
		// TODO Auto-generated method stub
		if ( rootDeserialize == null)
			return;
		
		System.out.print(rootDeserialize.data + " ");
		preorderTraversal(rootDeserialize.leftNode);
		preorderTraversal(rootDeserialize.rightNode);
	}

	private static Node deserializeTree(int[] array) {
		// TODO Auto-generated method stub
		if ( array[arrayIterator] == -1)	{
			arrayIterator++;
			return null;
		}
		Node root = new Node(array[arrayIterator++]);
		root.leftNode = deserializeTree(array);
		root.rightNode = deserializeTree(array);
		return root;
	}

	private static void printArray(int[] array) {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < arrayIterator ; i++)	{
			System.out.print(array[i] + " ");
		}
	}

	private static void serializeTree(int[] array, Node root) {
		// TODO Auto-generated method stub
		if ( root == null)	{
			array[arrayIterator++] = -1;
			return;
		}
		
		array[arrayIterator++] = root.data;
		serializeTree(array ,root.leftNode );
		serializeTree( array , root.rightNode);
		
	}

	private static Node createTree() {
		// TODO Auto-generated method stub
		/*Node root = new Node(20);
		root.leftNode = new Node(8);
		root.leftNode.leftNode = new Node(4);
		root.leftNode.rightNode = new Node(12);
		root.leftNode.rightNode.leftNode = new Node(10);
		root.leftNode.rightNode.rightNode = new Node(14);*/
		Node root = new Node(20);
		root.leftNode = new Node(8);
		root.leftNode.leftNode = new Node(10);
		root.leftNode.leftNode.leftNode = new Node(5);
		return root;
	}

}
