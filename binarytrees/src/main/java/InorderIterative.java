import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InorderIterative {

    /*
    10.7
    */

    public static List<Integer> BSTInOrder(BinaryTree<Integer> tree) {
        // Recursive
//        if (tree != null) {
//            BSTInOrder(tree.left);
//            int data = tree.data;
//            BSTInOrder(tree.right);
//        }
        // Add left then pop and process current, then process right after pop
        if (tree == null) {
            return Collections.emptyList();
        }
        Stack<BinaryTree<Integer>> callStack = new Stack<>();
        BinaryTree<Integer> curr = tree;
        List<Integer> iot = new ArrayList<>();
        while (!callStack.isEmpty() || curr != null) {
            if (curr != null) {
                // Move left and store until can't
                callStack.add(curr);
                curr = curr.left;
            } else {
                // Pop off stack, then add current, and move right (if necessary)
                curr = callStack.pop();
                iot.add(curr.data);
                curr = curr.right;
            }
        }
        return iot;
    }
}
