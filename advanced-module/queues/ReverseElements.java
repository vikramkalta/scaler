import java.util.LinkedList;

public class ReverseElements {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 3;
        System.out.println(solve(A, B));
    }
    public static int[] solve(int[] A, int B) {
        int len = A.length;
        int[] ans = new int[len];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < B; i++) {
            queue.add(A[i]);
        }
        for (int i = 0; i < B; i++) {
            ans[i] = queue.removeLast();
        }
        for (int i = B; i < len; i++) {
            ans[i] = A[i];
        }
        return ans;
    }
}

