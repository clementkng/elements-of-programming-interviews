public class ComputeKthNodeInorder {

    /*
    10.9
    */

    public static BinaryTree<Integer> findKthNodeBinaryTree(BinaryTree<Integer> tree, int k) {
        // divide + conquer, given each node stores number of nodes rooted in subtree of that node (as data)
        // Base case: just a root, return root
//        return findKthNodeBinaryTreeHelper(tree, 0, tree.data - 1, k);
        BinaryTree<Integer> iter = tree;
        while (iter != null) {
            // Get the size of left subtree (no need for right b/c can be established merely from left)
            int leftSize = iter.left != null ? iter.left.data : 0;
            if (k == leftSize) { // k is the current element
                return iter;
            } else if (leftSize < k) { // k is in right b/c too large
                k -= (leftSize + 1);
                iter = iter.right;
            } else { // k is in left subtree
                iter = iter.left;
            }
        }
        return null;
    }
}

//    private static BinaryTree<Integer> findKthNodeBinaryTreeHelper(BinaryTree<Integer> tree, int start, int end, int k) {
//        while (start <= k && k <= end && tree != null) {
//            if (start == end) {
//                return tree;
//            }
//            if (tree.left != null) {
//                if (k == start + tree.left.data) {
//                    return tree;
//                } else if (k <= start + tree.left.data - 1) {
//                    tree = tree.left;
//                    end = start + tree.data - 1;
//                }
//            }
//            if (tree.right != null) {
//                if (k == end - tree.right.data) {
//                    return tree;
//                } else if (k == end - tree.right.data + 1) {
//                    tree = tree.right;
//                    start = end - tree.right.data + 1;
//                }
//            }
//        }
//        return null;
//
//    }
//}
