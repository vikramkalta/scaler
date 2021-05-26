public class PalindromeInteger {
    public static void main(String args[]) {

    }

    public static int palindromeInt(int A) {
        String num = String.valueOf(A);

        int numLen = num.length();
        int isPalindrome = 1;
        for (int i = 0; i < numLen; i++) {
            char curr = num.charAt(i);
            char rev = num.charAt(numLen - 1 - i);
            if (curr != rev) {
                isPalindrome = 0;
                break;
            }
        }
        return isPalindrome;
    }
}
