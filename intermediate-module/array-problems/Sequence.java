public class Sequence {
    public static void main(String args[]) {
        String A = "AXGXGAXG";
        System.out.println(sequence(A));
    }

    public static int sequence(String A) {
        int len = A.length();

        int countG = 0;
        int countAG = 0;
        for (int i = len - 1; i >= 0; i--) {
            int curr = A.charAt(i);
            if (curr =='G') {
                countG++;
            }
            if (curr == 'A') {
                countAG = countG + countAG;
            }
        }
        return countAG;
    }
}
