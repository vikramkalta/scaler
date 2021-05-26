import java.util.ArrayList;
import java.util.HashMap;

public class MaxLengthPair {
    public static void main(String args[]) {
        // int[] arr = {1, 0, 1, 0, 1};
        // int[] arr = {1, 0, 1, 0};
        // int[] arr = {0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0};
        // int[] arr = {0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1};
        // int[] arr = {1, 1, 1, 0};
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(maxLength(A));
    }

    public static int maxLength(ArrayList<Integer> A) {
        int len = A.size();

        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(0);
        int sum = 0;

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            curr = curr == 1 ? 1: -1;
            sum += curr;
            prefix.add(sum);
        }

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        // hm.put(0, -1);

        int pLen = prefix.size();
        int max = 0;
        // int maxEl = Integer.MIN_VALUE;
        for (int i = 0; i < pLen; i++) {
            int curr = prefix.get(i);
            if (hm.containsKey(curr)) {
                
                ArrayList<Integer> arr = new ArrayList<>();
                arr = hm.get(curr);
                int prevPos = arr.get(0);
                int occurrence = arr.get(1);
                int distance = i - prevPos;
                occurrence += distance;
                if (max < occurrence) {
                    max = occurrence;
                }
                arr.set(0, i);
                arr.set(1, occurrence);
                hm.replace(curr, arr);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                arr.add(0);
                hm.put(curr, arr);
            }
        }

        return max;
    }
}
