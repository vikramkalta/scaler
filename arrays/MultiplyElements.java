import java.util.ArrayList;

public class MultiplyElements {
    public static void main(String args[]) {
        int a[] = {1,2,3,4,5};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arr.add(a[i]);
        }
        System.out.println(multiply(arr));
    }

    public static ArrayList<Integer> multiply(ArrayList<Integer> A) {
        int len = A.size();

        if (len == 1) {
            return A;
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (i == 0) {
                int next = A.get(i+1);
                // A.set(i, curr*next);
                result.add(curr*next);
            } else if (i == len - 1) {
                int prev= A.get(i-1);
                // A.set(i, curr*prev);
                result.add(curr*prev);
            } else {
                int prev = A.get(i-1);
                int next = A.get(i+1);
                // A.set(i, next*prev);
                result.add(next*prev);
            }
        }
        return result;
    }
}
