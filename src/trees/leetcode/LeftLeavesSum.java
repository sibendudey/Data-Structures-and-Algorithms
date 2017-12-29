package trees.leetcode;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.TreeMap;

public class LeftLeavesSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {

        if ( root == null)
            return 0;
        int rightSum = sumOfLeftLeaves(root.right);

        int leftSum = 0;
        if ( root.left != null && root.left.left == null && root.left.right == null)
            leftSum = root.left.val;
        else
            leftSum = sumOfLeftLeaves(root.left);

        return rightSum + leftSum;
    }

    public static void main(String args[])  {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new LeftLeavesSum().sumOfLeftLeaves(root));
    }
}
