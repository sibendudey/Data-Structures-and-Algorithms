package trees.leetcode;

public class BTTreeString {
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(new BTTreeString().tree2str(root));
    }

    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        tree2Str(t, sb);
        int startIndex = -1;
        while ( (startIndex = sb.indexOf("())")) != -1) {
            sb.replace(startIndex, startIndex + 2 , "");
        }
        return sb.toString();
    }

    private void tree2Str(TreeNode t, StringBuilder sb) {
        if ( t == null)
            return;

        if ( t.left == null && t.right == null) {
            sb.append(t.val);
            return;
        }


        sb.append(t.val + "(");

        tree2Str(t.left, sb);
        sb.append(")");
        sb.append("(");
        tree2Str(t.right, sb);

        sb.append(")");

    }

}
