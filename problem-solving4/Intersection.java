import java.util.ArrayList;
import java.util.HashMap;

public class Intersection {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 3, 4, 5, 6 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        int[] arr1 = { 3, 3, 5 };
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++)
            B.add(arr1[i]);
        System.out.println(intersection(A, B));
    }

    public static ArrayList<Integer> intersection(ArrayList<Integer> A, ArrayList<Integer> B) {
        int lenA = A.size();
        int lenB = B.size();

        ArrayList<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < lenA; i++) {
            int curr = A.get(i);
            if (hm.containsKey(curr)) {
                int val = hm.get(curr);
                val++;
                hm.replace(curr, val);
            } else {
                hm.put(curr, 1);
            }
        }
        for (int i = 0; i < lenB; i++) {
            int curr = B.get(i);
            if (hm.containsKey(curr)) {
                result.add(curr);
                int val = hm.get(curr);
                val--;
                if (val <= 0) {
                    hm.remove(curr);
                } else {
                    hm.replace(curr, val);
                }
            }
        }
        return result;
    }
}
