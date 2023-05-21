package string;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumDistinctChars {
    public static void main(String args[]) {
        String A = "abcabbccd";
        System.out.println(minDistinctChars(A, 3));
    }

    public static int minDistinctChars(String A, int B) {
        int len = A.length();

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < len; i++) {

            char curr = A.charAt(i);

            boolean contains = hm.containsKey(curr);
            if (contains) {
                int hashVal = hm.get(curr);
                hashVal++;
                hm.replace(curr, hashVal);
            } else {
                hm.put(curr, 1);
            }
        }

        int min = Integer.MAX_VALUE;
        while (B > 0) {

            char curr = '0';
            for (Map.Entry m : hm.entrySet()) {
                int value = (int)m.getValue();
    
                if (min > value) {
                    curr = (char)m.getKey();
                    min = value;
                }
            }
            B = B - min;
            if (B >= 0) {
                hm.remove(curr);
                min = Integer.MAX_VALUE;
            }
        }
        
        int count = 0;
        for (Map.Entry m : hm.entrySet()) {
            count++;
        }
        return count;
    }
}