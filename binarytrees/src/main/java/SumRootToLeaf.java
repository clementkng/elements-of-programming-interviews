public class SumRootToLeaf {

    /*
    10.5
    */

    public static int sumRootToLeaf(BinaryTree<Integer> tree) {
        return sumRootToLeafHelper(tree, 0);
    }
    private static int sumRootToLeafHelper(BinaryTree<Integer> tree, int partialSum) {
        if (tree == null) {
            return 0;
        }
        partialSum = 2 * partialSum + tree.data;
        if (tree.left == null && tree.right == null) {
            return partialSum;
        }
        return sumRootToLeafHelper(tree.left, partialSum) + sumRootToLeafHelper(tree.right, partialSum);
    }
}
