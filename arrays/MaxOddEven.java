import java.util.ArrayList;

public class MaxOddEven {
    public static void main(String args[]) {
        ArrayList<Integer> a = new ArrayList<>();
        // [ 12, 10, 28, 37, 43, 40, 14, 12, 48 ]
        // int b[] = {12, 10, 28, 37, 43, 40, 14, 12, 48};
        int b[] ={16, 19, 13, 43, 21, 47, 20};
        for (int i = 0; i < b.length; i++) {
            a.add(b[i]);
        }
        System.out.println(maxLength(a));
    }

    public static int maxLength(ArrayList<Integer> A) {
        int len = A.size();

        ArrayList<Integer> result = new ArrayList<>();
        result.add(A.get(0));
        int resultLen = 1;

        for (int i = 0; i < len; i++) {
            int el = A.get(i);
            int resultEl = result.get(resultLen - 1);
            if ((int)(resultEl & 1) == 1 && (int)(el & 1) == 0) {
                result.add(A.get(i));
            }
            if ((int)(resultEl & 1) == 0 && (int)(el & 1) == 1) {
                result.add(A.get(i));
            }
            resultLen = result.size();
        }
        return resultLen;
    }
}
