import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PreorderIterative {

    /*
    10.8
    */

    public static List<Integer> BSTPreOrder(BinaryTree<Integer> tree) {

        Stack<BinaryTree<Integer>> callStack = new Stack<>();
        callStack.add(tree);
        List<Integer> pot = new ArrayList<>();
        while (!callStack.isEmpty()) {
            BinaryTree<Integer> curr = callStack.pop();
            if (curr != null) {
                pot.add(curr.data);
                callStack.add(curr.right);
                callStack.add(curr.left);
            }
        }
        return pot;
    }
}
