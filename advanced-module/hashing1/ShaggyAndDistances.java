import java.util.ArrayList;
import java.util.HashMap;

public class ShaggyAndDistances {
    public static void main(String args[]) {
        int[] arr = { 100, 4, 100, 1, 3, 2 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (hm.containsKey(curr)) {
                found = true;
                int prevPos = hm.get(curr);
                int diff = i - prevPos;
                if (min > diff) {
                    min = diff;
                }
                hm.replace(curr, i);
            } else {
                hm.put(curr, i);
            }
        }
        return found ? min : -1;
    }
}
