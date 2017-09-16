package careercup.questions.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sibendu on 7/3/2017.
 * Question link : https://www.careercup.com/question?id=5672092990177280
 */
public class MinimumDrinks {

    public static void main( String args[]) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Integer> choiceList[] = new ArrayList[N];
        for ( int i = 0 ; i < N ; i++) {
            System.out.println("Enter choices for " + i + " person");
            int choice = sc.nextInt();
            choiceList[i] = new ArrayList<>();
            for (int j = 0; j < choice; j++) {
                choiceList[i].add(sc.nextInt());
            }
        }

        findMinimumDrinks(choiceList);
    }

    private static void findMinimumDrinks(List<Integer>[] choiceList) {

        if ( choiceList.length == 1)    {
            System.out.print(choiceList[0].get(0));
            return;
        }

        List<Integer> output = choiceList[0].subList( 0 , choiceList[0].size() );

        for ( int i = 1 ; i < choiceList.length ; i++)  {
            for ( int j  = 0 ; j < choiceList[i].size() ; j++)  {
                if ( output.contains(choiceList[i].get(j))) {
                    break;
                }
            }
        }

    }
}
