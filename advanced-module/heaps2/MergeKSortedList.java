import java.util.ArrayList;

public class MergeKSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String args[]) {
        // int[][] a = { { 1, 5, 9 }, { 2, 3, 8 }, { 4, 7 } };
        // int[][] a = { { }, { } };
        int[][] a= {{2},{},{-1}};
        // ListNode l1 = new ListNode(a[1]);
        ArrayList<ListNode> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (a[i].length > 0) {
                ListNode head = new ListNode(a[i][0]);
                ListNode temp = head;
                for (int j = 1; j < a[i].length; j++) {
                    temp.next = new ListNode(a[i][j]);
                    temp = temp.next;
                }
                A.add(head);
            } else {
                A.add(null);
            }
        }
        System.out.println(mergeKLists(A));
    }

    public static ListNode mergeKLists(ArrayList<ListNode> a1) {
        int len = a1.size();
        ArrayList<ListNode> a = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (a1.get(i) != null) {
                a.add(a1.get(i));
            }
        }
        if (a.size() == 0) {
            return null;
        }
        for (int i = ((len - 2) / 2); i >= 0; i--) {
            if (a.get(i) != null) {
                minHeapify(a, i);
            }
        }

        ListNode ans = null;
        ListNode temp = null;

        while (true) {
            if (a.size() == 0) {
                break;
            }
            ListNode min = extractMin(a);

            if (ans == null) {
                ans = min;
                temp = ans;
            } else {
                temp.next = min;
                temp = temp.next;
            }
            min = min != null ? min.next : null;
            if (min!=null) {
                insert(a, min);
            }
        }

        return ans;
    }

    public static void minHeapify(ArrayList<ListNode> A, int root) {
        int smallest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;
        if (leftChild < A.size() && A.get(leftChild) != null && A.get(smallest) != null && A.get(leftChild).val < A.get(smallest).val) {
            smallest = leftChild;
        }
        if (rightChild < A.size() && A.get(leftChild) != null && A.get(smallest) != null && A.get(rightChild).val < A.get(smallest).val) {
            smallest = rightChild;
        }
        if (smallest != root) {
            ListNode temp = A.get(smallest);
            A.set(smallest, A.get(root));
            A.set(root, temp);
            minHeapify(A, smallest);
        }
    }

    public static ListNode extractMin(ArrayList<ListNode> A) {
        ListNode min = A.get(0);
        A.set(0, A.get(A.size() - 1));
        A.remove(A.size() - 1);
        minHeapify(A, 0);
        return min;
    }

    public static void insert(ArrayList<ListNode> A, ListNode val) {
        A.add(val);
        int i = A.size() - 1;
        while (i > 0 && A.get((i - 1) / 2).val > A.get(i).val) {
            ListNode temp = A.get(i);
            A.set(i, A.get((i - 1) / 2));
            A.set((i - 1) / 2, temp);
            i = (i - 1) / 2;
        }
    }
}
