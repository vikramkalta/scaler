import java.util.ArrayList;

public class FindTwoNonRepeating {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 3, 1, 2, 4 };
        // int[] arr = { 0, 4, 7, 9 };
        int[] arr = { 186, 256, 102, 377, 186, 377 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        System.out.println(solve(A));
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        int len = A.size();
        int xor = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            xor ^= curr;
        }
        int x = 0, y = 0;
        int setBit = 0;
        int _xor = xor;
        while (_xor > 0) {
            if ((_xor & 1) == 1) {
                break;
            }
            setBit++;
            _xor >>= 1;
        }
        // _xor = xor;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            int newXor = xor >> setBit;
            int _curr = curr >> setBit;
            if ((newXor & 1) == 1 && (_curr & 1) == 1) {
                x = x ^ curr;
            } else {
                y = y ^ curr;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (x > y) {
            result.add(y);
            result.add(x);
        } else {
            result.add(x);
            result.add(y);
        }
        return result;
    }
}
