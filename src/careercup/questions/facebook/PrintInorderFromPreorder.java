package careercup.questions.facebook;

import trees.Node;
import trees.TreeBuilder;

import java.util.Stack;

/**
 * Created by Sibendu Dey on 6/16/2017
 * Question Link : https://www.careercup.com/question?id=5663945672097792
 *
 * This solution has been taken from the above link..( Original solution is in Python)
 */
public class PrintInorderFromPreorder {

    static int currIndex = 0;
    public static void main(String args[])  {

        int array[] = { 22 , 12 , 11 , 15, 14 , 25, 24 , 31 , 29 };

        printInOrder(array);


    }

    private static void printInOrder(int[] array) {


        Stack<Integer> stack = new Stack<>();
        stack.add(array[0]);
        int index = 1;

        while ( index < array.length)   {
            if ( stack.size() == 0 && stack.peek() > array[index])  {
                stack.add(array[index]);
            }
            else    {
                while ( stack.size() != 0 && stack.peek() < array[index])   {
                    System.out.print(stack.pop() + " ");
                }
                stack.add(array[index]);
            }
            index = index + 1;
        }
    }

    private static void printInOrderUtil(int[] array, int parent) {
        int currentRoot = array[currIndex];


    }
}
