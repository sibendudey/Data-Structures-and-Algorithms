package dynamic.programming;

public class IncreasingSubsequenceGCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {23,34,12,90,34,15};
		
		printLongest(arr);

	}

	private static void printLongest(int[] arr) {
		// TODO Auto-generated method stub
		int length = arr.length;
		int gcd[] = new int[arr.length];
		for ( int i = 0 ; i < length ; i++){
			gcd[i] = 1;
		}
		for ( int i = 1 ;  i < arr.length ; i ++)	{
			for ( int j = 0 ;  j < i ; j++)	{
				System.out.println("i="+ arr[i]  + "j=" + arr[j] + "gcd="  + gcd(arr[j], arr[i]) );
				if ( arr[j] < arr[i] && (gcd(arr[j],arr[i]) == 1) && gcd[i] < gcd[j] + 1)
					gcd[i] = gcd[j] + 1;
					
			}
		}
		
		int maxGCD = 0;
		for ( int i = 0 ; i < length ;  i++)	{
			if (gcd[i] > maxGCD)
				maxGCD = gcd[i];
		}
		
		System.out.println("Max length GCD is:" + maxGCD);
	}
	
	static int gcd(int m,int n)
	{
	if(n==0)
	return m;
	else if(n>m)
	return gcd(n,m);
	else
	return gcd(n,m%n);
	}

}
