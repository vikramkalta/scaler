package recursion;
import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhone {
    public static void main(String args[]) {
        String A = "23";
        System.out.println(letterCombinations(A));
    }
    public static String[] letterCombinations(String A) {
        HashMap<Character, String> charMap = new HashMap<>();
        charMap.put('0', "0");
        charMap.put('1', "1");
        charMap.put('2', "abc");
        charMap.put('3', "def");
        charMap.put('4', "ghi");
        charMap.put('5', "jkl");
        charMap.put('6', "mno");
        charMap.put('7', "pqrs");
        charMap.put('8', "tuv");
        charMap.put('9', "wxyz");
        ArrayList<String> result = new ArrayList<>();
        solve(A, result, charMap, new char[A.length()], 0);
        String[] ans = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
    public static void solve(String A, ArrayList<String> B, HashMap<Character, String> C, char[] D, int i) {
        if (i >= A.length()) {
            StringBuilder strBldr = new StringBuilder();
            for (int index = 0; index < D.length; index++) {
                char x = D[index];
                strBldr.append(x);
            }
            B.add(new String(strBldr));
            return;
        }
        String x = C.get(A.charAt(i));
        for (int j = 0; j < x.length(); j++) {
            D[i] = x.charAt(j);
            solve(A, B, C, D, i + 1);
        }
    }
}
