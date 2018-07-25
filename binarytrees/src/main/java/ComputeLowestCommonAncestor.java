public class ComputeLowestCommonAncestor {

    /*
    10.3
    */

    public static BinaryTree<Integer> LCA(BinaryTree<Integer> tree, BinaryTree<Integer> node0, BinaryTree<Integer> node1) {
        return LCAHelper(tree, node0, node1).ancestor;
    }

    private static Status LCAHelper(BinaryTree<Integer> tree,
                                    BinaryTree<Integer> node0,
                                    BinaryTree<Integer> node1) {
        if (tree == null) {
            return new Status(0, null);
        }
        Status leftResult = LCAHelper(tree.left, node0, node1);
        if (leftResult.numTargetNodes == 2) {
            return leftResult;
        }
        Status rightResult = LCAHelper(tree.right, node0, node1);
        if (rightResult.numTargetNodes == 2) {
            return rightResult;
        }
        int numTargetNodes = leftResult.numTargetNodes + rightResult.numTargetNodes + (tree == node0 ? 1 : 0) + (tree == node1 ? 1 : 0);
        return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);
    }

//    private static BinaryTree<Integer> underLeftorRight(BinaryTree<Integer> tree, BinaryTree<Integer> target) {
//        if (tree.data.equals(target.data)) {
//            return tree;
//        }
//        if (findChild(tree.left, target)) {
//            underLeftorRight(tree.left, target);
//        } else {
//            underLeftorRight(tree.right, target);
//        }
//    }
//
//    private static boolean findChild(BinaryTree<Integer> tree, BinaryTree<Integer> target) {
//        if (tree == null) {
//            return false;
//        }
//        if (tree.data.equals(target.data)) {
//            return true;
//        }
//        return findChild(tree.left, target) && findChild(tree.right, target);
//    }
//
//    private static void generatePath(BinaryTree<Integer> tree, BinaryTree<Integer> target, List<BinaryTree<Integer>> path, int pathLen) {
//        if (tree == null) {
//            return;
//        }
//        pathLen++;
//        path.add(tree);
//        if (tree.data.equals(target.data)) {
//            return;
//        } else {
//            generatePath(tree.left, target, path, pathLen);
//            generatePath(tree.right, target, path, pathLen);
//        }
//    }
}

class Status {
    public int numTargetNodes;
    public BinaryTree<Integer> ancestor;

    public Status(int numberTargetNodes, BinaryTree<Integer> node) {
        this.numTargetNodes = numberTargetNodes;
        this.ancestor = node;
    }
}
