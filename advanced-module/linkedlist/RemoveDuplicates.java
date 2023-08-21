public class RemoveDuplicates {
    public static void main(String[] args) {
        // int[] a = {1,1,2,3,3};
        int[] a = {1,1,1,2,2,2,3,3,3};
        // int[] a = {1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,11,11,11,12,12,12,13,13,
        //     13,14,14,14,15,15,15,16,16,16,17,17,17,18,18,18,19,19,19,20,20,20};
        ListNode A = new ListNode(a[0]);
        ListNode x = A;
        for (int i = 1; i < a.length; i++) {
            A.next = new ListNode(a[i]);
            A=A.next;
        }
        System.out.println(deleteDuplicates(x));
    }

    public static ListNode deleteDuplicates(ListNode A) {
        ListNode current = A;
        ListNode prev = null;
        while (current != null) {
            while (prev != null && current != null && prev.val == current.val) {
                current = current.next;
            }
            if (prev!=null) {
                prev.next = current;
            }
            prev=current;
            if (current!=null) {
                current = current.next;
            }
        }
        return A;
    }

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
