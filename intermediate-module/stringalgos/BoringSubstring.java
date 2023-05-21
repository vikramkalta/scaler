package stringalgos;

import java.util.ArrayList;
import java.util.Collections;

public class BoringSubstring {
    public static void main(String[] args) {
        // String A = "abcd";
        String A = "aab";
        System.out.println(solve(A));
    }
    
    public static int solve(String A) {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            int curr = (int) A.charAt(i);
            if (curr % 2 == 0) {
                x.add(curr);
            } else {
                y.add(curr);
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        int a = x.get(x.size() - 1);
        int b = y.get(0);
        int c = x.get(0);
        int d = y.get(y.size() - 1);
        if (a - b > 1) {
            return 1;
        }
        if (c - d > 1) {
            return 1;
        }
        return 0;
    }
}