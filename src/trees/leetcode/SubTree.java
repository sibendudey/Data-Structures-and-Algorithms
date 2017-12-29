package trees.leetcode;

public class SubTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String args[])  {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(new SubTree().isSubtree(root, t));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if ( isSubTreeUtil(s, t))
            return true;

        return isSubTreeUtil(s.left, t) || isSubTreeUtil(s.right, t);

    }

    private boolean isSubTreeUtil(TreeNode s, TreeNode t)   {
        if ( s == null && t == null)
            return true;

        if ( s == null || t == null)
            return false;
        else
            return ( s.val == t.val && isSubTreeUtil(s.left, t.left) && isSubTreeUtil(s.right, t.right));
    }

}
