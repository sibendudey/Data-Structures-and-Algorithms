package trees;

public class ConvertBTTToDLLInPlace {
	static Node prev = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = createTree();
		// inPlaceConvert(root);
		inPlaceConvert2(root);
		printDLL(root);
	}

	private static void inPlaceConvert2(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;

		inPlaceConvert2(root.leftNode);

		if (prev == null) {
			root.leftNode = prev;
			prev = root;
		} else {
			root.leftNode = prev;
			prev.rightNode = root;
			prev = root;
		}

		inPlaceConvert2(root.rightNode);
	}

	private static void printDLL(Node root) {
		// TODO Auto-generated method stub
		while (root.leftNode != null) {
			root = root.leftNode;
		}

		while (root != null) {
			System.out.print(root.data + " ");
			root = root.rightNode;
		}
	}

	private static Node inPlaceConvert(Node root) {
		// TODO Auto-generated method stub
		if (root.leftNode != null) {
			Node inOrderPredecessor = inPlaceConvert(root.leftNode);
			for (; inOrderPredecessor.rightNode != null; inOrderPredecessor = inOrderPredecessor.rightNode)
				;
			inOrderPredecessor.rightNode = root;
			root.leftNode = inOrderPredecessor;
		}

		if (root.rightNode != null) {
			Node inOrderSuccessor = inPlaceConvert(root.rightNode);
			for (; inOrderSuccessor.leftNode != null; inOrderSuccessor = inOrderSuccessor.leftNode)
				;
			inOrderSuccessor.leftNode = root;
			root.rightNode = inOrderSuccessor;

		}

		return root;
	}

	private static Node createTree() {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.leftNode = new Node(12);
		root.rightNode = new Node(15);
		root.leftNode.leftNode = new Node(25);
		root.leftNode.rightNode = new Node(30);
		root.rightNode.leftNode = new Node(36);
		return root;
	}
}
