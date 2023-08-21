public class ReverseLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        ListNode x = new ListNode(a[0]);
        ListNode A = x;
        int i = 1;
        while(i < a.length) {
            A.next = new ListNode(a[i]);
            A = A.next;
            i++;
        }
        System.out.println(reverseList(x, i));
    }

    public static ListNode reverseList(ListNode A, int B) {
        ListNode current = A;
        ListNode next = null;
        ListNode prev = null;
        while (current!=null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static ListNode reverseList1(ListNode A, int B) {
        ListNode reversed = new ListNode(-1);
        ListNode prev = null;
        while (A != null) {
            if (prev != null) {
                reversed = new ListNode(A.val);
                reversed.next = prev;
            }
            if (reversed.val != -1) {
                prev = reversed;
            } else {
                prev = new ListNode(A.val);
            }
            A = A.next;
        }
        return reversed;
    }
}