import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySum0 {
    public static void main(String args[]) {
        // int[] arr = { 100, 4, 100, 1, 3, 2, -2 };
        int[] arr = { 5, 17, -22, 11 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put(0l, 1);
        long sum = 0l;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            long c = 1l * curr;
            sum += c;
            if (hm.containsKey(sum)) {
                ans = 1;
                break;
            } else {
                hm.put(sum, 1);
            }
        }
        return ans;
    }
}
