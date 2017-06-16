package trees;

public class PrintMaxDiff {
	
	static Integer max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = createTree();
		//Integer max = 0;
		findMaxDiff(root);
		System.out.println(max);
	}

	private static Integer findMaxDiff(Node root) {
		// TODO Auto-generated method stub
		
		// A significantly higher value
		if (root == null)	{
			return 99999;
		}
		
		if (root.leftNode == null && root.rightNode == null)
			return root.data;
		
		int minLeft = findMaxDiff(root.leftNode);
		int minRight = findMaxDiff(root.rightNode);
		
		Integer currMax = root.data - minLeft >= root.data - minRight ? root.data - minLeft : root.data - minRight;
		if ( currMax > max)
			max = currMax.intValue();
		
		int min = root.data < minLeft ? root.data : minLeft ;
		min = min < minRight ? min : minRight;
		
		return min;
	}

	private static int findMin(Node node) {
		
		// TODO Auto-generated method stub
		if ( node == null)
			return 9999;
		
		if ( node.leftNode == null && node.rightNode == null)
			return node.data;
		
		int minLeft = findMin(node.leftNode);
		int minRight = findMin(node.rightNode);
		int min = node.data < minLeft ? node.data : minLeft;
		min = min < minRight ? min : minRight;
		
		return min;
	}

	private static Node createTree() {
		// TODO Auto-generated method stub
		  Node root = new Node(8);
		  root.leftNode = new Node(3);
		 
		    root.leftNode.leftNode = new Node(1);
		    root.leftNode.rightNode = new Node(6);
		    root.leftNode.rightNode.leftNode = new Node(4);
		    root.leftNode.rightNode.rightNode = new Node(7);
		 
		    root.rightNode = new Node(10);
		    root.rightNode.rightNode = new Node(14);
		    root.rightNode.rightNode.leftNode = new Node(13);
		return root;
	}

}
