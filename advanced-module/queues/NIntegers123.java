import java.util.LinkedList;

public class NIntegers123 {
    public static void main(String[] args) {
        // int A = 29500;
        int A = 7;
        System.out.println(solve(A));
    }

    public static int[] solve(int A) {
        int[] ans = new int[A];
        LinkedList<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        for (int i = 0; i < A; i++) {
            String x = queue.remove();
            ans[i] = Integer.parseInt(x);
            queue.add(x + "1");
            queue.add(x + "2");
            queue.add(x + "3");
        }
        return ans;
    }
}