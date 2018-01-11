package trees.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumSumPath {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    static List<Integer> path;
    static int sum = 0;
    public List<Integer> maxPathSum(TreeNode root) {
        if ( root == null)
            return new ArrayList<>();

        sum = Integer.MIN_VALUE;

        maxPathSumUtil(root);
        return path;

    }

    private List<Integer> maxPathSumUtil(TreeNode root)   {
        if ( root == null)
            return new ArrayList<>();

        List<Integer> currRoot = new ArrayList<>();
        List<Integer> leftTree = maxPathSumUtil(root.left);

        int leftTreeSum = Math.max(0, leftTree.stream().mapToInt(l -> l).sum());
        int currSum = leftTreeSum;
        if ( leftTreeSum > 0)
            currRoot.addAll(leftTree);

        currSum += root.val;
        currRoot.add(root.val);

        List<Integer> rightTree = maxPathSumUtil(root.right);
        int rightTreeSum = Math.max(0, rightTree.stream().mapToInt( l -> l ).sum());
        currSum += rightTreeSum;
        if ( rightTreeSum > 0)
            currRoot.addAll(rightTree);

        if ( currSum > sum) {
            path = new ArrayList<>();
            path.addAll(currRoot);
            sum = currSum;
        }

        if ( leftTreeSum > rightTreeSum)    {
            currRoot.removeAll(rightTree);
        }
        else if ( rightTreeSum > leftTreeSum)   {
            currRoot.removeAll(leftTree);
        }

        return currRoot;
    }

    public static void main(String args[])  {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(100);
        root.left.left.right = new TreeNode(101);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(7);

        new MaximumSumPath().maxPathSum(root).forEach( t -> System.out.print( t  + " "));
    }

}
