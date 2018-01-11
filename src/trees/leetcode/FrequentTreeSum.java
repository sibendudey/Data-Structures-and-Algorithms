package trees.leetcode;

import java.util.*;

public class FrequentTreeSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        findFrequentTreeSumUtil(root, sumCount);

        int maxFrequency = sumCount.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .findFirst().orElseGet(() -> new Map.Entry<Integer, Integer>() {
                    @Override
                    public Integer getKey() {
                        return null;
                    }

                    @Override
                    public Integer getValue() {
                        return 0;
                    }

                    @Override
                    public Integer setValue(Integer value) {
                        return null;
                    }
                }).getValue();

        List<Integer> sums = sumCount.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .collect(() -> new ArrayList<>(),
                        (al, entry) -> al.add(entry.getKey())
                        ,(al1,al2) -> al1.addAll(al2));

        int sumArray[] = new int[sums.size()];

        for ( int i = 0  ; i < sums.size() ; i++)
            sumArray[i] = sums.get(i);

        return sumArray;


    }

    private int findFrequentTreeSumUtil(TreeNode root, Map<Integer, Integer> sumCount) {
        if ( root == null)
            return 0;

        int leftSum = findFrequentTreeSumUtil(root.left, sumCount);

        int rightSum = findFrequentTreeSumUtil(root.right, sumCount);

        int sum = root.val + leftSum + rightSum;

        sumCount.putIfAbsent(sum, 0);
        sumCount.put(sum, sumCount.get(sum) + 1 );

        return sum;
    }

    public static void main(String args[])  {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Arrays.stream(new FrequentTreeSum().findFrequentTreeSum(root))
                .forEach( sum -> System.out.println(sum));
    }

}
