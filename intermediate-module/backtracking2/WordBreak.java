package backtracking2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        // String s = "leetcodee";
        // String[] wd = {"leet", "code"};
        // String s = "mypenmy";
        // String[] wd = {"my", "pen"};
        // String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        // String[] wd = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        String s = "aaaaaaaaaab";
        String[] wd = {"a","aa","aaa","aaaa"};
        List<String> wordDict = new ArrayList<>();
        for (int i = 0; i < wd.length; i++) {
            wordDict.add(wd[i]);
        }
        System.out.println(wordBreak(s, wordDict));
    }
    public static HashSet<String> set = new HashSet<>();
    public static boolean wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        int[] dp = new int[s.length()];
        boolean ans = wb(s, 0, dp);
        return ans;
    }
    public static boolean wb(String s, int pos, int[] dp) {
        if (pos >= s.length()) {
            return true;
        }
        if (dp[pos] == 1) {
            return true;
        }
        for (int i = pos; i < s.length(); i++) {
            if (set.contains(s.substring(pos, pos + (i - pos + 1))) && wb(s, i + 1, dp)) {
                dp[pos] = 1;
                return true;
            }
        }
        return false;
    }
}