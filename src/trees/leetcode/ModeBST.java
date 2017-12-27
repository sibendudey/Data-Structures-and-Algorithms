package trees.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class ModeBST {
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
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        Arrays.stream(new ModeBST().findMode(root))
                .forEach( elem -> System.out.println(elem + " "));
        System.out.println();
    }

    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();

        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger pre = new AtomicInteger(Integer.MIN_VALUE);
        AtomicInteger count = new AtomicInteger(0);
        int modeFrequency = findModeFrequency(root, max, pre, count);

        pre.set(Integer.MIN_VALUE);
        count.set(0);
        findModeWithMaxFrequency(root, pre, count, modeFrequency, modes);

        int[] x = new int[modes.size()];

        for ( int i = 0 ; i < modes.size() ; i++)
            x[i] = modes.get(i);

        return x;
    }

    private void findModeWithMaxFrequency(TreeNode root, AtomicInteger pre, AtomicInteger count, int modeFrequency, List<Integer> modes) {
        if ( root == null)
            return;


        int preValue = pre.intValue();
        int countValue = count.intValue();

        if ( preValue < root.val)   {

            preValue = root.val;
            countValue = 1;

        }
        else    {
            countValue++;

            if ( countValue == modeFrequency)
                modes.add(preValue);

        }

        pre.set(preValue);
        count.set(countValue);

        findModeWithMaxFrequency(root.left, pre, count, modeFrequency, modes);
        findModeWithMaxFrequency(root.right, pre, count, modeFrequency, modes);
    }

    private int findModeFrequency(TreeNode root, AtomicInteger max, AtomicInteger pre, AtomicInteger count) {
        if ( root == null)
            return 0 ;

        int maxValue = max.intValue();
        int preValue = pre.intValue();
        int countValue = count.intValue();

        if ( preValue < root.val)   {
            preValue = root.val;
            countValue = 1;
            maxValue = Math.max(maxValue , countValue);
        }
        else    {
            countValue++;
            maxValue = Math.max(maxValue, countValue);
        }

        pre.set(preValue);
        max.set(maxValue);
        count.set(countValue);

        findModeFrequency(root.left, max, pre, count);
        findModeFrequency(root.right, max, pre, count);

        return max.get();
    }


}
