import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Intersect {
    public static void main(String args[]) {
        int[] arr1 = { 2, 1, 4, 10 };
        int[] arr2 = { 3, 6, 2, 10, 10 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            A.add(arr1[i]);
        }
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            B.add(arr2[i]);
        }

        System.out.println(intersect(A, B));
    }

    public static ArrayList<Integer> intersect(ArrayList<Integer> A, ArrayList<Integer> B) {
        int lenA = A.size();
        int lenB = B.size();

        HashMap<Integer, Integer> aHash = new HashMap<>();

        for (int i = 0; i < lenA; i++) {
            int curr = A.get(i);
            boolean contains = aHash.containsKey(curr);
            if (contains) {
                Integer hashVal = aHash.get(curr);
                hashVal++;
                aHash.replace(curr, hashVal);
            } else {
                aHash.put(curr, 1);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < lenB; i++) {
            int curr = B.get(i);
            boolean contains = aHash.containsKey(curr);
            if (contains) {
                Integer hashVal = aHash.get(curr);
                hashVal--;
                aHash.replace(curr, hashVal);
                if (hashVal >= 0) {
                    result.add(curr);
                }
            }
        }
        return result;

        // HashMap<String, Integer> aHash = new HashMap<>();
        // HashMap<String, Integer> bHash = new HashMap<>();

        // for (int i = 0; i < lenA; i++) {
        //     int curr = A.get(i);
        //     String key = i + "" + curr;
        //     aHash.put(key, curr);
        // }

        // for (int i = 0; i < lenB; i++) {
        //     int curr = B.get(i);
        //     String key = i + "" + curr;
        //     bHash.put(key, curr);
        // }

        // ArrayList<Integer> result = new ArrayList<>();
        // for (int i = 0; i < lenB; i++) {
        //     int curr = B.get(i);
        //     boolean val = aHash.containsValue(curr);

        //     if (val) {
        //         // Integer bHashVal = bHash.get(key)
        //         result.add(curr);
        //     }
        // }

        // return result;
    }
}
