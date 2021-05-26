import java.util.ArrayList;
import java.util.Collections;

public class ConstructArray {
    public static void main(String args[]) {
        // System.out.println(constructArr(5, 20, 50));
        // System.out.println(constructArr(6, 2, 18));
        System.out.println(constructArr(7, 39, 41));
    }

    public static ArrayList<Integer> constructArr(int A, int B, int C) {
        int diff = C - B;

        ArrayList<Integer> factors = new ArrayList<>();
        
        for (int i = 1; i * i <= diff; i++) {
            if (diff % i == 0) {
                int otherFactor = diff / i;
                factors.add(i);
                factors.add(otherFactor);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int fLen = factors.size();
        int minPerArr = Integer.MAX_VALUE;
        int resultFactor = 0;
        for (int i = 0; i < fLen; i++) {
            int curr = factors.get(i);
            if (diff / curr < A) {
                int max = 0;
                for (int j = 0; j < A; j++) {
                    int el = B + (curr * j);
                    if (el > C) {
                        int pos = A - j;
                        int x = pos * curr;
                        boolean isFront = B - x > 0;
                        if (isFront) {
                            el = B - x;
                        }
                    }
                    if (max < el) {
                        max = el;
                    }
                }
                if (minPerArr >= max) {
                    minPerArr = max;
                    resultFactor = curr;
                }
                max = 0;
            }
        }

        for (int i = 0; i < A; i++) {
            int el = B + (resultFactor * i);
            if (el > C) {
                int pos = A - i;
                int x = pos * resultFactor;
                boolean isFront = B - x > 0;
                if (isFront) {
                    el = B - x;
                }
            }
            result.add(el);
        }
        Collections.sort(result);
        return result;
    }
}
