public class ClosestPalindrome {
    public static void main(String args[]) {
        // String A = "aba";
        // String A = "abba";
        String A = "aaaaaaaaaabaaaaaaaaa";
        System.out.println(closestPalindrome(A));
    }

    public static String closestPalindrome(String A) {
        int len = A.length();

        int count = 0;
        for (int i = 0; i < len / 2; i++) {
            int curr = A.charAt(i);
            int rev = A.charAt(len - 1 - i);

            if (curr != rev) {
                count++;
            }
            if (count > 1) {
                break;
            }
        }

        if (count <= 1) {
            if (count == 0 && len % 2 == 0) {
                return "NO";
            }
            if (count == 1 && len % 2 == 0) {
                return "YES";
            }
            return "YES";
        }
        return "NO";
    }
}
