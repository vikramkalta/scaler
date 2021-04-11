import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public static void main(String args[]) {
        String arr[] = { "cat", "dog", "god", "tca" };
        // String arr[] = {"cde", "bee"};
        ArrayList<String> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(anagrams(A));
    }

    public static ArrayList<ArrayList<Integer>> anagrams(ArrayList<String> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int len = A.size();

        HashMap<String, ArrayList<Integer>> anagram = new HashMap<String, ArrayList<Integer>>();

        for (int i = 0; i < len; i++) {
            String str = A.get(i);

            String[] strArr = str.split("", 0);
            Arrays.sort(strArr);
            StringBuilder _sortedStr = new StringBuilder();
            for (int j = 0; j < strArr.length; j++) {
                _sortedStr.append(strArr[j]);
            }
            String sortedStr = new String(_sortedStr);

            boolean contains = anagram.containsKey(sortedStr);
            if (contains) {
                ArrayList<Integer> hashVal = anagram.get(sortedStr);
                int val = i + 1;
                hashVal.add(val);
                anagram.replace(sortedStr, hashVal);
            } else {
                ArrayList<Integer> hashVal = new ArrayList<>();
                hashVal.add(i + 1);
                anagram.put(sortedStr, hashVal);
            }

        }

        for (Map.Entry m : anagram.entrySet()) {
            ArrayList<Integer> arr = (ArrayList) m.getValue();
            result.add(arr);
        }
        return result;
    }

    public static StringBuilder getSortedStr(String s) {
        int len = s.length();
        StringBuilder newS = new StringBuilder(s);

        for (int i = 0; i < len; i++) {
            char chI = s.charAt(i);
            for (int j = i; j < len - 1; j++) {
                char chJ = s.charAt(j);
                char chJ1 = s.charAt(j+1);
                int asciiJ = chJ;
                int asciiJ1 = chJ1;
                if (asciiJ > asciiJ1) {
                    char temp = chJ;
                    newS.setCharAt(j, chJ1);
                    newS.setCharAt(j+1, temp);
                    newS.setCharAt(j, chI);
                }
            }
        }

        return newS;
    }
}

// HashMap<Integer, Integer> anagram = new HashMap<Integer, Integer>();

// for (int i = 0; i < len; i++) {
// String str = A.get(i);
// int strLen = str.length();
// ArrayList<Integer> arr = new ArrayList<>();

// int asciiSum = 0;
// for (int j = 0; j < strLen; j++) {
// char ch = str.charAt(j);
// int ascii = ch;
// asciiSum = asciiSum + ascii;
// }

// boolean contains = anagram.containsKey(asciiSum);
// if (contains) {
// int val = anagram.get(asciiSum);
// if (arr.isEmpty()) {
// arr.add(val);
// }

// val = i + 1;
// arr.add(val);
// anagram.replace(asciiSum, val);
// } else {
// anagram.put(asciiSum, i+1);
// }

// }
