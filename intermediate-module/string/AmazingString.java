package string;
import java.util.HashMap;

public class AmazingString {
    public static void main(String args[]) {
        String A = "ABEC";
        System.out.println(amazingString(A));
    }

    public static int amazingString(String A) {
        int len = A.length();

        int count = 0;

        HashMap<Character, Boolean> hm = new HashMap<>();
        hm.put('a', true);
        hm.put('e', true);
        hm.put('i', true);
        hm.put('o', true);
        hm.put('u', true);
        hm.put('A', true);
        hm.put('E', true);
        hm.put('I', true);
        hm.put('O', true);
        hm.put('U', true);

        
        for (int i = 0; i < len; i++) {
            char curr = A.charAt(i);
            if (hm.containsKey(curr)) {
                count = count + len - i;
            }
        }

        return count % 10003;
    }
}
