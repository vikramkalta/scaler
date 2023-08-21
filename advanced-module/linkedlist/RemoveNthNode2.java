public class RemoveNthNode2 {
    public static void main(String[] args) {
        // int[] a = new int[] {1,2,3,4,5};
        int[] a = new int[] { 1 };
        ListNode x;
        ListNode current = new ListNode(a[0]);
        x = current;
        int i = 1;
        while (i < a.length) {
            current.next = new ListNode(a[i]);
            current = current.next;
            i++;
        }
        // int B = 2;
        int B = 1;
        System.out.println(removeNthFromEnd(x, B));
    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        int len = 0;
        ListNode x = A;
        while (x != null) {
            x = x.next;
            len++;
        }
        if (len == 1 && B == 1) {
            return null;
        }
        if (len <= B) {
            A = A.next;
            return A;
        }
        x = A;
        int i = 0;
        while (x != null) {
            if (i + 1 == len - B) {
                x.next = x.next.next;
            }
            x = x.next;
            i++;
        }
        return A;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
