import java.util.ArrayList;
import java.util.HashMap;

public class IsDictionary {
    public static void main(String args[]) {
        // String[] a = { "ipial", "qjqgt", "vfnue", "vjqfp", "eghva", "ufaeo", "atyqz", "chmxy", "ccvgv", "ghtow" };
        // String[] a ={"hello", "scaler", "interviewbit"};
        String[] a = {"fine", "none", "no"};
        ArrayList<String> A = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]);
        }
        // String B = "nbpfhmirzqxsjwdoveuacykltg";
        // String B = "adhbcfegskjlponmirqtxwuvzy";
        String B = "qwertyuiopasdfghjklzxcvbnm";
        System.out.println(isDictionary(A, B));
    }

    public static int isDictionary(ArrayList<String> A, String B) {
        int aLen = A.size();
        int bLen = B.length();

        HashMap<Character, Integer> order = new HashMap<>();

        for (int i = 0; i < bLen; i++) {
            char ch = B.charAt(i);
            order.put(ch, i + 1);
        }

        int prev = 0;
        boolean isOrdered = true;

        int i = 0;
        int j = 0;

        int minStrLen = A.get(0).length();

        do {
            String curr = A.get(i);

            int currLen = curr.length();
            if (minStrLen > currLen) {
                minStrLen = currLen;
            }

            char ch = curr.charAt(j);
            int orderOfChar = order.get(ch);

            if (prev > orderOfChar) {
                isOrdered = false;
                break;
            } else {
                if (prev == orderOfChar) {
                    // Prev string
                    String prevStr = A.get(i - 1);
                    int prevStrLen = prevStr.length();
                    int iLen = currLen;
                    if (currLen > prevStrLen) {
                        iLen= prevStrLen;
                    }
                    int t = j + 1;
                    for (int x = t; x < iLen; x++) {
                        char chCurrInner = curr.charAt(x);
                        char chPrevInner = prevStr.charAt(x);

                        int orderOfCurrCharInner = order.get(chCurrInner);
                        int orderOfPrevCharInner = order.get(chPrevInner);

                        if (orderOfCurrCharInner < orderOfPrevCharInner) {
                            isOrdered= false;
                            break;
                        } else if (orderOfCurrCharInner > orderOfPrevCharInner) {
                            break;
                        } else {
                            continue;
                        }

                        // if (x == iLen - 1) {
                        //     x = 0;
                        //     t++;
                        // }
                    }

                    if (!isOrdered) {
                        break;
                    }
                    
                    if (currLen < prevStrLen) {
                        isOrdered = false;
                        break;
                    }
                }
                prev = orderOfChar;
                i = (i % aLen) + 1;

                // if (i == aLen && j < minStrLen - 1) {
                //     // Reset prev to 0;
                //     prev = 0;
                //     i = 0;
                //     j++;
                // }
            }

        } while (i < aLen);

        return isOrdered ? 1 : 0;
    }
}




