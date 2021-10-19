import java.util.ArrayList;

public class UniqueGridPaths {
    public static void main(String args[]) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        // for (int i = 0; i < 3; i++) {
        //     ArrayList<Integer> innerArr = new ArrayList<>();
        //     for (int j = 0; j < 3; j++) {
        //         if (i == 1 && j == 1) {
        //             innerArr.add(1);
        //         } else {
        //             innerArr.add(0);
        //         }
        //     }
        //     A.add(innerArr);
        // }
        for (int i = 0; i < 1; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                if (i == 0 && j == 1) {
                    innerArr.add(1);
                } else {
                    innerArr.add(0);
                }
            }
            A.add(innerArr);
        }
        System.out.println(solve(A));
    }
    public static int solve(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        int cols = A.get(0).size();
        if (rows == 0) return 0;
        if (A.get(0).get(0) == 1) {
            return 0;
        } else {
            A.get(0).set(0, 1);
        }

        for (int i = 1; i < cols; i++) {
            int curr = A.get(0).get(i);
            if (curr == 1) {
                A.get(0).set(i, 0);
            } else {
                int prev = A.get(0).get(i-1);
                A.get(0).set(i, prev);
            }
        }
        for (int i = 1; i < rows; i++) {
            int curr = A.get(i).get(0);
            if (curr == 1) {
                A.get(i).set(0, 0);
            } else {
                int prev = A.get(i-1).get(0);
                A.get(i).set(0, prev);
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int curr = A.get(i).get(j);
                if (curr == 1) {
                    A.get(i).set(j, 0);
                } else {
                    int pathsUp = A.get(i-1).get(j);
                    int pathsLeft = A.get(i).get(j - 1);
                    int paths = pathsUp + pathsLeft;
                    A.get(i).set(j, paths);
                }
            }
        }

        return A.get(rows-1).get(cols-1);
    }
}
