public class SwapListNodes {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4 };
        ListNode A = new ListNode(a[0]);
        ListNode x = A;
        for (int i = 1; i < a.length; i++) {
            A.next = new ListNode(a[i]);
            A = A.next;
        }
        System.out.println(swapPairs(x));
    }

    public static ListNode swapPairs(ListNode A) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = A;
        ListNode curr = dummyNode;
        while(curr.next != null && curr.next.next != null) {
            curr.next = swap(curr.next, curr.next.next);
            curr = curr.next.next;
        }
        return dummyNode.next;
    }
    public static ListNode swap(ListNode next1, ListNode next2) {
        next1.next = next2.next;
        next2.next = next1;
        return next2;
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}