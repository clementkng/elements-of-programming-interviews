public class FindRootToLeafSum {

    /*
    10.6
    */

    public static boolean hasPathSum(BinaryTree<Integer> tree, int targetSum) {
        return hasPathSumHelper(tree, targetSum);
    }
    private static boolean hasPathSumHelper(BinaryTree<Integer> tree, int targetSum) {
        if (tree == null) {
            return false;
        }
        targetSum -= tree.data;
        if (tree.left == null && tree.right == null) {
            return targetSum == 0;
        }
        return hasPathSumHelper(tree.left, targetSum) || hasPathSumHelper(tree.right, targetSum);
    }

}
