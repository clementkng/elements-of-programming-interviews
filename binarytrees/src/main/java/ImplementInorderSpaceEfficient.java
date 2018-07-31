import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImplementInorderSpaceEfficient {

    /*
    10.11
    */

    public static List<Integer> inorderTraversal(BinaryTreeParent<Integer> tree) {
        BinaryTreeParent<Integer> prev = null, curr = tree;
        List<Integer> ioT = new ArrayList<>();
        while (curr != null) {
            BinaryTreeParent<Integer> next;
            if (curr.parent == prev) {
                if (curr.left != null) {
                    next = curr.left;
                } else {
                    ioT.add(curr.data);
                    next = (curr.right != null) ? curr.right : curr.parent;
                }
            } else if (curr.left == prev) {
                ioT.add(curr.data);
                next = (curr.right != null) ? curr.right : curr.parent;
            } else {
                next = curr.parent;
            }
            prev = curr;
            curr = next;
        }
        return ioT;

        // Functional
//        List<Integer> ioT = new ArrayList<>();
//        while (tree.left != null) {
//            tree = tree.left;
//        }
//        while (tree != null) {
//            ioT.add(tree.data);
//            tree = ComputeSuccessor(tree);
//        }
    }
}
