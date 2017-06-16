package trees;

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
	

}
