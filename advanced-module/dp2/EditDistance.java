import java.util.ArrayList;

public class EditDistance {
    public static void main(String args[]) {
        // String A = "abcd";
        // String B = "bcad";
        // String A = "abad";
        // String B = "abac";
        // String A = "Anshuman";
        // String B = "Antihuman";
        String A = "bbbaabaa";
        String B = "aababbabb";
        System.out.println(solve(A, B));
    }

    public static int solve(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
        int lenA = A.length();
        int lenB = B.length();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < lenA; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < lenB; j++) {
                // innerArr.add(Integer.MAX_VALUE);
                innerArr.add(-1);
            }
            dp.add(innerArr);
        }
        int ans = getEditDist(A, B, A.length() - 1, B.length() - 1, dp);
        return ans;
    }

    public static int getEditDist(String A, String B, int i, int j, ArrayList<ArrayList<Integer>> dp) {
        // Base case
        if (j < 0) {
            return i + 1;
        }
        if (i < 0) {
            return j + 1;
        }
        int curr = dp.get(i).get(j);
        if (curr > -1) {
            return curr;
        }
        int ans = 0;
        if (A.charAt(i) == B.charAt(j)) {
            ans = getEditDist(A, B, i - 1, j - 1, dp);
        } else {
            int x = 1 + getEditDist(A, B, i, j - 1,  dp); // add
            int y = 1 + getEditDist(A, B, i - 1, j,  dp); // delete
            int z = 1 + getEditDist(A, B, i - 1, j - 1, dp); // replace
            int min = Math.min(x, y);
            ans = Math.min(min, z);
        }
        dp.get(i).set(j, ans);
        return ans;
    }
}
