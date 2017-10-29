package strings.geeksforgeeks;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This question contains the solution for the following link:
 *  http://www.geeksforgeeks.org/shortest-substring-string-containing-given-words/
 */
public class ShortSubAllWords {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        int wordsArrayLength = sc.nextInt();
        String[] wordsArray = new String[wordsArrayLength];
        for (int i = 0 ; i < wordsArrayLength ; i++)    {
            wordsArray[i] = sc.next();
        }
        int shortestSubstringLength = calculateSubstringLength(sentence, wordsArray);
    }

    private static int calculateSubstringLength(String sentence, String[] wordsArray) {
        Map<String, Integer> wordsMap = getWordsMap(wordsArray);
        String[] sentenceWords = sentence.split(" ");
        int shortestSubstringLength = Integer.MAX_VALUE;
        for ( int i = 0 ; i < sentenceWords.length ; i++)  {
            int tempCount = 0;
            if ( wordsMap.get(sentenceWords[i]) == -1)  {
                tempCount++;
                if ( tempCount == wordsArray.length)    {
                    if (shortestSubstringLength > calculatePresentSubstringLength(wordsMap))
                }

            }
        }
    }

    private static int calculateSubstringLength(String[] words, Map<String, Integer> wordsMap) {
        int shortestLength = Integer.MIN_VALUE;
        int tempCount = 0;
        for (int i = 0 ; i < words.length ; i++)    {

        }
    }

    private static Map<String,Integer> getWordsMap(String[] wordsArray) {
        Map<String, Integer> wordsMap = new HashMap<>();
        Arrays.asList(wordsArray).forEach((word) -> {
            wordsMap.put(word , -1);
        });
        return wordsMap;
    }
}
