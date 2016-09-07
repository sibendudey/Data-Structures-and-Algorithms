package com.sibendu.backtracking;

import java.util.HashMap;
import java.util.Set;

public class PatternMatchingNoRegEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "geeksforgeeks";
		String pattern = "gfg";
		HashMap< Character , String> map = new HashMap< Character, String>();
		
		patternMatching(str , 0 , str.length() , pattern , 0 , pattern.length() , map);

	}

	private static void patternMatching(String str, int currStrIndex, int strLength, String pattern, int currPatternIndex
			, int patternLength , HashMap<Character, String> map) {
		// TODO Auto-generated method stub
		
		if ( currStrIndex == strLength && currPatternIndex == patternLength )	{
			Set<Character> keySet = map.keySet();
			for ( Character character : keySet)	{
				System.out.println(character + "->" + map.get(character));
			}
			return;
		}
		
		if ( currStrIndex == strLength || currPatternIndex == patternLength)
			return;
		
		Character patternChar = pattern.charAt(currPatternIndex);
		
		if ( map.containsKey(patternChar))	{
			String patternCharMapping = map.get(patternChar);
			try	{
				System.out.println("current String Index:" + currStrIndex);	
			String nextSubString = str.substring(currStrIndex , currStrIndex + patternCharMapping.length());
			if ( patternCharMapping.equals(nextSubString))
				patternMatching(str , currStrIndex + nextSubString.length() , strLength , pattern , currPatternIndex+1 , patternLength , map);
			else
				return;
				
			} catch (IndexOutOfBoundsException e)	{
				return;
			}
		}
		
		else	{
			for ( int len = 1 ; len <= strLength - currStrIndex ; len++)	{
				System.out.println("patternChar:" + patternChar + "substring:" + str.substring(currStrIndex , currStrIndex + len));
				map.put(patternChar, str.substring(currStrIndex , currStrIndex + len));
				patternMatching(str, currStrIndex+len, strLength, pattern, currPatternIndex+1 , patternLength, map);
				map.remove(patternChar);
			}
		}
			
	}

}
