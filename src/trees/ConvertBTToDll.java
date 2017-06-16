package trees.and.graphs;

import java.util.LinkedList;
import java.util.Queue;

class NodeDLL	{
	 NodeDLL(int data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}
	int data;
	NodeDLL next;
	NodeDLL prev;
}
public class ConvertBTToDll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createTree();
		Queue<Node> queue = new LinkedList<Node>();
		inOrder(root , queue);
		NodeDLL head = createDLL(queue);
		printDLL(head);
	}

	private static void printDLL(NodeDLL head) {
		// TODO Auto-generated method stub
		while ( head != null)	{
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	private static NodeDLL createDLL(Queue<Node> queue) {
		// TODO Auto-generated method stub
		NodeDLL head = null;
		NodeDLL curr = null;
		NodeDLL prev = null;
		if ( queue.size() > 0)	{
			head = new NodeDLL(queue.remove().data);
			head.prev = null;
			curr = head;
		}
		while ( queue.size() > 0)	{
			curr.next = new NodeDLL(queue.remove().data);
			prev = curr;
			curr = curr.next;
			curr.prev = prev;
		}
		
		return head;
	}

	private static void inOrder(Node root, Queue<Node> queue) {
		// TODO Auto-gene
		if ( root == null)	
			return;
		
		inOrder(root.leftNode, queue);
		queue.add(root);
		inOrder(root.rightNode, queue);
	}

	private static Node createTree() {
		// TODO Auto-generated method stub
		Node root        = new Node(10);
	    root.leftNode        = new Node(12);
	    root.rightNode       = new Node(15);
	    root.leftNode.leftNode  = new Node(25);
	    root.leftNode.rightNode = new Node(30);
	    root.rightNode.leftNode = new Node(36);
		return root;
	}

}
