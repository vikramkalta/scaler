package stringalgos;

public class CyclicPermutations {
    public static void main(String[] args) {
        // String A = "1001";
        // String B = "0011";
        // String A = "111";
        // String B = "111";
        // String A = "1101111111";
        // String B = "1101111111";
        String A = "0001000000";
        String B = "0000010000";
        System.out.println(solve(A, B));
    }

    public static int solve(String A, String B) {
        int ans = 0;
        int originalBLen = B.length();
        B += B;
        B = B.substring(0, B.length() - 1);
        A = A + "$" + B;
        int[] zAlgo = zAlgo(A);
        for (int i = 0; i < zAlgo.length; i++) {
            if (zAlgo[i] == originalBLen) {
                ans++;
            }
        }
        return ans;
    }
    public static int[] zAlgo(String A) {
        int[] zAlgo = new int[A.length()];
        int l = 0, r = 0;
        for (int i = 0; i < A.length(); i++) {
            if (i > r) {
                l = r = i;
                while(r < A.length() && A.charAt(r) == A.charAt(r-l)) {
                    r++;
                }
                zAlgo[i] = r-l;
                r--;
            } else {
                int k = i-l;
                if (zAlgo[k] < r-i+1) {
                    zAlgo[i] = zAlgo[k];
                } else {
                    l = i;
                    while(r < A.length() && A.charAt(r) == A.charAt(r-l)) {
                        r++;
                    }
                    zAlgo[i] = r-l;
                    r--;
                }
            }
        }
        return zAlgo;
    }
}