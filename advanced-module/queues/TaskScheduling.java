import java.util.LinkedList;

public class TaskScheduling {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5, 4};
        int[] B = {1, 3, 5, 4, 2};
        System.out.println(solve(A, B));
    }
    public static int solve(int[] A, int[] B) {
        int ans = 0;
        int lenA = A.length;
        int lenB = B.length;

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < lenA; i++) {
            queue.add(A[i]);
        }
        for (int i = 0; i < lenB; i++) {
            int curr = B[i];
            while (!queue.isEmpty() && queue.peek() != curr) {
                int y = queue.remove();
                queue.add(y);
                ans++;
            }
            queue.remove();
            ans++;
        }
        return ans;
    }
}
