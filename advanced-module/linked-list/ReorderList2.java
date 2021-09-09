public class ReorderList2 {
    ListNode head;

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ReorderList2 insert(ReorderList2 list, int data) {
        ListNode new_node = new ListNode(data);
        if (list.head == null) {
            list.head = new_node;
        } else {
            ListNode last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }

    public static void print(ListNode A) {
        ListNode last = A;
        while (last != null) {
            System.out.println("el: " + last.val);
            last = last.next;
        }
    }

    public static ListNode reorderList(ListNode A) {
        ListNode midPointer;
        // Split into 2 linked list
        // Then join them
        int count = 0;
        ListNode last = A;
        while (last != null) {
            last = last.next;
            count++;
        }
        if (count == 1 || count == 2) {
            return A;
        }
        int mid = count / 2;

        int i = 0;
        last = A;
        while (i < mid) {
            last = last.next;
            i++;
        }
        midPointer = last.next;
        last.next = null;
        midPointer = reverseLL(midPointer);

        ListNode curr = A, next = null, midPNext = null, dummyNodeFirst = null, dummyNodeSecond = null;
        while (curr != null && midPointer != null) {
            next = curr.next;
            curr.next = midPointer;
            midPNext = midPointer.next;
            midPointer.next = next;

            if (dummyNodeFirst == null) {
                dummyNodeFirst = curr;
            }
            curr = next;
            if (dummyNodeSecond == null) {
                dummyNodeSecond = midPNext;
            }
            midPointer = midPNext;
        }
        // print(dummyNodeFirst);
        return dummyNodeFirst;
    }

    public static ListNode reverseLL(ListNode A) {
        ListNode curr = A, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String args[]) {
        ReorderList2 list = new ReorderList2();
        list = insert(list, 1);
        list = insert(list, 2);
        // list = insert(list, 3);
        // list = insert(list, 4);
        // list = insert(list, 5);
        // list = insert(list, 6);
        reorderList(list.head);
    }
}
