package arrays;

public class SegmentTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {23,45,12,35,54,100,133};
		System.out.println(Math.ceil(Math.log(arr.length) / Math.log(2)));
		
		int tree[] = formSegmentTree(arr);
		
		printTreeValues(tree);
		System.out.println();
		findRangeSum(tree , 1,5 , arr);
		
		updateValue(tree , arr , 4 , 100);
		System.out.println();
		printTreeValues(tree);
		
		
	}

	private static void updateValue(int[] tree, int[] arr, int indexMod, int newValue) {
		// TODO Auto-generated method stub
		int diff = newValue - arr[indexMod];
		arr[indexMod] = newValue;
		updateValueUtil(tree , 0 , arr.length - 1 , 0 , indexMod , diff );
		
	}

	private static void updateValueUtil(int[] tree, int startIndex, int endIndex, int currentIndex,
			int indexMod, int diff) {
		// TODO Auto-generated method stub
		tree[currentIndex] += diff;
		int mid = startIndex + (endIndex - startIndex) /2 ;
		
		if ( startIndex == endIndex)
			return;
		if ( mid < indexMod)	{
			updateValueUtil(tree , mid+1 , endIndex , currentIndex*2 + 2 , indexMod , diff);
		}
		else	{
			updateValueUtil(tree , startIndex , mid , currentIndex*2 + 1 , indexMod , diff);
		}
		
	}

	private static void printTreeValues(int[] tree) {
		// TODO Auto-generated method stub
		for ( int i = 0 ; i < tree.length ; i++){
			System.out.print(tree[i] + " ");
		}
		
	}

	private static void findRangeSum(int [] tree, int i, int j,
			int[] arr) {
		// TODO Auto-generated method stub
		System.out.println(findRangeSumUtil( tree , 0 , arr.length - 1 , 0 ,  i , j ));
	}

	private static int findRangeSumUtil(int[] tree, int sumIndex1, int sumIndex2 , int currentIndex , int rangeIndex1,
			int rangeIndex2) {
		// TODO Auto-generated method stub
		
		if ( rangeIndex1 <= sumIndex1 && rangeIndex2>=sumIndex2)	{
			//System.out.println("It is in here");
			return tree[currentIndex];
		}
		if (rangeIndex1 > sumIndex2  || rangeIndex2 < sumIndex1)	{
			//System.out.println("It is also in here");
			return 0;
		}
		
		int mid = sumIndex1 + (sumIndex2-sumIndex1)/2;
		return findRangeSumUtil(tree , sumIndex1 , mid , currentIndex*2+1 , rangeIndex1 , rangeIndex2 ) + 
				findRangeSumUtil(tree , mid+1 , sumIndex2 , currentIndex*2+2 , rangeIndex1 , rangeIndex2 ); 
		
	}

	private static int[] formSegmentTree(int[] arr) {
		// TODO Auto-generated method stub
		int length = arr.length;
		System.out.println((int) ((int) 2*(Math.pow(2, Math.ceil(Math.log(length)/ Math.log(2))))) - 1);
		int tree[] = new int[(int) ((int) 2*(Math.pow(2, (int)Math.ceil(Math.log(length)/ Math.log(2))))) - 1];
		//System.out.println("tree length=" + tree.length );
		formSegmentTreeUtil(tree , 0 , length -1 , 0 , arr);
		return tree;
	}

	private static int formSegmentTreeUtil(int[] tree, int index1, int index2, int currentIndex,
			int[] arr) {
		// TODO Auto-generated method stub
		if ( index1 == index2)	{
			System.out.println(index1);
			tree[currentIndex] = arr[index1];
			return tree[currentIndex];
		}
		
		
		else	{
			int mid = index1 + (index2 - index1)/2;
			tree[currentIndex] = formSegmentTreeUtil(tree , index1 , mid , currentIndex*2 + 1 , arr)
					+ formSegmentTreeUtil(tree , mid+1 , index2 , currentIndex*2 + 2 , arr);
			
			return tree[currentIndex];
		}
	}
	
	
	

}
