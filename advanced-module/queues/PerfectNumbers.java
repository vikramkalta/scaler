import java.util.ArrayList;
import java.util.LinkedList;

public class PerfectNumbers {
    public static void main(String[] args) {
        int A = 3;
        // 1,2
        // 11,12
        // 21,22
        // 111,112,121,122,211,212,221,222
        // 1111-,1112,1121,1122,1221-,1222,2111,2112-,2121,2122,221,2212,2221,2222-

        // 2112,2222
        // 111111,112211,122221,
        // 11,22,1111,1221,2112,2222
        System.out.println(solve(A));
    }

    public static String solve(int A) {
        ArrayList<String> ans = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        int i = 0;
        while (i < A) {
            String x = queue.remove();
            String y = x + "1";
            queue.add(y);
            String z = x + "2";
            queue.add(z);
            // aa' op
            StringBuilder reverse = new StringBuilder();
            for (int j = x.length()-1; j>=0; j--) {
                reverse.append(x.charAt(j));
            }
            x = x + reverse;
            ans.add(x);
            i++;
        }
        return ans.get(A-1);
    }
}