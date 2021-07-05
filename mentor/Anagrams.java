import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static void main(String args[]) {
        // System.out.println(solve("abcdefcba", "abc"));
        // System.out.println(solve("ppqp", "pq"));
        System.out.println(solve("abbcabc", "abc"));
    }

    public static ArrayList<Integer> solve(String s, String p) {
        int len = s.length();
        int pLen = p.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            char curr = p.charAt(i);
            if (hm.containsKey(curr)) {
                int val = hm.get(curr);
                val++;
                hm.replace(curr, val);
            } else {
                hm.put(curr, 1);
            }

        }
        HashMap<Character, Integer> hm1 = new HashMap<>(hm);
        int count = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            count++;
            if (hm1.containsKey(curr)) {
                int val = hm1.get(curr);
                val--;
                hm1.replace(curr, val);
            }
            if (count == pLen) {
                boolean isAnagram = true;
                for (Map.Entry _hm : hm1.entrySet()) {
                    int val = (int) _hm.getValue();
                    if (val > 0) {
                        isAnagram = false;
                        break;
                    }
                }
                if (isAnagram) {
                    result.add(i - pLen + 1);
                }
                // hm1 = new HashMap<>(hm);
                char first = s.charAt(i - pLen + 1);
                if (hm1.containsKey(first)) {
                    int val = hm1.get(first);
                    val++;
                    hm1.put(first, val);
                }
                count--;
            }
        }
        return result;
    }
}

// class Solution {
// public List<Integer> findAnagrams(String s, String p) {
// int ns = s.length(), np = p.length();
// if (ns < np) return new ArrayList();

// Map<Character, Integer> pCount = new HashMap();
// Map<Character, Integer> sCount = new HashMap();

// for (char ch : p.toCharArray()) {
// if (pCount.containsKey(ch)) {
// pCount.put(ch, pCount.get(ch) + 1);
// }
// else {
// pCount.put(ch, 1);
// }
// }

// List<Integer> output = new ArrayList();
// for (int i = 0; i < ns; ++i) {
// char ch = s.charAt(i);
// if (sCount.containsKey(ch)) {
// sCount.put(ch, sCount.get(ch) + 1);
// }
// else {
// sCount.put(ch, 1);
// }
// if (i >= np) {
// ch = s.charAt(i - np);
// if (sCount.get(ch) == 1) {
// sCount.remove(ch);
// }
// else {
// sCount.put(ch, sCount.get(ch) - 1);
// }
// }
// if (pCount.equals(sCount)) {
// output.add(i - np + 1);
// }
// }
// return output;
// }
// }
