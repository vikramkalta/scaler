import java.util.ArrayList;

public class AnotherCountRectangles {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 5 };
        // int[] arr = { 5, 10, 20, 100, 105 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        // System.out.println(solve(A, 10));
        System.out.println(solve(A, 5));
        // System.out.println(solve(A, 110));
    }

    public static int solve(ArrayList<Integer> A, int B) {
        long mod = 1000000007l;
        int len = A.size();
        int start = 0, end = len - 1;
        long count = 0l;

        while (start <= end) {
            long currStart = A.get(start);
            long currEnd = A.get(end);
            long p = 1l * (currStart * currEnd);

            if (p >= B) {
                end--;
            } else {
                long diff = 1l * (end - start + 1);
                diff = 1l * (diff * 2l);
                diff = diff % mod;

                long totalCount = 1l * (diff - 1l);
                count = 1l * (count + totalCount);

                start++;
            }
        }
        count = count % mod;
        if (count < 0)
            count += mod;
        return (int) count;
    }
}
