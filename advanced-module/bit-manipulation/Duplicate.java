import java.util.ArrayList;

public class Duplicate {
    public static void main(String args[]) {

    }

    public static int solve(ArrayList<Integer> A) {
        int len = A.size();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            ans ^= curr;
        }
        return ans;
    }
}