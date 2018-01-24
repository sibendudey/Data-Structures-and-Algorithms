package stacks.leetcode;

import java.util.Stack;

public class Asteroid {
    public static void main(String args[]) {

    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];
            if (curr < 0) {
                while (stack.size() != 0
                        && stack.peek() > 0
                        && Math.abs(curr) > Math.abs(stack.peek()))
                    stack.pop();

                if (stack.size() == 0)  {
                    stack.push(curr);
                }
                else    {
                    while (stack.peek()== Math.abs(curr))  stack.pop();
                    if ( stack.size() == 0 || stack.peek() < 0) stack.push(curr);
                }

            } else
                stack.push(curr);
        }

        int result[] = new int[stack.size()];
        int size = stack.size();
        for (int i = size - 1; i >= 0; i--)
            result[i] = stack.pop();

        return result;
    }
}
