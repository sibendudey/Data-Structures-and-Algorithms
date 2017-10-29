package arrays.leetcode;

import java.util.*;

public class BaseballGame {
    public static void main(String args[])  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> numberList = new ArrayList<>();
        for ( int i = 0 ; i < N ; i++)  {
            parseInput(sc.next(), numberList);
        }

        System.out.println(calculateSum(numberList));
    }

    private static int calculateSum(List<Integer> numberList) {
        int sum = 0;
        for ( int i = 0 ; i < numberList.size() ; i++)  {
            sum += numberList.get(i);
        }
        return sum;
    }

    private static void parseInput(String input, List<Integer> numberList) {
        switch (input) {
            case "C" :   {
                numberList.remove(numberList.size() - 1);
            }
            break;
            case "D" : {
                numberList.add(2 * numberList.get(numberList.size() - 1));
            }
            break;
            case "+" : {
                int last1 = numberList.get(numberList.size() - 1);
                int last2 = numberList.get(numberList.size() - 2);
                numberList.add(last1 + last2);
            }
            break;
            default:    {
                numberList.add(Integer.parseInt(input));
            }
        }
    }
}
