package sorting;
import java.util.ArrayList;
import java.util.Collections;

public class MinSteps {
    public static void main(String args[]) {
        // int[] arr = {5,1,2,3,4};
        int[] arr = { 1, 2, 2, 3, 4, 5, 5, 6 };
        // int[] arr = {1,1,3};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(minSteps(A));
    }

    public static int minSteps(ArrayList<Integer> A) {
        int len = A.size();

        Collections.sort(A);

        int count = 0;

        for (int i = 1; i < len; i++) {
            int curr = A.get(i);
            int prev = A.get(i - 1);
            if (curr <= prev) {
                count += (prev + 1) - curr;
                A.set(i, prev + 1);
            }
        }

        return count;
    }
}

// HashMap<Integer, Integer> hm = new HashMap<>();

// boolean isDistinct = true;

// for (int i = 0;i < len; i++) {
// int curr = A.get(i);

// boolean contains = hm.containsKey(curr);
// if (contains) {
// isDistinct = false;
// int hashVal = hm.get(curr);
// hashVal++;
// hm.replace(curr, hashVal);
// } else {
// hm.put(curr, 1);
// }
// }

// if (isDistinct) return 0;
// for (int i = len - 1; i >= 0; i--) {
// int curr = A.get(i);
// // 1,2,2,3,4,5,5,6
// // 1,2,2,3,4,5,6,7
// int hashVal = hm.get(curr);
// if (hashVal > 1) {
// while (hm.containsKey(curr)) {
// count++;
// curr++;
// }
// hm.put(curr, 1);
// hashVal--;
// hm.replace(A.get(i), hashVal);
// A.set(i, curr);
// }
// }