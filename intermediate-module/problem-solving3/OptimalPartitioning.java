import java.util.ArrayList;
import java.util.Collections;

public class OptimalPartitioning {
    public static void main(String args[]) {

    }

    public static int minDiff(ArrayList<Integer> A) {
        int len = A.size();

        Collections.sort(A);

        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < len - 1; i++) {
            int curr = A.get(i);
            int next = A.get(i+1);
            int diff = next - curr;
            if (min > diff) {
                min = diff;
            }
        }

        return min;
    }
}
