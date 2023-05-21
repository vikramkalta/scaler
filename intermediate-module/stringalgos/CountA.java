package stringalgos;

public class CountA {
    public static void main(String[] args) {
        String A = "aab";
        System.out.println(solve(A));
    }

    public static int solve(String A) {
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'a') {
                count++;
            }
        }
        return (count * (count + 1)) / 2;
    }
}
