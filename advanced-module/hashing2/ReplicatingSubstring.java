import java.util.HashMap;
import java.util.Map;

public class ReplicatingSubstring {
    public static void main(String args[]) {
        System.out.println(solve(2, "bbaabb"));
        // System.out.println(solve(1, "bc"));
    }

    public static int solve(int A, String B) {
        int len = B.length();
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char curr = B.charAt(i);
            if (hm.containsKey(curr)) {
                hm.put(curr, hm.get(curr) + 1);
            } else {
                hm.put(curr, 1);
            }
        }
        int result = 1;
        for (Map.Entry ent : hm.entrySet()) {
            int val = (int) ent.getValue();
            if (val % A != 0) {
                result = -1;
                break;
            }
        }
        return result;
    }
}
