package stringalgos;

public class ZAlgo {
    public static void main(String[] args) {
        // String A = "abcabc";
        String A = "aabxaabxaabxay";
        // l=4,i=8,r=12
        // 
        // [0,1,0,0,9,1,0,0,5,1,0,0,0]
        /**
         * l=0
         * r=0
         */
        // String B = "cab";
        String B = "aabxay";
        System.out.println(zAlgo(A, B));
    }
    public static int zAlgo(String A, String B) {
        int ans = 0;
        int l = 0;
        int r = 0;
        A = B + "$" + A;
        int[] zAlgo = new int[A.length()];
        // r=12,l=4
        for (int i = 1; i < A.length(); i++) {
            if (i > r) {
                l = r = i;
                while (r < A.length() && A.charAt(r) == A.charAt(r - l)) {
                    r++;
                }
                zAlgo[i] = r-l;
                r--;
            } else {
                if (zAlgo[i-l] > r-i+1) {
                    l = i;
                    while(r < A.length() && A.charAt(r) == A.charAt(r-l)) {
                        r++;
                    }
                    zAlgo[i] = r-l;
                    r--;
                } else {
                    zAlgo[i] = zAlgo[i-l];
                }
            }
        }
        for (int i = 0; i < zAlgo.length; i++) {
            if (zAlgo[i] == B.length()) {
                return 1;
            }
        }
        return ans;
    }

    public static int zAlgo2(String A, String B) {
        int ans = 0;
        String C = B + "$" + A;
        int[] zArray = new int[A.length()];
        int l = 0;
        int r = 0;
        for (int i = 1; i < A.length(); i++) {
            // i is outside of the window
            if (i > r) {
                // brute force
                l = r = i;
                while (r < A.length() && A.charAt(r-l)== A.charAt(r)) {
                    r++;
                }
                zArray[i] = r-l;
                r--;
            } else {
                int k = i - l;
                if (zArray[k] < r - i + 1) {
                    zArray[i] = zArray[k];
                } else {
                    l = i;
                    while (r < A.length() && A.charAt(r-l) == A.charAt(r)) {
                        r++;
                    }
                    zArray[i] = r - l;
                    r--;
                }
            }
        }
        return ans;
    }
    public static int zAlgo1(String A, String B) {
        int ans = 0;
        String C = B + "$" + A;
        int[] zArray = new int[A.length()];
        for (int i = 1; i < A.length(); i++) {
            int l = i;
            int r = 0;
            int count = 0;
            while (r < A.length() && A.charAt(l) == A.charAt(r)) {
                count++;
                l++;
                r++;
            }
            zArray[i] = count;
        }
        return ans;
    }
}
