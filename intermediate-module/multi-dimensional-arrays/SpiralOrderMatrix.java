import java.util.ArrayList;

public class SpiralOrderMatrix {
    public static void main(String args[]) {
        System.out.println(spiralOrderMatrix(4));
    }

    public static ArrayList<ArrayList<Integer>> spiralOrderMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < A; j++) {
                arr.add(0);
            }
            result.add(arr);
        }

        int R = 0;
        int B = A-1;
        int L = A-1;
        int T = 0;

        int count = 1;

        while (L >= R) {
            for (int i = T; i <= B; i++) {
                result.get(R).set(i, count);
                count++;
            }
            R++;
    
            for (int i = R; i <= L; i++) {
                result.get(i).set(B, count);
                count++;
            }
            B--;
    
            for (int i = B; i >= T; i--) {
                result.get(L).set(i, count);
                count++;
            }
            L--;
    
            for (int i = L; i >= R; i--) {
                result.get(i).set(T, count);
                count++;
            }
            T++;
        }

        return result;
    }
}
