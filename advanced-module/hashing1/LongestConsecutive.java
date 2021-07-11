import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutive {
    public static void main(String args[]) {
        int[] arr = { 100, 4, 200, 1, 3, 2 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            hm.put(curr, true);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            int next = curr + 1;
            int countOfMaxSeq = 1;
            if (hm.containsKey(next)) {
                continue;
            } else {
                // biggest in the sequence
                curr--;
                while (hm.containsKey(curr)) {
                    curr--;
                    countOfMaxSeq++;
                }
            }
            if (max < countOfMaxSeq) {
                max = countOfMaxSeq;
            }
        }
        return max;
    }
}