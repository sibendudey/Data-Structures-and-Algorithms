package matrix;

public class SpiralDisplayMatrix {

	public static void main(String[] args) {
		int arr[][] = new int[][]{ {1,2,3}, {4,5,6} , {7,8,9}};
		
		for (int l=0,k=0; l<3 && k<3;l++,k++)	{
			for (int x = k; x < 2 ; x++)	{
				System.out.println(arr[l][x]);
			}
			for (int y = l ; y < 2; y++)	{
				System.out.println(arr[y][k]);
			}
			
		}

	}

}
