package careercup.questions.facebook;

import java.util.Stack;

/**
 * Created by sibendu on 11/6/17.
 */
public class CelebrityProblem {

    static int knowMatrix[][] = new int[][] {
            { 0 , 0 , 1 , 0},
            { 0 , 0 , 1, 0},
            { 0 , 0 , 0 , 0},
            { 0 , 0 , 1, 0}
    };

    public static int findCelebrity(int[][] knowMatrix, int N) {

        Stack<Integer> stack = new Stack<>();

        for ( int i = 0 ; i < N ; i++)
            stack.push(i);

        int A = stack.pop();
        int B = stack.pop();

        while (stack.size() > 1)    {
            if ( knows(A , B))  {
                A = stack.pop();
            }
            else    {
                B = stack.pop();
            }
        }


        int C = stack.pop();

        if ( knows(C , A))  {
            C = A;
        }

        if ( knows( C , B)) {
            C = B;
        }

        for ( int i = 0 ; i < N ; i++)  {
            if ( i != C && (knows( C , i ) || !knows(i , C)))    {
                return -1;
            }
        }
        return C;

    }

    private static boolean knows(int a, int b) {
        return knowMatrix[a][b] == 1 ? true : false;
    }

    public static void main(String args[])  {

        System.out.println(findCelebrity(knowMatrix , 4));

    }
}
