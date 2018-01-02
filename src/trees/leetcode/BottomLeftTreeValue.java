package trees.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BottomLeftTreeValue {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new BottomLeftTreeValue().findBottomLeftValue(root));

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.right.right = new TreeNode(6);
        root2.right.left = new TreeNode(5);
        root2.right.left.left = new TreeNode(7);

        System.out.println(new BottomLeftTreeValue().findBottomLeftValue(root2));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        int left = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode top = queue.remove(0);

                if (i == 0)
                    left = top.val;

                if (top.left != null)
                    queue.add(top.left);

                if (top.right != null)
                    queue.add(top.right);
            }
        }

        return left;
    }

}
