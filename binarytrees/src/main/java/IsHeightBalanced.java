public class IsHeightBalanced {

    /*
    10.1
    */


    public static boolean isBalanced(BinaryTree<Integer> tree) {
        return checkBalanced(tree).balanced;
    }
    private static BalanceStatusWithHeight checkBalanced(BinaryTree<Integer> tree) {
        if (tree == null) {
            return new BalanceStatusWithHeight(true, -1);
        }
        BalanceStatusWithHeight leftResult = checkBalanced(tree.left);
        if (!leftResult.balanced) {
            return leftResult;
        }
        BalanceStatusWithHeight rightResult = checkBalanced(tree.right);
        if (!rightResult.balanced) {
            return rightResult;
        }
        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        return new BalanceStatusWithHeight(isBalanced, height);
    }


}

class BalanceStatusWithHeight {
    public boolean balanced;
    public int height;

    public BalanceStatusWithHeight(boolean balanced, int height) {
        this.balanced = balanced;
        this.height = height;
    }
}
