public class IsSymmetric {

    /*
    10.2
    */

    public static boolean isSymmetric(BinaryTree<Integer> tree) {
//      Need a recursive solution that compares subtrees rather than null to true in default
        return tree == null || checkSymmetric(tree.left, tree.right);
    }

    private static boolean checkSymmetric(BinaryTree<Integer> left, BinaryTree<Integer> right) {
        if (left == null && right == null) {
            return true;
        } else if (left != null && right != null) {
            return left.data.equals(right.data) &&
                    checkSymmetric(left.left, right.right) &&
                    checkSymmetric(right.left, left.right);
        }
        return false;
    }
}
