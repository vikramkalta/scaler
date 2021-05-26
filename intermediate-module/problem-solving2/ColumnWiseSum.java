import java.util.ArrayList;

public class ColumnWiseSum {
    public static void main(String args[]) {

    }

    public static ArrayList<Integer> columnWiseSum(ArrayList<ArrayList<Integer>> A) {
        int lenRow = A.size();
        int lenCol = A.get(0).size();

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < lenCol; i++) {
            int sum = 0;
            for (int j = 0; j < lenRow; j++) {
                int curr = A.get(j).get(i);
                sum += curr;
            }
            result.add(sum);
            sum = 0;
        }

        return result;
    }
}
