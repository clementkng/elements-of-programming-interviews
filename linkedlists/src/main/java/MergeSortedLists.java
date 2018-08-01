public class MergeSortedLists {

    /*
    8.1
    */

    public static ListNode<Integer> mergeLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        // Use dummy node as head, still O(1) b/c reusing node space
        ListNode<Integer> dummyHead = new ListNode<>(0, null);
        ListNode<Integer> current = dummyHead;
        ListNode<Integer> node1 = list1, node2 = list2;
        while (node1 != null && node2 != null) {
            if (node1.data <= node2.data) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        current.next = (node1 != null) ? node1 : node2;
        return dummyHead.next;
    }
}
