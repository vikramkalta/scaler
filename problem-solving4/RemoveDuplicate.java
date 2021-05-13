import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicate {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 3, 4, 5, 6 };
        int[] arr = { 2, 2 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(removeDuplicate(A));
    }

    // 1,1,2,3,4
    public static ArrayList<Integer> removeDuplicate(ArrayList<Integer> A) {
        int len = A.size();
        if (len == 1) {
            return A;
        }
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < len - 1; i++) {
            int curr = A.get(i);
            int next = A.get(i + 1);
            if (curr != next) {
                result.add(curr);
            }
        }

        int resultLen = result.size();
        int lastEl = A.get(len - 1);
        int lastElResult = -1;
        if (resultLen > 0) {
            lastElResult = result.get(resultLen - 1);
        }
        if (lastEl != lastElResult) {
            result.add(lastEl);
        }

        return result;
    }
}

// if (hm.containsKey(curr)) {
// int val = hm.get(curr);
// val++;
// hm.replace(curr, val);
// } else {
// hm.put(curr, 1);
// }
// for (int key : hm.keySet()) {
// int val = hm.get(key);
// if (val == 1) {
// result.add(key);
// }
// }