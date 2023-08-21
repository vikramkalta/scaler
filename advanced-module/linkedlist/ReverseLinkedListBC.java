import java.util.ArrayList;

public class ReverseLinkedListBC {
    public static void main(String[] args) {
        // int[] a = {1,2,3,4,5};
        // int[] a = {1};
        int[] a = {1,2,3};
        // int[] a = {1,2,3};
        // int[] a = {1,2,3,4,5,6,7};
        // int[]a={83,13,21,72};
        // int[]a={81,86,96,66,63,76,51,28,32,36,59,19,54,93,50,37,90,46,91,2,83,55,84,34,100,79,33,18,68,75,44,10,88,64,43,70,39,8,3,29,22,74,38};
        ListNode A = new ListNode(a[0]);
        ListNode x = A;
        for (int i = 1; i < a.length; i++) {
            A.next = new ListNode(a[i]);
            A=A.next;
        }
        // System.out.println(reverseBetween(x, 2, 4));
        // System.out.println(reverseBetween(x, 1, 1));
        // System.out.println(reverseBetween(x, 2, 3));
        System.out.println(reverseBetween(x, 1, 2));
        // System.out.println(reverseBetween(x, 1, 5));
        // System.out.println(reverseBetween(x, 1, 4));
        // System.out.println(reverseBetween(x, 11, 11));
    }

    public static ListNode reverseBetween(ListNode A, int B, int C) {
        if (B==C) {
            return A;
        }
        int i = 0;
        ListNode temp = A;
        ArrayList<ListNode> list = new ArrayList<>();
        while (A!=null) {
            i++;
            if ((i == B-1) || (B!=1 && i==C-1) || (B==1 && i==C)) {
                ListNode x = A.next;
                A.next = null;
                list.add(temp);
                temp = A = x;
            }
            if (A != null){
                A=A.next;
            }
        }
        // if (list.size()==1){
        //     return reverseList(list.get(0));
        // }
        ListNode prev = null;
        
        if (temp!=null) {
            list.add(temp);
            if (B==1) {
                ListNode curr = list.get(0);
                curr = reverseList(curr);
                ListNode temp1 = curr;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = list.get(1);
                return temp1;
            }
            prev = list.get(2);
        }
        if (list.size()==1){
            return reverseList(list.get(0));
        }

        list.set(1, reverseList(list.get(1)));
        for (i = 1; i >= 0; i--) {
            ListNode curr = list.get(i);
            ListNode temp1 = curr;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = prev;
            prev = temp1;
        }
        return prev;
    }

    public static ListNode reverseList(ListNode A) {
        ListNode current = A;
        ListNode prev = null;
        ListNode next = null;
        while (current!=null) {
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
