import java.util.ArrayList;

public class BeggarsOutsideTemple {
    public static void main(String args[]) {
        // int[] a = {1,2,10};
        // int[] b = {2,3,20};
        // int[] c = {2,5,25};
        int[] merged = {1,2,10,2,3,20,2,5,25};
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> B = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                int currInc = (i * 3) + j;
                B.add(merged[currInc]);
            }
            A.add(B);
        }
        System.out.println(beggarsOutsideTemple(5, A));
    }

    public static ArrayList<Integer> beggarsOutsideTemple(int A, ArrayList<ArrayList<Integer>> B) {
        int len = B.size();

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            arr.add(0);
        }

        for (int i = 0; i < len; i++) {
            int iLen = B.get(i).size();
            ArrayList<Integer> curr = B.get(i);
            int coins = curr.get(iLen - 1);

            int initialIndex = curr.get(0);
            int finalIndex = curr.get(1);
            initialIndex = initialIndex - 1;
            finalIndex = finalIndex - 1;

            int iToUpdate = arr.get(initialIndex);
            iToUpdate = iToUpdate + coins;
            arr.set(initialIndex, iToUpdate);

            int jToUpdate = 0;
            if (finalIndex + 1 < A) {
                jToUpdate = arr.get(finalIndex + 1);
                jToUpdate = jToUpdate - coins;
                arr.set(finalIndex + 1, jToUpdate);
            }
        }

        ArrayList<Integer> prefixArr = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A; i++) {
            int curr = arr.get(i);
            sum = sum + curr;
            prefixArr.add(sum);
        }

        return prefixArr;
    }
}