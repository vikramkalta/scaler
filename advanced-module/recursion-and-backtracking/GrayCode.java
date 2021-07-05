import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GrayCode {
    public static void main(String args[]) {
        System.out.println(solve(3));
        // System.out.println(solve(4));
        // System.out.println(solve(2));
        // System.out.println(solve(10));
    }

    public static ArrayList<Integer> solve(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        Set<Integer> isPresent = new HashSet<>();
        isPresent.add(0);
        _grayCode(result, A, isPresent);
        // System.out.println(result);
        return result;
    }

    public static boolean _grayCode(ArrayList<Integer> result, int end, Set<Integer> isPresent) {
        if (result.size() == (1 << end)) {
            return true;
        }
        int curr = result.get(result.size() - 1);
        for (int i = 0; i < end; i++) {
            int next = curr ^ (1 << i);
            if (!isPresent.contains(next)) {
                isPresent.add(next);
                result.add(next);
                if (_grayCode(result, end, isPresent)) {
                    return true;
                } else {
                    isPresent.remove(next);
                    result.remove(result.size() - 1);
                }
            }
        }
        return false;
    }

    public static String changeBit(String s, int n) {
        char c = s.charAt(n);
        if (c == '1') {
            c = '0';
        } else {
            c = '1';
        }
        char[] charA = s.toCharArray();
        charA[n] = c;
        return String.valueOf(charA);
    }

    public static boolean checkIfValid(String s, String prev) {

        HashMap<Character, Integer> hm = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (hm.containsKey(curr)) {
                int val = hm.get(curr);
                val++;
                hm.replace(curr, val);
            } else {
                hm.put(curr, 1);
            }
        }
        for (int i = 0; i < len; i++) {
            char curr = prev.charAt(i);
            if (hm.containsKey(curr)) {
                int val = hm.get(curr);
                val--;
                hm.replace(curr, val);
            }
        }
        int diffCount = 0;
        for (Map.Entry el : hm.entrySet()) {
            int val = (int) el.getValue();
            diffCount++;
        }
        if (diffCount == 1) {
            return true;
        }
        return false;
    }

    public static void _grayCode2(char[] s, int start, int end, ArrayList<Integer> result, int i) {
        if (start == end) {
            System.out.println(s);
            System.out.println(i);
            int n = convertToInt(String.valueOf(s));
            result.add(n);
            return;
        }
        // s = place(s, start, 0);
        // _grayCode(s, start + 1, end, result, 0);
        // s = place(s, start, 1);
        // _grayCode(s, start + 1, end, result, 1);
    }

    public static void _grayCode1(String s, int start, int end, ArrayList<Integer> result) {
        if (start == end) {
            System.out.println(s);
            int n = convertToInt(s);
            result.add(n);
            return;
        }
        // for (int i = 0; i < 2; i++) {
        // s = place(s, start, i);
        // _grayCode(s, start + 1, end, result);
        // }
        // s = place(s, start, 0);
        // _grayCode(s, start + 1, end, result);
        // s = place(s, start, 1);
        // _grayCode(s, start + 1, end, result);
    }

    private static String place(String s, int i, int j) {
        char x = Character.forDigit(j, 10);
        char[] charA = s.toCharArray();
        charA[i] = x;
        return String.valueOf(charA);
    }

    private static int convertToInt(String s) {
        int len = s.length();
        int sum = 0;
        for (int i = len - 1; i >= 0; i--) {
            int x = 0;
            char curr = s.charAt(i);
            if (curr == '1') {
                x = 1 << (len - 1 - i);
                sum += x;
            }
        }
        return sum;
    }

    private static String swap(String s, int i, int j) {
        char[] charA = s.toCharArray();
        char temp = s.charAt(i);
        char curr = s.charAt(j);
        charA[j] = temp;
        charA[i] = curr;
        return String.valueOf(charA);
    }
}
