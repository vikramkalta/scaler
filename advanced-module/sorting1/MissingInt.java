import java.util.ArrayList;
import java.util.Collections;

public class MissingInt {
    public static void main(String args[]) {
    }

    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int len = A.size();
        int missing = -1;
        int prev = A.get(0);
        for (int i = 1; i < len; i++) {
            int curr = A.get(i);
            if (curr - prev > 1) {
                missing = curr - 1;
                break;
            }
            prev = curr;
        }
        return missing == -1 ? 1 : 0;

    }
}
