import java.util.HashMap;

public class Colorful {
    public static void main(String args[]) {
        // System.out.println(solve(3245));
        // System.out.println(solve(236));
        System.out.println(solve(263));
    }

    public static int solve(int A) {
        String str = String.valueOf(A);
        int len = str.length();

        HashMap<Long, Boolean> hm = new HashMap<>();
        int result = 1;
        for (int i = 0; i < len; i++) {
            char cI = str.charAt(i);
            int currI = cI - '0';
            if (hm.containsKey((long) currI)) {
                result = 0;
                break;
            } else {
                hm.put((long) currI, true);
            }
            long product = 1l;
            for (int j = i + 1; j < len; j++) {
                char cJ = str.charAt(j);
                int currJ = cJ - '0';
                product = product * (1l * (currI * currJ));
                if (hm.containsKey(product)) {
                    result = 0;
                    break;
                } else {
                    hm.put(product, true);
                }
            }
            if (result == 0) {
                break;
            }
        }
        return result;
    }
}
