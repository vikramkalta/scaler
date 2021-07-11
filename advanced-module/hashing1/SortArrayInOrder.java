import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortArrayInOrder {
    public static void main(String args[]) {
        int[] arr1 = { 100, 4, 100, 1, 3, 2, 2 };
        int[] arr2 = { 5, 17, 22, 11 };
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++)
            A.add(arr1[i]);
        for (int i = 0; i < arr2.length; i++)
            B.add(arr2[i]);
        System.out.println(solve(A, B));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int lenA = A.size();
        int lenB = B.size();

        HashMap<Integer, Integer> a = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < lenA; i++) {
            int curr = A.get(i);
            if (a.containsKey(curr)) {
                int val = a.get(curr);
                val++;
                a.replace(curr, val);
            } else {
                a.put(curr, 1);
            }
        }
        ArrayList<Integer> rest = new ArrayList<>();
        for (int i = 0; i < lenB; i++) {
            int currB = B.get(i);
            if (a.containsKey(currB)) {
                int val = a.get(currB);
                for (int j = 0; j < val; j++) {
                    result.add(currB);
                }
                a.replace(currB, 0);
            }
        }
        for (Map.Entry en : a.entrySet()) {
            int key = (int) en.getKey();
            int val = (int) en.getValue();
            for (int i = 0; i < val; i++) {
                rest.add(key);
            }
        }
        Collections.sort(rest);
        int resultLen = result.size();
        // int restLen = rest.size();
        int counter = 0;
        for (int i = resultLen; i < lenA; i++) {
            result.add(rest.get(counter));
            counter++;
        }
        return result;
    }
}
