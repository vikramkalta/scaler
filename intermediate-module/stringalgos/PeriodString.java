package stringalgos;

public class PeriodString {
    public static void main(String[] args) {
        // String A = "abcabcabc";
        String A = "abcaabcaab";
        // String A = "abcdfag";
        System.out.println(solve(A));
    }
    // k can be 1,2,3,4 etc, so mathematical relation is that
    // zalgo will form an array where after every k interval
    // the value would be a multiple of k. rest all be 0
    public static int solve(String A) {
        int ans = A.length();
        int len = A.length();
        int[] zArray = zAlgo(A);
        for (int i = 1; i < len; i++) {
            if (zArray[i] + i == len) {
                ans = i;
                break;
            }
        }
        return ans;
    }
    public static int[] zAlgo(String A) {
        int len = A.length();
        int[] zArray = new int[len];
        int l = 0, r = 0;
        for (int i = 1; i < len; i++) {
            if (i > r) {
                l = r = i;
                while (r < len && A.charAt(r) == A.charAt(r-l)) {
                    r++;
                }
                zArray[i] = r-l;
                r--;
            } else {
                int k = i - l;
                // if (i < r && zArray[k] > zArray[r-i+1]) {
                if (zArray[k] > r-i+1) {
                    l = i;
                    while (r < len && A.charAt(r) == A.charAt(r-l)) {
                        r++;
                    }
                    zArray[i] = r-l;
                    r--;
                } else {
                    zArray[i] = zArray[k];
                }
            }
        }
        return zArray;
    }
}
