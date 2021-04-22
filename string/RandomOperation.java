import java.util.HashMap;

public class RandomOperation {
    public static void main(String args[]) {
        String A = "hgUe";
        System.out.println(randomOps(A));
    }

    public static String randomOps(String A) {
        int len = A.length();

        StringBuilder sb = new StringBuilder(A);

        for (int i = 0; i < sb.length(); i++) {
            char curr = sb.charAt(i);

            if (curr >= 'A' && curr <= 'Z') {
                sb.deleteCharAt(i);
                i--;
            }
        }

        HashMap<Character, Boolean> hm = new HashMap<>();
        hm.put('a', true);
        hm.put('e', true);
        hm.put('i', true);
        hm.put('o', true);
        hm.put('u', true);

        int sbLen = sb.length();
        for (int i = 0; i < sbLen; i++) {
            char curr = sb.charAt(i);

            boolean contains = hm.containsKey(curr);
            if (contains) {
                sb.setCharAt(i, '#');
            }
        }

        for (int i = 0; i < sbLen; i++) {
            sb.append(sb.charAt(i));
        }

        return new String(sb);
    }
}
