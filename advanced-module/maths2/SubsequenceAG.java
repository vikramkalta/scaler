public class SubsequenceAG {
    public static void main(String args[]) {
        System.out.println(solve("AAAGABG"));
    }

    public static int solve(String A) {
        int len = A.length();
        int count = 0, countG = 0;
        for (int i = len - 1;i >= 0; i--) {
            char curr = A.charAt(i);
            if (curr == 'G') {
                countG++;
            }
            if (curr == 'A') {
                count += countG;
            }
        }
        return count;
    }
}
