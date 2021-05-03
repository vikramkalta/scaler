import java.util.ArrayList;

public class GridUniquePath {
    public static void main(String args[]) {
        System.out.println(gridUniquePath(3, 7));
    }

    public static int gridUniquePath(int A, int B) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < A; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < B; j++) {
                arr.add(0);
            }
            matrix.add(arr);
        }

        for (int i = 0; i < A; i++) {
            matrix.get(i).set(B - 1, 1);
        }
        for (int i = 0; i < B; i++) {
            matrix.get(A - 1).set(i, 1);
        }

        for (int i = A - 2; i >= 0; i--) {
            for (int j = B - 2; j >= 0; j--) {
                int right = matrix.get(i).get(j + 1);
                int bottom = matrix.get(i + 1).get(j);
                matrix.get(i).set(j, right + bottom);
            }
        }

        return matrix.get(0).get(0);
    }
}
