public class FindOverlappingWithCycles {

    /*
    8.5
    */

    public static ListNode<Integer> testOverlappingWithCycles(ListNode<Integer> list1, ListNode<Integer> list2) {
        ListNode<Integer> headl1 = list1;
        ListNode<Integer> headl2 = list2;
        ListNode<Integer> cyclel1 = TestCyclicity.isCyclic(headl1);
        ListNode<Integer> cyclel2 = TestCyclicity.isCyclic(headl2);
        if ((cyclel1 == null && cyclel2 != null) || (cyclel2 == null && cyclel1 != null)) {
            return null;
        }
        if (cyclel1 == null && cyclel2 == null) {
            return TestForOverlappingLists.doListsOverlap(list1, list2);
        }
        // If both lists end in a common cycle
        System.out.println("Both");
        ListNode<Integer> listtemp = cyclel2;
        do {
            listtemp = listtemp.next;
        } while (listtemp != cyclel1 && listtemp != cyclel2);
        if (listtemp != cyclel1) {
            return null;
        }
        int stem1length = distance(list1, cyclel1);
        int stem2length = distance(list2, cyclel2);
        if (stem1length > stem2length) {
            int k = stem1length - stem2length;
            while (k-- > 0) {
                list1 = list1.next;
            }
        } else {
            int k = stem2length - stem1length;
            while (k-- > 0) {
                list2 = list2.next;
            }
        }
        while (list1 != list2 && list1 != cyclel1 && list2 != cyclel2) {
            list1 = list1.next;
            list2 = list2.next;
        }
        return list1 == list2 ? list1 : cyclel1;
    }
    private static int distance(ListNode<Integer> a, ListNode<Integer> b) {
        int dis = 0;
        while (a != b) {
            a = a.next;
            ++dis;
        }
        return dis;
    }
}
