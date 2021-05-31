import java.util.ArrayList;

public class RainWaterTrap {
    public static void main(String args[]) {
        int[] arr = { 2,3,0,1,0,2,1 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(rainWaterTrap(A));
    }

    public static int rainWaterTrap(ArrayList<Integer> A) {
        int len = A.size();
        int area = 0;

        ArrayList<Integer> prefix = new ArrayList<>();
        ArrayList<Integer> postfix = new ArrayList<>();

        int maxLeft = 0;
        int maxRight = 0;

        prefix.add(maxLeft);
        for (int i = 1; i < len; i++) {
            int curr = A.get(i-1);
            if (maxLeft < curr) {
                maxLeft = curr;
            }
            prefix.add(maxLeft);
        }

        postfix.add(maxRight);
        for (int i = len - 2; i >= 0; i--) {
            int curr = A.get(i+1);
            if (maxRight < curr) {
                maxRight = curr;
            }
            postfix.add(maxRight);
        }

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            int maxLeftCurr = prefix.get(i);
            int maxRightCurr = postfix.get(len - 1 - i);
            int min = getMin(maxLeftCurr, maxRightCurr);
            int trappedArea = min - curr;
            area += trappedArea < 0 ? 0 : trappedArea;
        }

        return area;
    }

    private static int getMin(int A, int B) {
        if (A < B) {
            return A;
        } else {
            return B;
        }
    }
}
