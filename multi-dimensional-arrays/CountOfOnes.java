import java.util.ArrayList;

public class CountOfOnes {
    public static void main(String args[]) {
        // int arr[][] = { { 0, 1, 1 }, { 0, 0, 1 }, { 0, 1, 1 }, };
        int arr[][] = { 
            { 0, 0, 1, 1, 1 },
            { 0, 0, 0, 1, 1 },
            { 0, 0, 0, 1, 1 },
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 1}
        };

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> iA = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                iA.add(arr[i][j]);
            }
            A.add(iA);
        }
        System.out.println(getCount(A));
    }

    public static int getCount(ArrayList<ArrayList<Integer>> A) {
        int len = A.size();

        int searchIndex = 0;
        int row = 0;

        ArrayList<Integer> firstArr = A.get(0);
        int firstArrLen = firstArr.size();

        for (int i = 0; i < firstArrLen; i++) {
            if (firstArr.get(i) == 1){
                // row = i;
                searchIndex = i;
                break;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = searchIndex - 1; j >= 0; j--) {
                int curr = A.get(i).get(j);
                if (curr == 0) {
                    break;
                } else {
                    row = i;
                    searchIndex = j;
                }
            }
        }

        // int ans = firstArrLen - searchIndex;
        // return ans;
        return row;
    }
}