package hash.tables.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class LongestWordDictionary {
    public String longestWord(String[] words) {
        Set<String> wordSet = new TreeSet<>((s1,s2) ->
                s1.length() == s2.length() ?
                        s1.compareTo(s2) :
                        s1.length() > s2.length() ? -1 : 1);

        Arrays.stream(words).forEach(s -> wordSet.add(s));

        wordSet.stream().forEach(s -> System.out.println(s));

        for (String word : wordSet)
            if (check(word, wordSet)) return word;

        return null;
    }

    private boolean check(String word, Set<String> wordSet) {
        StringBuilder sb = new StringBuilder();
        for ( int i = 0 ; i < word.length() ; i++)  {
            char c = word.charAt(i);
            sb.append(c);
            if ( !wordSet.contains(sb.toString())) return false;
        }
        return true;
    }

    public static void main(String args[])  {
        LongestWordDictionary ll = new LongestWordDictionary();
        System.out.println(ll.longestWord(new String [] {"w","wo","wor","worl","world"}));
    }
}
