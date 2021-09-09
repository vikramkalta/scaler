import java.util.ArrayList;

public class LetterPhone {
    public static void main(String args[]) {
        // System.out.println(solve("234"));
        System.out.println(solve("20"));
    }

    public static ArrayList<String> solve(String A) {
        ArrayList<String> mapping = new ArrayList<>();
        mapping.add("0");
        mapping.add("1");
        mapping.add("abc");
        mapping.add("def");
        mapping.add("ghi");
        mapping.add("jkl");
        mapping.add("mno");
        mapping.add("pqrs");
        mapping.add("tuv");
        mapping.add("wxyz");
        int x = A.charAt(0) - '0';
        int len = mapping.get(x).length();

        ArrayList<String> result = new ArrayList<>();
        generate(A, "", 0, A.length(), len, result, mapping);
        return result;
    }

    private static void generate(String originalString, String str, int index, int oStrLen, int len, ArrayList<String> result,
            ArrayList<String> mapping) {
        if (index == oStrLen) {
            System.out.println("str: " + str);
            result.add(str);
            return;
        }
        int digit = originalString.charAt(index) - '0';
        String mappedString = mapping.get(digit);
        int _len = mappedString.length();
        for (int i = 0; i < _len; i++) {
            String s = new String();
            char ch = mappedString.charAt(i);
            s = str + ch;
            generate(originalString, s, index + 1, oStrLen, len, result, mapping);
        }
    }

    private static void generate1(String originalString, String str, int index, int len, ArrayList<String> result,
            ArrayList<String> mapping) {
        if (index == len) {
            System.out.println("str: " + str);
            result.add(str);
            return;
        }
        for (int i = 0; i < len; i++) {
            String s = new String();
            int digit = originalString.charAt(index) - '0';
            String mappedString = mapping.get(digit);
            char ch = mappedString.charAt(i);
            s = str + ch;
            generate1(originalString, s, index + 1, len, result, mapping);
        }
    }
}
