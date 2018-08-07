public class TestCyclicity {

    /*
    8.3
    */

    public static ListNode<Integer> isCyclic(ListNode<Integer> list) {
//        ListNode<Integer> slow = list;
//        ListNode<Integer> fast = list;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) {
//                int cycleLen = 0;
//                do {
//                    ++cycleLen;
//                    fast = fast.next;
//                } while (slow != fast);
//                ListNode<Integer> cycleLenAdvancedIter = list;
//                while (cycleLen-- > 0) {
//                    cycleLenAdvancedIter = cycleLenAdvancedIter.next;
//                }
//                ListNode<Integer> iter = list;
//                while (iter != cycleLenAdvancedIter) {
//                    iter = iter.next;
//                    cycleLenAdvancedIter = cycleLenAdvancedIter.next;
//                }
//                return iter;
//            }
//        }
//        return null;
//    }
        ListNode<Integer> slow = list;
        ListNode<Integer> fast = list;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = list;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

}
