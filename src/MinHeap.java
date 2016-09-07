
public class MinHeap {

	public static void main(String[] args) {
		
		int arr[] = {1,23,12,34,100,21,56};
		BuildMinHeap(arr);
		for (int index=0;index<arr.length;index++)	{
			System.out.print(arr[index]+" ");
		}	
	}

	private static void BuildMinHeap(int[] arr) {
		int i = (arr.length)/2;
		while(i >= 0)	{
			heapify(arr,i);
			i--;
		}
	}

	private static void heapify(int[] arr, int i) {
		// TODO Auto-generated method stub
		int smallest = i;
		if ( 2*i + 1 < arr.length && arr[i] > arr[2*i + 1])	{
			 smallest = 2*i + 1;
		}
		
		if ( 2*i + 2 < arr.length && arr[2*i+2] < arr[smallest])	{
			smallest = 2*i+2;
		}
		
		if (smallest != i)	{
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = arr[i];
			heapify(arr,smallest);
		}
		
	}
		

}
