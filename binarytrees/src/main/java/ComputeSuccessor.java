public class ComputeSuccessor {

    /*
    10.10
    */

    public static BinaryTreeParent<Integer> findSuccessor(BinaryTreeParent<Integer> node) {
        BinaryTreeParent<Integer> iter = node;
        if (iter.right != null) {
            iter = iter.right;
            while (iter.left != null) {
                iter = iter.left;
            }
            return iter;
        }
        // Find closest ancestor whose left subtree contains node
        while (iter.parent != null && iter.parent.right == iter) {
            iter = iter.parent;
        }
        // Rightmost node, so no successor
        return iter.parent;
// Functional
//        if (node.right != null) {
//            node = node.right;
//            while (node.left != null) {
//                node = node.left;
//            }
//            return node;
//        }
//        if (node.parent != null) {
//            BinaryTreeParent<Integer> temp_node = node.parent;
//            while (temp_node.left != node && node.parent != null) {
//                temp_node = node.parent;
//                node = temp_node;
//            }
//            return temp_node;
//        }
//        return null;
    }
}
