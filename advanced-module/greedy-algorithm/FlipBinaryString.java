public class FlipBinaryString {
    public static void main(String args[]) {
        // String A = "00010110";
        String A = "011";
        System.out.println(solve(A, 3));
    }

    public static int solve(String A, int B) {
        int len = A.length();
        StringBuilder s = new StringBuilder(A);
        int totalAttempts = 0;
        for (int i = 0; i < len - B + 1; i++) {
            char curr = s.charAt(i);
            if (curr == '0') {
                int j = i;
                int upperBound = i + B;
                while (j < upperBound) {
                    s.setCharAt(j, s.charAt(j) == '0' ? '1' : '0');
                    j++;
                }
                totalAttempts++;
            }
        }
        boolean isAllOne = true;
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (curr == '0'){
                isAllOne = false;
                break;
            }
        }
        return isAllOne ? totalAttempts : -1;
    }
}