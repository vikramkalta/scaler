import java.util.ArrayList;

public class PascalTriangle {
    public static void main(String args[]) {
        System.out.println(pascalTriangle(0));
    }

    public static ArrayList<ArrayList<Integer>> pascalTriangle(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (A == 0) {
            return result;
        }

        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        for (int i = 1; i < A; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int sum = 0;
                if (j - 1 < 0) {
                    sum = 1;
                } else if (j >= i) {
                    sum = 1;
                } else {
                    int curr = result.get(i - 1).get(j - 1);
                    int next = result.get(i - 1).get(j);
                    sum = curr + next;
                }
                arr.add(sum);
            }
            result.add(arr);
        }

        return result;
    }
}