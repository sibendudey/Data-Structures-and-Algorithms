package trees.leetcode;

import java.util.Stack;

public class SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);

        System.out.println(new SymmetricTree().isSymmetricRecursion(root));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println(new SymmetricTree().isSymmetricRecursion(root2));
    }

    /** My solution. Using level order traversal
    public boolean isSymmetric(TreeNode root) {

        if (root == null)
            return false;

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean allNotNull = true;
        while (!queue.isEmpty() && allNotNull) {
            int size = queue.size();
            allNotNull = false;
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.remove(0);
                if (top != null)
                    allNotNull = true;

                if (top == null) {
                    queue.add(null);
                    queue.add(null);
                } else {
                    queue.add(top.left);
                    queue.add(top.right);
                }
            }

            if (!checkPalindrome(queue))
                return false;
        }
        return true;
    }

    private boolean checkPalindrome(List<TreeNode> queue) {
        for (int i = 0; i < queue.size() / 2; i++) {
            TreeNode leftSide = queue.get(i);
            TreeNode rightSide = queue.get(queue.size() - (i + 1));

            if ( leftSide != null && rightSide != null) {
                if ( leftSide.val != rightSide.val)
                    return false;
            }
            else if ( leftSide != null  || rightSide != null)
                return false;
        }

        return true;
    }
     **/

    /** Recursive solution **/
    public boolean isSymmetricRecursion(TreeNode root)   {
        return root == null || isSymmetricRecursionUtil(root.left , root.right);
    }

    private boolean isSymmetricRecursionUtil(TreeNode left, TreeNode right) {
        if ( left == null || right == null)
            return left == right;

        if ( left.val != right.val)
            return false;

        return isSymmetricRecursionUtil(left.left, right.right) && isSymmetricRecursionUtil(left.right, right.left);
    }

    public boolean isSymmetricNonRecursion(TreeNode root)   {
        if ( root == null)
            return true;

        Stack<TreeNode> stack = new Stack<>();
        if (root.left != null)  {
            if ( root.right == null)
                return false;

            stack.push(root.left);
            stack.push(root.right);
        }
        else if ( root.right != null)
            return false;

        while( !stack.empty())  {
            if ( stack.size() % 2 != 0) return false;

            TreeNode right = stack.pop();
            TreeNode left = stack.pop();

            if ( right.val != left.val)
                return false;

            if ( left.left != null) {
                if ( right.right == null)
                    return false;

                stack.push(right.right);
                stack.push(left.left);
            }
            else if ( right.right != null)
                return false;

            if ( left.right != null)    {
                if ( right.left == null)
                    return false;

                stack.push(left.right);
                stack.push(right.left);
            }
            else if ( right.left != null)
                return false;

        }

        return true;
    }
}
