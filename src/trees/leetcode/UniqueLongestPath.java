package trees.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {

    /**
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {

       int min = root.val;

       return findSecondMinimumValueUtil(root , min);

    }

    private int findSecondMinimumValueUtil(TreeNode root, int min) {

        if ( root == null)
            return -1;

        if ( root != null && root.val != min)
            return root.val;

        int minValueLeft = findSecondMinimumValueUtil(root.left , min);

        int minValueRight = findSecondMinimumValueUtil(root.right , min);

        if ( minValueLeft == -1 || minValueRight == -1)
            return Math.max(minValueLeft, minValueRight);

        return Math.min(minValueLeft, minValueRight);
    }

    int sum = 0;

    private void inOrderTraversal(TreeNode treeNode) {
        if (treeNode == null)
            return;

        inOrderTraversal(treeNode.left);
        System.out.print(treeNode.val + " ");
        inOrderTraversal(treeNode.right);

    }

    public TreeNode convertBST(TreeNode root) {
        if ( root == null)
            return root;

        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return sortedArrayToBSTUtil(0 , nums.length - 1, nums);
    }

    private TreeNode sortedArrayToBSTUtil(int low, int high, int[] nums) {

        if ( low > high)
            return null;

        int mid = ( low + high) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBSTUtil(low, mid - 1, nums);
        root.right = sortedArrayToBSTUtil(mid + 1, high , nums);

        return root;
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {

        if ( root == null)
            return null;

        if ( root.val < L )    {
            return trimBST(root.right, L, R);
        }

        if ( root.val > R)  {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L , R);
        root.right = trimBST(root.right, L, R);
        return root;

    }

    public boolean findTarget(TreeNode root, int k) {

        List<Integer> treeNodes = new ArrayList<>();

        inOrderTraversal(root , treeNodes);

        int left = 0;
        int right = treeNodes.size() - 1;

        while ( left <= right)  {
            int currSum = treeNodes.get(left) + treeNodes.get(right);
            if ( currSum == k)
                return true;

            else if ( currSum > k)  --right;
            else left++;
        }

        return false;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> treeNodes) {

        if ( root == null)
            return;

        inOrderTraversal(root.left, treeNodes);

        treeNodes.add(root.val);

        inOrderTraversal(root.right, treeNodes);
    }

    public List<Double> averageOfLevels(TreeNode root) {


        List<Double> averages = new ArrayList<>();
        List<TreeNode> levels = new ArrayList<>();

        levels.add(root);

        double currSum = 0;
        double noOfElements = 0 ;
        while ( levels.size() > 0 )    {

            TreeNode pop = levels.get(0);
            levels.remove(pop);
            if ( pop == null) {
                double avg = currSum/noOfElements;
                averages.add(avg);
                // Reset the values
                currSum = 0;
                noOfElements = 0;
            }
            else    {
                // It means a new level is about to start
                // Add a null to put a barricade/ wall between two levels
                if ( noOfElements == 0) {
                    levels.add(null);
                }
                currSum += pop.val;
                noOfElements++;

                if ( pop.left != null)
                    levels.add(pop.left);

                if (pop.right != null)
                    levels.add(pop.right);

            }
        }

        return averages;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if ( p == null && q == null)
            return true;
        if ( p == null || q == null)
            return false;
        if ( p.val != q.val )
            return false;
        else
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public TreeNode invertTree(TreeNode root) {

        if ( root == null)
            return root;

        TreeNode temp = root.left;

        root.left = root.right;

        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static int maxDiameter = 0;


    public int diameterOfBinaryTree(TreeNode root) {

        AtomicInteger at = new AtomicInteger();
        at.set(0);
        height(root, at);
        return at.get();

    }

    private int height(TreeNode root, AtomicInteger at) {

        if ( root == null)
            return 0;
        int leftLevel = height(root.left, at);
        int rightLevel = height(root.right, at);

        int diameter = 1 + leftLevel + rightLevel;

        at.set( Math.max(diameter, at.get()));

        return Math.max(1 + leftLevel, 1 + rightLevel);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if ( root == null)
            return Collections.unmodifiableList(paths);


        binaryTreePathsUtil(root, paths, "");

        return paths;
    }

    private void binaryTreePathsUtil(TreeNode node, List<String> paths, String s) {

        if ( node.left == null && node.right == null)
            paths.add(s + String.valueOf(node.val));

        if ( node.left != null)
            binaryTreePathsUtil(node.left , paths , s + String.valueOf(node) + "->" );

        if ( node.right != null)
            binaryTreePathsUtil(node.right , paths , String.valueOf(node) + "->" );

    }

    public static void main(String args[]) {
//
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(5);
//        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(7);
//
//        System.out.println(new Solution().findSecondMinimumValue(root));
//
//        TreeNode root2 = new TreeNode(2);
//        root2.left = new TreeNode(2);
//        root2.right = new TreeNode(2);
//
//        System.out.println(new Solution().findSecondMinimumValue(root2));

        Solution solution = new Solution();
//        int[] sortedArr = new int[]{-10,-3,0,5,9};
//
//        TreeNode root = solution.sortedArrayToBST(sortedArr);
//        solution.inOrderTraversal(root);

        // Prints root
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(0);
//        root.right = new TreeNode(2);
//
//        root = solution.trimBST(root, 1, 2);
//
//        solution.inOrderTraversal(root);
//
//        System.out.println();
//        // Prints root2
//        TreeNode root2 = new TreeNode(3);
//
//        root2.left = new TreeNode(0);
//        root2.right = new TreeNode(4);
//
//        root2.left.right = new TreeNode(2);
//        root2.left.right.left = new TreeNode(1);
//
//        root2 = solution.trimBST(root2, 1, 3);
//
//        solution.inOrderTraversal(root2);

        // Average values of all levels
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//
//        System.out.println(new Solution().averageOfLevels(root));

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//
//        System.out.println(new Solution().isSameTree(root, root));
//
//        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(2);
//
//        TreeNode root3 = new TreeNode(1);
//        root3.right = new TreeNode(2);
//
//        System.out.println(new Solution().isSameTree(root2, root3));

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);


        System.out.println(new Solution().diameterOfBinaryTree(root));


    }

}
