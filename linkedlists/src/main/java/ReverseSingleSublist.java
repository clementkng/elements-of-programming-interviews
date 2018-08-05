public class ReverseSingleSublist {

    /*
    8.2
    */

    public static ListNode<Integer> reverseSublist(ListNode<Integer> input, int s, int f) {
        if (s == f) {
            return input;
        }
        ListNode<Integer> dummyHead = new ListNode<>(0, input);
        ListNode<Integer> subListHead = dummyHead;
        int k = 1;
        while (k++ < s) {
            subListHead = subListHead.next;
        }
        ListNode<Integer> subListIter = subListHead.next;
        while (s++ < f) {
            ListNode<Integer> temp = subListIter.next;
            subListIter.next = temp.next;
            temp.next = subListHead.next;
            subListHead.next = temp;
        }
        return dummyHead.next;
    }
}
