import java.util.ArrayList;

public class PrintPattern {
    public static void main(String args[]) {
        System.out.println(printPattern(3));
    }

    public static ArrayList<ArrayList<Integer>> printPattern(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                arr.add(0);
            }
            result.add(arr);
        }

        for (int i = 0; i < A; i++) {
            for (int j = A - 1; j >= 0; j--) {
                // arr.add(A-j+1);
                if (i + 1 >= A - j) {
                    result.get(i).set(j, A - j);
                }

            }

        }

        return result;
    }
}
