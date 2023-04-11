package backtracking2;
import java.util.ArrayList;

public class PalindromePartition {
    public static void main(String args[]) {
        String A = "aab";
        // System.out.println(partition1(A));
        System.out.println(partition(A));
    }

    public static ArrayList<ArrayList<String>> partition1(String a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        palindrome(a, 0, result, new ArrayList<>());
        return result;
	}
    public static void palindrome(String a, int i, ArrayList<ArrayList<String>> result, ArrayList<String> innerList) {
        if (i >= a.length()) {
            result.add(new ArrayList<String>(innerList));
            // return;
        }
        for (int j = i; j < a.length(); j++) {
            if (isPalindrome1(a, i, j)) {
                innerList.add(a.substring(i, j + 1));
                palindrome(a, i + 1, result, innerList);
                innerList.remove(innerList.size() - 1);
            }
        }
    }
    public static boolean isPalindrome1(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }

    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        dfs(0, result, new ArrayList<String>(), s);
        return result;
    }

    static void dfs(int start, ArrayList<ArrayList<String>> result, ArrayList<String> currentList, String s) {
        if (start >= s.length())
            result.add(new ArrayList<String>(currentList));

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
