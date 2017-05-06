package strings;

public class ConstraintStrings {

	static int N = 3;
	static boolean Bflag = false;
	static int noOfC = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "";
		printStrings ( str , 0);
	}

	private static void printStrings(String str, int i) {
		// TODO Auto-generated method stubtr
		if ( i == N )	{
			System.out.print(str + " ");
			return;
		}
		else	{
			printStrings(str + "a", i+1);
			if ( !Bflag)	{
				Bflag = true;
				printStrings( str + "b" , i+1);
				Bflag = false;
			}
			if ( noOfC != 2)	{
				noOfC++;
				printStrings ( str + "c" , i+1);
				noOfC--;
			}
		}
	}

}
