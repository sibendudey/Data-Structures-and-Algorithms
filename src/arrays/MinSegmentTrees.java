package arrays;

public class MinSegmentTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[]{12,34,33,10,-1,100, -5};
		int tree[] = formSegmentTree(arr);
		printTreeValues(tree);
		
	}
	
	private static void printTreeValues(int[] tree) {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < tree.length ; i++){
			System.out.print(tree[i] + " ");
		}
		
	}

	private static int[] formSegmentTree(int[] arr) {
		// TODO Auto-generated method stub
		int length = arr.length;
		int tree[] = new int[(int) (2* Math.pow(2, (int)Math.ceil(Math.log(arr.length) / Math.log(2)))) - 1]; 
		formSegmentTreeUtil(tree , 0 , length - 1 , 0 , arr);
		return tree;
	}

	private static int formSegmentTreeUtil(int[] tree, int startIndex, int endIndex, int currentIndex,
			int[] arr) {
		// TODO Auto-generated method stub
		if ( startIndex == endIndex)	{
			tree[currentIndex] = arr[startIndex];
			return tree[currentIndex];
		}
		else	{
			int mid = startIndex + (endIndex - startIndex)/2;
			int leftMin = formSegmentTreeUtil(tree, startIndex, mid, 2*currentIndex + 1, arr);
			int rightMin = formSegmentTreeUtil(tree, mid+1, endIndex, 2*currentIndex + 2, arr);
			tree[currentIndex] = leftMin <= rightMin ? leftMin : rightMin;
			return tree[currentIndex];
		}
	}

}
