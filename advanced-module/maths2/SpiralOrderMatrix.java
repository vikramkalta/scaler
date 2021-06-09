import java.util.ArrayList;

public class SpiralOrderMatrix {
    public static void main(String args[]) {
        System.out.println(solve(3));
    }

    public static ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> innerArr = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                innerArr.add(0);
            }
            arr.add(innerArr);
        }

        int L = 0, R = A, B = 0, T = A;
        int count = 1;
        while (L <= R) {
            
            for (int i = L; i < R; i++) {
                arr.get(B).set(i, count);
                count++;
            }
            B++;
            for (int i = B; i < T; i++) {
                arr.get(i).set(R-1, count);
                count++;
            }
            R--;
            for (int i = R-1; i >= L; i--) {
                arr.get(T-1).set(i, count);
                count++;
            }
            T--;
            for (int i = T-1; i >= B; i--) {
                arr.get(i).set(L, count);
                count++;
            }
            L++;
        }

        return arr;
    }
}
