import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        // int[] A = { 1, 3, -1, -3, 5, 3, 6, 7 };
        // int B = 3;
        // int[] A = { 1, 2, 3, 4, 2, 7, 1, 6, 5 };
        // int[] A = { 2, 3, 7, 1, 6, 5 };
        // int[] A = {6,1,2,3,5,3,4,1};
        int[] A = {10,9,8,7,6,5,4,3,2,1};
        // 10,9,8,7,6,5,4,3,2,1
        // int B = 2;
        // int[]A={1};
        int B = 1;
        System.out.println(slidingMaximum(A, B));
    }

    public static int[] slidingMaximum(final int[] A, int B) {
        int len = A.length;
        if (len==1) {
            return new int[] {A[0]};
        }
        if (B==1) {
            return A;
        }
        int[] ans = new int[len - B + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            int curr = A[i];
            if (i>=B-1) {
                int top = queue.peek();
                if (i - top >= B) {
                    queue.removeFirst();   
                }
            }
            
            if (queue.isEmpty()) {
                queue.addFirst(i);
            } else {
                while (!queue.isEmpty() && A[queue.getLast()] < curr) {
                    queue.removeLast();
                }
                queue.addLast(i);
            }
            if (i>=B-1) {
                ans[i-B+1] = A[queue.peek()];
            }
        }
        return ans;
    }

    public static int[] slidingMaximum1(final int[] A, int B) {
        LinkedList<Integer> queue = new LinkedList<>();
        int len = A.length;
        int[] ans = new int[len - B + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A[i];
            if (queue.size() == B) {
                ans[i - B] = max;
                if (queue.peek() == max) {
                    int j = 1;
                    max = Integer.MIN_VALUE;
                    while (j < B) {
                        if (queue.get(j) > max) {
                            max = queue.get(j);
                        }
                        j++;
                    }
                }
                queue.pop();
            }
            if (max < curr) {
                max = curr;
            }
            queue.add(curr);
        }
        int j = 0;
        while (j < B) {
            if (queue.get(j) > max) {
                max = queue.get(j);
            }
            ans[len - B] = max;
            j++;
        }
        return ans;
    }
}