package arrays;

public class CountMinSteps {
	
	static int arr[] = new int[]{2,1};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int minEvenNumber = 9990;
		int minOddNumber = 9991 ;
		int oddStepsMinusEvenNumber = 0;
//		int noOfZeros = 0;
		int noOfSteps = 0;
		
		for ( int i = 0 ; i < arr.length ; i++)	{

			if (arr[i] % 2 == 0 &&  arr[i] != 0 && arr[i] <= minEvenNumber)	{
				minEvenNumber = arr[i];
			}
			if (arr[i] % 2 == 1 && arr[i] <= minOddNumber)	{
				minOddNumber = arr[i];
			}
		}
		
		System.out.println(minEvenNumber + "" + minOddNumber);
		
		if ( minEvenNumber > minOddNumber && minOddNumber != 9991){
			//System.out.println("Sibendu");
			minEvenNumber = minOddNumber - 1 ;
		}
		else if ( minEvenNumber == 9990)
			minEvenNumber = 0;

		
		System.out.println(minEvenNumber);
		
		for ( int i = 0 ; i < arr.length  ; i++)	{
			
			oddStepsMinusEvenNumber += arr[i] - minEvenNumber;
		}
		
		if (minEvenNumber != 0){
		for (int i = 0 ; i < arr.length ; i++)	{
			if (arr[i] != 0)	{
				noOfSteps++;
			}
		}
		System.out.println("Minimum steps are:" + (noOfSteps + oddStepsMinusEvenNumber + (int)(Math.log(minEvenNumber)/Math.log(2))));
		}
		else	{
			System.out.println("Minimum steps are:" + (oddStepsMinusEvenNumber));
		}
		
		
		//System.out.println("Minimum steps are:" + );
		

	}

}
