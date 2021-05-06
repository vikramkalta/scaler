import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaximumDiff {
    public static void main(String args[]) {
        // int[] arr = {1, 2, 3, 4, 5};
        // int[] arr = {5, 17, 100, 11};
        // int[] arr={48, 63};
        int[] arr = {70, 21, 7, 64, 44, 79, 50, 89, 68, 23, 20, 50, 65, 64, 48, 3, 46, 87};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // System.out.println(maxDiff(A, 2));
        // System.out.println(maxDiff(A, 3));
        // System.out.println(maxDiff(A, 1));
        System.out.println(maxDiff(A, 16));
    }

    public static int maxDiff(ArrayList<Integer> A, int B) {
        int len = A.size();
        // HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            sum += curr;
        }

        Collections.sort(A);

        int bSum = 0;
        int max = 0;
        int ans = 0;
        for (int i = 0; i < B; i++) {
            int curr = A.get(i);
            bSum += curr;
        }
        ans = sum - bSum - bSum;
        ans = ans < 0 ? -ans : ans;
        max = ans;
        bSum = 0;

        for (int i = len - 1; i >= len - B; i--) {
            int curr = A.get(i);
            bSum += curr;
        }
        ans = sum - bSum - bSum;
        ans = ans < 0 ? -ans : ans;
        
        if (max < ans) {
            max = ans;
        }
        return max;
    }
}
