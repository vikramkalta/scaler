import java.util.ArrayList;
import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        // int[] arr = { 0, 1, 0, 1, 0 };
        // int[] arr = {0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0};
        // int[] arr = {0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1};
        int[] arr = {0,1};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(contiguousArray(A));
    }
    

    public static int contiguousArray(ArrayList<Integer> A) {
        int len = A.size();

        ArrayList<Integer> sum = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);

            if (i == 0) {
                int val = curr == 1 ? 1 : -1;
                sum.add(val);
            } else {
                if (curr == 0) {
                    int val = sum.get(i - 1) + -1;
                    sum.add(val);
                } else {
                    int val = sum.get(i - 1) + 1;
                    sum.add(val);
                }
            }
        }

        HashMap<Integer, Integer> pair = new HashMap<>();
        pair.put(0, -1);

        int sumLen = sum.size();
        int maxSize = 0;
        for (int i = 0; i < sumLen; i++) {
            int curr = sum.get(i);

            boolean contains = pair.containsKey(curr);
            if (contains) {
                int hashVal = pair.get(curr);
                int tryMax = i - hashVal;
                // System.out.println(tryMax);
                if (tryMax >= maxSize) {
                    maxSize = tryMax;
                }
            } else {
                pair.put(curr, i);
            }
        }

        return maxSize;
        
    }
}

