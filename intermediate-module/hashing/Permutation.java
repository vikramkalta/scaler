import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Permutation {
    public static void main(String args[]) {
        String A = "abc";
        String B = "abcbacabc";
        System.out.println(permutation(A, B));
    }

    public static int permutation(String A, String B) {
        String[] strArr = A.split("", 0);
        Arrays.sort(strArr);

        StringBuilder _sortedStr = new StringBuilder();
        int strLen = strArr.length;
        for (int i = 0; i < strLen; i++) {
            _sortedStr.append(strArr[i]);
        }
        String sortedStr = new String(_sortedStr);

        HashMap<String, Integer> perm = new HashMap<>();
        perm.put(sortedStr, 0);

        StringBuilder subStr = new StringBuilder();

        int bLen = B.length();
        for (int i = 0; i < bLen; i++) {
            char ch = B.charAt(i);

            int subStrLen = subStr.length();

            if (subStrLen == strLen) {
                subStr.deleteCharAt(0);
            }

            subStr.append(ch);

            if (subStr.length() == strLen) {
                String sb = subStr.toString();
                boolean contains = perm.containsKey(sb);
                if (contains) {
                    int hashVal = perm.get(sb);
                    hashVal++;
                    perm.replace(sb, hashVal);
                } else {
                    perm.put(sb, 1);
                }
            }
        }

        // for (Map.Entry m : perm.entrySet()) {
        //     String keyStr = (String)m.getKey();
        //     String[] keyStrArr = keyStr.split("",0);
        //     Arrays.sort(keyStrArr);
        // }

        int ans = perm.get(sortedStr);
        return ans;
    }
}


// Bruteforce approach
// public int solve(String A, String B) {
//     String[] strArr = A.split("", 0);
//      Arrays.sort(strArr);

//      StringBuilder _sortedStr = new StringBuilder();
//      int strLen = strArr.length;
//      for (int i = 0; i < strLen; i++) {
//          _sortedStr.append(strArr[i]);
//      }
//      String sortedStr = new String(_sortedStr);

//      HashMap<String, Integer> perm = new HashMap<>();
//      perm.put(sortedStr, 0);

//      // ArrayList<String> subStrArr = new ArrayList<>();

//      StringBuilder subStr = new StringBuilder();

//      int bLen = B.length();
//      for (int i = 0; i < bLen; i++) {
//          char ch = B.charAt(i);

//          int subStrLen = subStr.length();

//          if (subStrLen == strLen) {
//              subStr.deleteCharAt(0);
//          }

//          subStr.append(ch);

//          if (subStr.length() == strLen) {
//              String sb = subStr.toString();
//              String[] _subStrArr = sb.split("", 0);
//              Arrays.sort(_subStrArr);
//              StringBuilder sb1 = new StringBuilder();
//              for (int j = 0; j < strLen; j++) {
//                  sb1.append(_subStrArr[j]);
//              }
//              String sortedSubStr = sb1.toString();
//              boolean contains = perm.containsKey(sortedSubStr);
//              if (contains) {
//                  int hashVal = perm.get(sortedSubStr);
//                  hashVal++;
//                  perm.replace(sortedSubStr, hashVal);
//              }
//          }
//      }
//      int ans = perm.get(sortedStr);
//      return ans;
//  }