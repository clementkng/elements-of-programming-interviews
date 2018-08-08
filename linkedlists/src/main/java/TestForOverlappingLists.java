public class TestForOverlappingLists {

    /*
    8.4
    */

    public static ListNode<Integer> doListsOverlap(ListNode<Integer> list1, ListNode<Integer> list2) {
        if (list1 == null || list2 == null) {
            return null;
        }
        int l1 = list1.length();
        int l2 = list2.length();
        // Even up lengths so both will encounter the intersection node (if any) the same time
        if (l1 > l2) {
            for (int i = 0; i < l1 - l2; i++) {
                list1 = list1.next;
            }
        } else {
            for (int i = 0; i < l2 - l1; i++) {
                list2 = list2.next;
            }
        }
        while (list1 != null && list2 != null && list1 != list2) {
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1; // Either no overlap, or list1 = list2


//        ListNode<Integer> listtemp = list1;
//        while (listtemp != null) {
//            ListNode<Integer> listtemp2 = list2;
//            while (listtemp2 != null) {
//                if (listtemp2 == listtemp) {
//                    return listtemp;
//                }
//                listtemp2 = listtemp2.next;
//            }
//            listtemp = listtemp.next;
//        }
//        return null;
    }
}
