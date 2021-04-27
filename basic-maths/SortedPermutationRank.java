public class SortedPermutationRank {
    public static void main(String args[]) {
        // String A = "dbca";
        // String A = "acb";
        // String A = "VIEW";
        // String A = "AaBbCc";
        // String A = "DTNGJPURFHYEW";
        String A = "ZCSFLVHXRYJQKWABGT";
        // String A = "BACA";
        System.out.println(sortedPermRank(A));
    }

    public static int sortedPermRank(String A) {
        int len = A.length();

        long rank = 0;

        for (int i = 0; i < len - 1; i++) {
            char curr = A.charAt(i);
            int smallerEls = 0;
            for (int j = i + 1; j < len; j++) {
                char currJ = A.charAt(j);
                if (currJ < curr) {
                    smallerEls++;
                }
            }
            rank = (rank + (smallerEls * getFactorial(len-1-i)));
        }

        int ans = (int)((rank + 1) % 1000003);
        return ans;
    }

    public static long getFactorial(int n) {
        long fact = 1;
        for (int i = n; i >= 1; i--) {
            fact = (fact * i)%1000003;
        }

        return fact;
    }
}
