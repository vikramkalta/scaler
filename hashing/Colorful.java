import java.util.ArrayList;
import java.util.HashMap;

public class Colorful {
    public static void main(String args[]) {
        int A = 3245;
        System.out.println(colorful(A));
    }

    public static int colorful(int A) {
        String str = String.valueOf(A);

        int len = str.length();

        HashMap<Integer, Boolean> hm = new HashMap<>();
        ArrayList<String> numbers = new ArrayList<>();

        boolean found = false;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            StringBuilder sbI = new StringBuilder();
            sbI.append(ch);
            String s = new String(sbI);

            numbers.add(s);
            for (int j = i + 1; j < len; j++) {
                char chJ = str.charAt(j);
                sbI.append(chJ);
                String sJ = new String(sbI);
                numbers.add(sJ);
            }
        }

        int numLen = numbers.size();
        for (int i = 0; i < numLen; i++) {
            String _str = numbers.get(i);
            int digLen = _str.length();

            int product = 1;
            for (int j = 0; j < digLen; j++) {
                char ch = _str.charAt(j);
                Integer digit = Character.getNumericValue(ch);
                product = product * digit;
            }
            boolean containsI = hm.containsKey(product);
            if (containsI) {
                found = true;
                break;
            } else {
                hm.put(product, true);
            }
            product = 1;
        }

        return found ? 0 : 1;
    }
}
