import java.util.ArrayList;

public class LongestCommonSubsequence {
    public static void main(String args[]) {
        // String A = "abbcdgf";
        // String B = "bbadcgf";
        // String A = "bebdeeedaddecebbbbbabebedc";
        // String B = "abaaddaabbedeedeacbcdcaaed";
        String A = "bebdeeedaddecebbbbb";
        String B = "abaaddaabbedeedeacb";
        System.out.println(solve(A, B));
    }

    public static int solve(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < lenA; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < lenB; j++) {
                innerArr.add(-1);
            }
            dp.add(innerArr);
        }
        int longestCommonStrLen = lcs(A, B, lenA - 1, lenB - 1, dp);
        return longestCommonStrLen;
    }

    public static int lcs(String A, String B, int i, int j, ArrayList<ArrayList<Integer>> dp) {
        if (i < 0) {
            return 0;
        }
        if (j < 0) {
            return 0;
        }
        int curr = dp.get(i).get(j);
        if (curr > -1) {
            return curr;
        }
        int ans = 0;
        if (A.charAt(i) == B.charAt(j)) {
            ans = lcs(A, B, i - 1, j - 1, dp) + 1;
        } else {
            int x = lcs(A, B, i - 1, j, dp);
            int y = lcs(A, B, i, j - 1, dp);
            int z = Math.max(x, y);
            ans += z;
        }
        dp.get(i).set(j, ans);
        return ans;
    }
}
