package strings;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;

class Suffix implements Comparable<Suffix>	{
	int index;
	String suffix;
	@Override
	public int compareTo(Suffix s1) {
		return suffix.compareTo(s1.suffix);  
	}
}

public class SuffixArray {
	public static void main(String[] args) {
		String str = "banana";
		createSuffixArray(str);
	}

	private static void createSuffixArray(String str) {
		int length = str.length();
		ArrayList<Suffix> suffixes = new ArrayList<Suffix>();
		for ( int i = 0 ; i < length ; i++)	{
			Suffix suffix = new Suffix();
			suffix.index = i;
			suffix.suffix = str.substring(i , length);
			suffixes.add(suffix);
		}
		Collections.sort(suffixes);
		
		int suffixArray[] = new int[length];
		for ( int i = 0 ;  i < suffixes.size() ; i++){
			suffixArray[i] = suffixes.get(i).index;
		}
		
		printSuffixArray(suffixArray);
	}

	private static void printSuffixArray(int[] suffixArray) {
		// TODO Auto-generated method stub
		for ( int i : suffixArray){
			System.out.println(i + " ");
		}
	}

}
