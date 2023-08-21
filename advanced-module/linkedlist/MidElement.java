public class MidElement {
    public static void main(String[] args) {
        // int[]a={1,2,3,4,5};
        int[]a={1,2,3,4,5,6};
        // int[]a={14,42,98,26,36,28,57,93};
        ListNode A = new ListNode(a[0]);
        ListNode x=A;
        for (int i = 1; i < a.length; i++) {
            A.next = new ListNode(a[i]);
            A=A.next;
        }
        System.out.println(middleNode(x));
    }
    public static ListNode middleNode(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while ( fast.next != null ) {
            slow = slow.next;
            if (fast.next.next == null) {
                fast = fast.next;
            } else {
                fast = fast.next.next;
            }
        }
        return slow;
    }
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
