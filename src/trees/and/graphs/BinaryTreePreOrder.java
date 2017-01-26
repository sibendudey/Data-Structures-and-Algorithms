package trees.and.graphs;

public class BinaryTreePreOrder {
	
	static int index = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pre[] = {10, 5, 1, 7, 40, 50};
		Node head = null;
		head = constructTree( pre , 0 , 9999);
		System.out.println(head.leftNode.leftNode.data);
		inOrderTraversal(head);

	}

	private static void inOrderTraversal(Node head) {
		// TODO Auto-generated method stub
		if (head.leftNode != null)	{
			inOrderTraversal(head.leftNode);
		}
		System.out.print(head.data + " ");
		
		if ( head.rightNode != null)	{
			inOrderTraversal(head.rightNode);
		}
		
		
	}

	private static Node constructTree( int[] pre, int min, int max) {
		// TODO Auto-generated method stub

		
		Node root = null;
		if ( pre[index] > min && pre[index] < max)	{
			root = new Node(pre[index]);
		
		index = index + 1;
		System.out.println(index);
		if ( index < pre.length )	{
			root.leftNode = constructTree(pre , min , root.data );
			root.rightNode = constructTree(pre, root.data , max );
		}
		}
		
		return root;
		
	}

	private static Node constructTree(Node head, int[] pre) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

}
