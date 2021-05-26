import java.util.ArrayList;
import java.util.HashMap;

public class RepeatedNumber {
    public static void main(String args[]) {
        // int[] arr = {1,2,3,1,1};
        // int[] arr = { 1000441, 1000441, 1000994 };
        // int[] arr = { 1, 1, 1, 2, 3, 5, 7 };
        int[] arr = { 1000166, 1000423, 1000935, 1000792, 1000423, 1000432, 1000423, 1000423, 1000692, 1000601, 1000125 };

        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(repeatedNumber(A));
    }

    public static int repeatedNumber(ArrayList<Integer> A) {
        int len = A.size();

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(A.get(0), 1);
        for (int i = 1; i < len; i++) {
            int curr = A.get(i);
            if (hm.containsKey(curr)) {
                int val = hm.get(curr);
                val++;
                hm.replace(curr, val);
            } else {
                int keyCount = 0;
                int _key = -1;
                // int indexToCancel = i - 2;
                int min = Integer.MAX_VALUE;
                int compromisedKey = -1;
                for (int key : hm.keySet()) {
                    // if (indexToCancel >= 0 && A.get(indexToCancel) == key) {
                    //     _key = key;
                    // }
                    int val = hm.get(key);
                    if (min > val) {
                        min = val;
                        compromisedKey = key;
                    }
                    keyCount++;
                }
                if (keyCount < 2) {
                    hm.put(curr, 1);
                } else {
                    if (_key < 0) {
                        _key = compromisedKey;
                    }
                    int val = hm.get(_key);
                    val--;
                    if (val <= 0) {
                        hm.remove(_key);
                        hm.put(curr, 1);
                    } else {
                        hm.replace(_key, val);
                    }
                }
            }
        }

        int count1 = 0;
        int count2 = 0;
        int _key1 = -1;
        int _key2 = -1;
        for (int key : hm.keySet()) {
            if (_key1 < 0) {
                _key1 = key;
            } else {
                _key2 = key;
            }
        }
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (curr == _key1) {
                count1++;
            } 
            if (curr == _key2) {
                count2++;
            }
        }
        int ans = 0;
        int ansCount = 0;
        if (count1 > count2) {
            ansCount = count1;
            ans = _key1;
        }  else {
            ansCount = count2;
            ans = _key2;
        }
        return ansCount > len / 3 ? ans : -1;
    }
}
