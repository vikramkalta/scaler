package recursion;
public class Palindrome {
    public static void main(String args[]){
        // String A = "naman";
        String A = "strings";
        System.out.println(palindrome(A));
    }

    public static int palindrome(String A) {
        int len = A.length();
        
        if (len <= 1) {
            return 1;
        }

        char curr = A.charAt(0);
        char rev= A.charAt(len - 1);

        if (curr != rev) {
            return 0;
        }

        A = A.substring(1, len - 1);
        return palindrome(A);
    }
}
