import java.util.ArrayList;
import java.util.HashMap;

public class PairXor {
    public static void main(String args[]) {
        // int arr[] = { 17, 18, 8, 13, 15, 7, 11, 5, 4, 9, 12, 6, 10, 14, 16, 3 };
        int arr[] = {5, 4, 10, 15, 7, 6};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(pairXor(A, 5));
    }

    public static int pairXor(ArrayList<Integer> A, int B) {
        int len = A.size();

        HashMap<Integer, Boolean> pairXor = new HashMap<>();

        for (int i = 0; i <len; i++) {
            int curr = A.get(i);

            pairXor.put(curr, true);
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);

            int value = B ^ curr;

            boolean contains = pairXor.containsKey(value);
            
            if (contains) {
                boolean hashVal = pairXor.get(value);
                if (hashVal) {
                    count++;
                    pairXor.replace(value, false);
                    pairXor.replace(curr, false);
                }
            }
        }
        return count;
    }
}
