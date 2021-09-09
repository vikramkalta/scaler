import java.util.ArrayList;
import java.util.HashMap;

public class PointsOnSameLine {
    public static void main(String args[]) {
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        // int[] a = { -1, 0, 1, 2, 3, 3 };
        // int[] b = { 1, 0, 1, 2, 3, 4 };
        // int[] a = { -1, 0, 1, 2 };
        // int[] b = { 1, 0, 1, 2 };
        // int[] a = { 3, 1, 4, 5, 7, -9, -8, 6 };
        // int[] b = { 4, -8, -3, -2, -1, 5, 7, -4 };
        // int[] a = { -10, 7, 4, -5, 4 };
        // int[] b = { -6, -4, -6, 0, -8 };
        int[] a = { 1, 7, -2, -10, 4, -7, 5, 1 };
        int[] b = { -4, -5, -10, -10, -4, -6, 3, 3 };
        for (int i = 0; i < a.length; i++)
            A.add(a[i]);
        for (int i = 0; i < b.length; i++)
            B.add(b[i]);
        System.out.println(solve(A, B));
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = A.size();

        HashMap<String, Integer> hm = new HashMap<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int currX1 = A.get(i);
            int currY1 = B.get(i);
            for (int j = i + 1; j < len; j++) {
                int currX2 = A.get(j);
                int currY2 = B.get(j);
                int diffY = currY2 - currY1;
                int diffX = currX2 - currX1;
                String tan = slopeCoPrime(diffY, diffX);
                // if (tan.equals("1+1")) {
                if (diffY == 0) {
                    System.out.println("i ->" + currX1 + "," + currY1);
                    System.out.println("j->" + currX2 + "," + currY2);
                    System.out.println("diff-->" + diffY + "," + diffX);
                    System.out.println();
                }
                if (hm.containsKey(tan)) {
                    int val = hm.get(tan);
                    val++;
                    if (max < val) {
                        max = val;
                    }
                    hm.put(tan, val);
                    break;
                } else {
                    hm.put(tan, 1);
                }
            }
        }
        if (max == Integer.MIN_VALUE) {
            return 2;
        }
        return max;
    }

    public static String slopeCoPrime(int deltaY, int deltaX) {
        StringBuilder str = new StringBuilder();
        if (deltaX == 0) {
            str.append(0);
            str.append("+");
            str.append(0);
            return new String(str);
        }
        // else if (deltaY == 0) {
        // str.append(Integer.MAX_VALUE);
        // str.append("+");
        // str.append(Integer.MAX_VALUE);
        // return new String(str);
        // }
        // else if (deltaX < 0) {
        // deltaX = -deltaX;
        // deltaY = -deltaY;
        // }
        // Integer gcd = gcd(Math.abs(deltaX), Math.abs(deltaY));
        Integer gcd = gcd(deltaX, deltaY);
        deltaX = deltaX / gcd;
        deltaY = deltaY / gcd;
        str.append(deltaY);
        str.append("+");
        str.append(deltaX);
        return new String(str);
    }

    public static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
