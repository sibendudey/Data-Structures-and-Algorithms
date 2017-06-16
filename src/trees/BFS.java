package trees;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createTree();
		performBFS(root);
	}

	private static void performBFS(Node root) {
		// TODO Auto-generated method stub
		
	}

	private static Node createTree() {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.leftNode = new Node(2);
		root.rightNode = new Node(3);
		root.leftNode.leftNode = new Node(4);
		root.leftNode.rightNode = new Node(5);
		root.rightNode.leftNode = new Node(6);
		root.rightNode.rightNode = new Node(7);
		root.leftNode.rightNode.leftNode = new Node(8);
		return root;
	}

}
