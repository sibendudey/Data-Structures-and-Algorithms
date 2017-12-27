package trees.leetcode;

public class PathSumIII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String args[])  {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.right.right = new TreeNode(11);
        root.left.right.right = new TreeNode(1);

        System.out.println(new PathSumIII().pathSum(root, 8));
    }
    public int pathSum(TreeNode root, int sum) {
        if ( root == null)
            return 0;
        return pathSumFromRoot(root, sum) + pathSum(root.left , sum) + pathSum(root.right , sum);
    }

    private int pathSumFromRoot(TreeNode root, int sum) {
        if ( root == null)
            return 0;

        return (root.val == sum ? 1 : 0) + pathSumFromRoot(root.left, sum - root.val)
                + pathSumFromRoot(root.right , sum - root.val);
    }
}
