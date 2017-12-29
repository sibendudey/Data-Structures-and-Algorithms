package trees.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class UnivaluePath {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String args[])  {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);

        System.out.println(new UnivaluePath().longestUnivaluePath(root));

        TreeNode root2 = new TreeNode(5);
        root2.right = new TreeNode(5);
        root2.right.right = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(1);

        System.out.println(new UnivaluePath().longestUnivaluePath(root2));
    }

    public int longestUnivaluePath(TreeNode root) {
        if ( root == null)
            return 0;

        int pathThroughRoot = height(root.left , root.val) + height(root.right , root.val);

        int leftValue = longestUnivaluePath(root.left);
        int rightValue = longestUnivaluePath(root.right);

        return Math.max(pathThroughRoot , Math.max(leftValue , rightValue));
    }

    private int height(TreeNode node, int val) {
        if ( node ==  null)
            return 0;

        if ( node.val == val)   {
            return 1 + Math.max(height(node.left , val), height(node.right , val));
        }
        else
            return 0;
    }
}
