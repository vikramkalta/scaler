import java.util.ArrayList;
import java.util.HashMap;

public class ReplaceNumbers {
    public static void main(String args[]) {
        int[] arr = { 4, 2, 5, 1 };
        // int[] arr = { 2, 2, 5 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        int[][] b = { { 4, 2 }, { 2, 5 }, { 1, 3 }, { 2, 4 } };
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int i = 0; i < b.length; i++) {
            ArrayList<Integer> a = new ArrayList<>();
            a.add(b[i][0]);
            a.add(b[i][1]);
            B.add(a);
        }
        System.out.println(solve(A, B));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int len = A.size();
        int bLen = B.size();
        // for (int i = 0; i < bLen; i++) {
        // int x = B.get(i).get(0);
        // int y = B.get(i).get(1);
        // for (int j = 0; j < len; j++) {
        // int curr = A.get(j);
        // if (curr == x) {
        // A.set(j, y);
        // }
        // }
        // }
        // HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (hm.containsKey(curr)) {
                ArrayList<Integer> val = hm.get(curr);
                val.add(i);
            } else {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(i);
                hm.put(curr, a);
            }

        }
        for (int i = 0; i < bLen; i++) {
            int x = B.get(i).get(0);
            int y = B.get(i).get(1);
            if (hm.containsKey(x)) {
                ArrayList<Integer> val = hm.get(x);
                int vLen = val.size();
                for (int j = 0; j < vLen; j++) {
                    int v = val.get(j);
                    A.set(v, y);
                }
                hm.put(y, val);
                hm.remove(x);
            }
        }
        // for (int i = 0; i < len; i++) {
        // int curr = A.get(i);
        // if (hm.containsKey(curr)) {
        // ArrayList<Integer> val = hm.get(curr);
        // int valLen = val.size();
        // for (int j = 0; j < valLen; j++) {
        // }
        // }
        // }
        return A;
    }
}
