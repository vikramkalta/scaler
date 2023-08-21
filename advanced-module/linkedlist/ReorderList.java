public class ReorderList {
    ListNode head;

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {val=x;next=null;}
    }

    public static ReorderList insert(ReorderList list, int data) {
        ListNode new_node = new ListNode(data);
        new_node.next = null;
        if (list.head==null){
            list.head=new_node;
        }else{
            ListNode last = list.head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=new_node;
        }
        return list;
    }

    public static void printLL(ReorderList list){
        ListNode last=list.head;
        while(last != null){
            System.out.println("El: " + last.val);
            last = last.next;
        }
    }
    public static ListNode reorderList(ListNode A) {
        ListNode last = A;
        int count = 0;
        while(last != null) {
            System.out.println("A: " + last.val);
            last = last.next;
            count++;
        }
        System.out.println("count: " + count);
        return last;
    }
    
    public static void main(String args[]) {
        ReorderList list = new ReorderList();
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        
        // printLL(list);
        reorderList(list.head);
    }
}
