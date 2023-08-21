import java.util.ArrayList;

public class ReorderList3 {
    public static void main(String[] args) {
        // int[] a = { 1, 2, 3, 4, 5, 6 };
        // int[] a = { 1 };
        int[] a = {90,94,25,51,45,29,55,63,48,27,72,10,36,68,16,20,31,7,95,70,89,23,22,9,74,71,35,5,80,11,49,92,69,6,37,84,78,28,43,64,96,57,
            83,13,73,97,75,59,53,52,19,18,98,12,81,24,15,60,79,34,1,54,93,65,44,4,87,14,67,26,30,77,58,85,33,21,46,82,76,88,66,101,61,47,8};
        ListNode A = new ListNode(a[0]);
        ListNode prev = A;
        for (int i = 1; i < a.length; i++) {
            ListNode curr = new ListNode(a[i]);
            A.next = curr;
            A = curr;
        }
        System.out.println(reorderList(prev));
    }

    public static ListNode reorderList(ListNode A) {
        int len = 0;
        ListNode x = A;
        while (x != null) {
            x = x.next;
            len++;
        }
        if (len<=2) {
            return A;
        }
        int mid = len/2;
        x=A;
        int i =0;
        ListNode rightList=null;
        while (true) {
            if (i==mid-1){
                rightList = x.next;
                x.next = null;
                break;
            }
            x=x.next;
            i++;
        }
        rightList = reverseList(rightList);
        ListNode leftList = A;

        ArrayList<ListNode> list = new ArrayList<>();
        while (leftList!=null) {
            ListNode tempLeft = leftList.next;
            ListNode tempRight = rightList.next;
            leftList.next = null;
            rightList.next = null;
            leftList.next = rightList;
            list.add(leftList);
            rightList = tempRight;
            leftList = tempLeft;
        }
        if (rightList!=null) {
            list.add(rightList);
        }
        int lenList = list.size();
        ListNode prev = null;
        for (i = lenList-1; i >= 0; i--) {
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

    public static ListNode reverseList(ListNode A) {
        ListNode current = A;
        ListNode prev = null;
        ListNode next = null;
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

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}