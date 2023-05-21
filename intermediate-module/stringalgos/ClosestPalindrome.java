package stringalgos;

public class ClosestPalindrome {
    public static void main(String[] args) {
        // String A = "abcba";
        // String A = "abbdba";
        String A = "abbdbd";
        System.out.println(solve(A));
    }

    public static String solve(String A) {
        int l = 0, r = A.length() - 1;
        int count = 0;
        while (l < r) {
            int leftChar = A.charAt(l);
            int rightChar = A.charAt(r);
            if (leftChar != rightChar) {
                count++;
            }
            l++;
            r--;
        }
        String yes = "YES";
        String no = "NO";
        if (count <= 1 && l==r) {
            return yes;
        }
        if (count == 1 && l > r) {
            return yes;
        }
        return no;
    }
}