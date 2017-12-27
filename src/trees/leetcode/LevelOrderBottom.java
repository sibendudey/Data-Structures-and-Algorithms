package trees.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class LevelOrderBottom {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelsData = new ArrayList<>();

        if ( root == null)
            return levelsData;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> currRowData = new ArrayList<>();

            int size = currRowData.size();

            for ( int i = 0 ; i < size ; i++)   {
                TreeNode curr = queue.remove();
                currRowData.add(curr.val);
                if ( curr.left != null) queue.add(curr.left);
                if ( curr.right != null) queue.add(curr.right);
            }
            levelsData.add(0 , currRowData);
        }

        return levelsData;
    }

}
