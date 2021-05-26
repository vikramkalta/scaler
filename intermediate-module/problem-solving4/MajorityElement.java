import java.util.ArrayList;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String args[]) {
        // int[] arr = {100};
        // int[] arr = { 1, 2, 3, 3, 4, 4, 2, 2, 1, 2 };
        int[] arr = {2, 1, 1};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(majorityElement(A));
    }

    public static int majorityElement(ArrayList<Integer> A) {
        int len = A.size();

        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(A.get(0), 1);
        int majorityElement = A.get(0);
        for (int i = 1; i < len; i++) {
            int curr = A.get(i);
            if (hm.containsKey(curr)) {
                int val = hm.get(curr);
                val++;
                hm.replace(curr, val);
            } else {
                int _key = -1;
                for (int key : hm.keySet()) {
                    _key = key;
                }
                int val = hm.get(_key);
                val--;
                if (val == 0) {
                    hm.clear();
                    hm.put(curr, 1);
                } else {
                    hm.replace(_key, val);
                }

            }
        }
        for (int key : hm.keySet()) {
            majorityElement = key;
        }
        return majorityElement;
    }

    public static int majorityElementSpace(ArrayList<Integer> A) {
        int len = A.size();

        HashMap<Integer, Integer> hm = new HashMap<>();

        int majorityElement = -1;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (hm.containsKey(curr)) {
                int val = hm.get(curr);
                val++;
                if (val > len / 2) {
                    majorityElement = curr;
                    break;
                }
                hm.replace(curr, val);
            } else {
                hm.put(curr, 1);
            }
        }
        if (majorityElement < 0) {
            majorityElement = A.get(0);
        }
        return majorityElement;
    }
}
