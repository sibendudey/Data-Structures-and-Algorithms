package trees.and.graphs;

public class Node {
	int data;
	Node leftNode;
	Node rightNode;
	
	public Node(int data)	{
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getleftNode() {
		return leftNode;
	}
	public void setleftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	public static Node createTree() {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.setleftNode(new Node(2));
		root.setRightNode(new Node(3));
		Node leftNodeNode = root.getleftNode();
		leftNodeNode.setleftNode(new Node(4));
		leftNodeNode.setRightNode(new Node(5));
		Node rightNode = root.getRightNode();
		rightNode.setleftNode(new Node(6));
		rightNode.setRightNode(new Node(7));
		return root;
	}
	
	public static Node createBinaryTree()	{
		Node root  = new Node(1);
		 root.leftNode = new Node(2);
         root.rightNode = new Node(3);
 
         root.leftNode.leftNode = new Node(4);
         root.leftNode.rightNode = new Node(5);
         root.rightNode.leftNode = new Node(6);
         root.rightNode.rightNode = new Node(7);
 
         root.leftNode.leftNode.leftNode = new Node(8);
         root.leftNode.leftNode.rightNode = new Node(9);
         root.leftNode.rightNode.leftNode = new Node(10);
         root.leftNode.rightNode.rightNode = new Node(11);
         root.rightNode.leftNode.leftNode = new Node(12);
         root.rightNode.leftNode.rightNode = new Node(13);
         root.rightNode.rightNode.leftNode = new Node(14);
         root.rightNode.rightNode.rightNode = new Node(15);
 
         root.leftNode.leftNode.leftNode.leftNode = new Node(16);
         root.leftNode.leftNode.leftNode.rightNode = new Node(17);
         root.leftNode.leftNode.rightNode.leftNode = new Node(18);
         root.leftNode.leftNode.rightNode.rightNode = new Node(19);
         root.leftNode.rightNode.leftNode.leftNode = new Node(20);
         root.leftNode.rightNode.leftNode.rightNode = new Node(21);
         root.leftNode.rightNode.rightNode.leftNode = new Node(22);
         root.leftNode.rightNode.rightNode.rightNode = new Node(23);
         root.rightNode.leftNode.leftNode.leftNode = new Node(24);
         root.rightNode.leftNode.leftNode.rightNode = new Node(25);
         root.rightNode.leftNode.rightNode.leftNode = new Node(26);
         root.rightNode.leftNode.rightNode.rightNode = new Node(27);
         root.rightNode.rightNode.leftNode.leftNode = new Node(28);
         root.rightNode.rightNode.leftNode.rightNode = new Node(29);
         root.rightNode.rightNode.rightNode.leftNode = new Node(30);
         root.rightNode.rightNode.rightNode.rightNode = new Node(31);
         
         return root;
 
	}

	public static Node createDisBalancedTree() {
		// TODO Auto-generated method stub
		Node root = new Node(10);
	    root.leftNode = new Node(8);
	    root.leftNode.leftNode = new Node(7);
	    root.leftNode.leftNode.leftNode = new Node(6);
	    root.leftNode.leftNode.leftNode.leftNode = new Node(5);
		
		return root;
	}
}
