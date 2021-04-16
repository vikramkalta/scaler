import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySum0 {
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 4, 5 };
        int[] arr = { 23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32, 16, 40, 8, 7, 5, 48, 48, 16, 9, 5,
                50, 16, 18, 9, 21, 26, 48, 37, 27, 7, 5, 29, 24, 28, 10, 44, 21, 1, 48, 15, 31, 41, 42, 23, 4, 32, 40,
                40, 27, 20, 29, 42, 25, 18, 37, 43, 13, 30, 42, 24, 17, 42, 14, 42, 43, 36, 31, 29, 24, 24, 8, 3, 12,
                34, 14, 6 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);

        System.out.println(sum0(A));
        // System.out.println(subarraySum(A, 500500));
    }

    public static int sum0(ArrayList<Integer> A) {
        int len = A.size();

        ArrayList<Long> prefix = new ArrayList<>();
        prefix.add(0l);

        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0l, -1);
        long sum = 0;
        hm.put(sum, 0);

        sum = 0;
        boolean found = false;

        for (int i = 1; i <= len; i++) {
            long curr = A.get(i-1);
            sum+=curr;
            // prefix.add(sum);
            boolean contains = hm.containsKey(sum);
            if (contains) {
                found = true;
                break;
            } else {
                hm.put(sum, i);
            }
        }

        if (found) {
            return 1;
        }else {
            return 0;
        }
    }
}
