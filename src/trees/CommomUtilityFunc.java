package trees;

public class CommomUtilityFunc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public void inOrderTraversal ( Node root)	{
		if ( root == null)
			return;
		
		inOrderTraversal(root.leftNode);
		System.out.print(root.data + " ");
		inOrderTraversal(root.rightNode);
	}

}
