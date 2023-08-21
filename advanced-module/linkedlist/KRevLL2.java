import java.util.ArrayList;

public class KRevLL2 {
    public static void main(String[] args) {
        // int[] a = {1, 2, 3, 4, 5, 6};
        int[] a = {1,2,3,4,5};
        ListNode x;
        ListNode A = new ListNode(a[0]);
        int i = 1;
        x = A;
        while (i < a.length) {
            A.next = new ListNode(a[i]);
            A = A.next;
            i++;
        }
        // System.out.println(x);
        System.out.println(reverseList(x, 2));
    }
    // 1->2->3->4->5->6
    // 2->1->3->4->5->6
    // 2->3->1->4->5->6
    // 
    public static ListNode reverseList(ListNode A, int B) {
        ArrayList<ListNode> list = new ArrayList<>();
        int i = 0;
        ListNode current = A;
        while (A != null) {
            if ((i+1) % B == 0) {
                ListNode next = A.next;
                A.next = null;
                list.add(current);
                A = next;
                current = A;
            } else {
                if (A.next==null) {
                    list.add(current);
                }
                A = A.next;
            }
            i++;
        }
        int totalLen = i;
        int len = list.size();
        for (i = 0; i < list.size(); i++) {
            ListNode curr = list.get(i);
            // Note this one is modified for leetcode
            if (i != len - 1) {
                ListNode reversed = reverseSingleList(curr);
                list.set(i, reversed);
            }
            if (i == len-1 && totalLen%B==0){
                ListNode reversed = reverseSingleList(curr);
                list.set(i, reversed);
            }
        }
        ListNode prev = null;
        for (i = len-1; i >= 0; i--) {
            ListNode curr = list.get(i);
            if (prev == null) {
                prev = curr;
            } else {
                ListNode temp = curr;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = prev;
                prev = temp;
            }
        }
        return prev;
    }
    public static ListNode reverseSingleList(ListNode A) {
        ListNode prev = null;
        ListNode next = null;
        ListNode current = A;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}