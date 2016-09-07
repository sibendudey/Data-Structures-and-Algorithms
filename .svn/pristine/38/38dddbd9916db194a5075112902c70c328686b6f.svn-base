package arrays;

public class PeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 25, 15, 35, 36, 37 };
		System.out.println(findPeakElement(arr, 0, arr.length - 1));
	}

	private static int findPeakElement(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		int mid = (start + end) / 2;

		if ((mid == 0 || arr[mid] > arr[mid - 1])
				&& (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
			return arr[mid];
		} else if (mid > 0 && (arr[mid] < arr[mid + 1])) {
			return findPeakElement(arr, mid + 1, arr.length - 1);
		} else {
			return findPeakElement(arr, 0, mid - 1);
		}
	}
}
