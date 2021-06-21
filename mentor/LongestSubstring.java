import java.util.HashMap;

public class LongestSubstring {
    public static void main(String args[]) {
        System.out.println(solve("araaci", 2));
    }

    // a r a a c i
    public static int solve(String A, int K) {
        int len = A.length();
        int count = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int windowStart = 0, windowEnd = 0;
        for (windowEnd = 0; windowEnd < len; windowEnd++) {
            char curr = A.charAt(windowEnd);
            hm.put(curr, hm.getOrDefault(curr, 0) + 1);

            while (hm.size() > K) {
                char _left = A.charAt(windowStart);
                hm.put(_left, hm.getOrDefault(_left, 0) - 1);
                if (hm.get(_left) == 0) {
                    hm.remove(_left);
                }
                windowStart++;
            }
            count = Math.max(count, windowEnd - windowStart + 1);
        }

        return count;
    }
}