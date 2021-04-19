import java.util.HashMap;

public class PermutationSlidingWindow {
    public static void main(String args[]) {
        String A = "abc";
        String B = "abcbacabc";
        // String A = "docp";
        // String B = "aoapeooeoapcpaocecddoocdcqqapeapccc";
        // String A = "p";
        // String B = "pccdpeeooadeocdoacddapacaecb";
        // String A = "ebbp";
        // String B =
        // "qaoedpcebeaqocbacoccqoebpqdoqcpbdbqcecdoqcpebqpebbabqdpepcpbqbepbabocpc";
        System.out.println(perm(A, B));
    }

    public static int perm(String A, String B) {
        int aLen = A.length();
        int bLen = B.length();

        HashMap<Character, Integer> s1 = new HashMap<>();
        for (int i = 0; i < aLen; i++) {
            char ch = A.charAt(i);

            boolean contains = s1.containsKey(ch);
            if (contains) {
                int hashVal = s1.get(ch);
                hashVal++;
                s1.replace(ch, hashVal);
            } else {
                s1.put(ch, 1);
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> s2 = new HashMap<>();

        for (int i = 0; i < bLen; i++) {
            char ch = B.charAt(i);

            boolean contains = s1.containsKey(ch);
            if (contains) {
                boolean s2Contains = s2.containsKey(ch);
                if (s2Contains) {
                    int hashVal = s2.get(ch);
                    hashVal++;
                    s2.replace(ch, hashVal);
                } else {
                    s2.put(ch, 1);
                }
            }

            sb.append(ch);
            int sbLen = sb.length();

            if (sbLen == aLen) {
                if (s1.equals(s2)) {
                    count++;
                }

                char firstCh = sb.charAt(0);
                boolean firstChContains = s2.containsKey(firstCh);
                if (firstChContains) {
                    int firstChHashVal = s2.get(firstCh);
                    firstChHashVal--;
                    if (firstChHashVal == 0) {
                        s2.remove(firstCh);
                    } else {
                        s2.replace(firstCh, firstChHashVal);
                    }
                }
                sb.deleteCharAt(0);
            }
        }

        return count;
    }
}
// sb.append(ch);

// HashMap<Character, Integer> s2 = new HashMap<>();

// if (sb.length() == aLen) {
// boolean isPerm = true;
// for (int j = 0; j < sb.length(); j++) {
// char sbCh = sb.charAt(j);
// boolean contains = s1.containsKey(sbCh);
// if (contains) {
// boolean s2Contains = s2.containsKey(sbCh);
// if (s2Contains) {
// int hashVal = s2.get(sbCh);
// hashVal++;
// s2.replace(sbCh, hashVal);
// } else {
// s2.put(sbCh, 1);
// }
// }
// if (!contains) {
// isPerm = false;
// break;
// }
// }
// if (isPerm) {
// if (s1.equals(s2)) {
// count++;
// }
// s2.clear();
// }
// }