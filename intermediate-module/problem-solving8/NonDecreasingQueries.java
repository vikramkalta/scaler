import java.util.ArrayList;

public class NonDecreasingQueries {
    public static void main(String args[]) {}

    public static ArrayList<Integer> onDecreasingQueries(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B){
        int len = A.size();

        ArrayList<Integer> prefix = new ArrayList<>();
        prefix.add(0);
        for (int i = 0; i < len - 1; i++) {
            int curr = A.get(i);
            int next = A.get(i+1);
            int dig = 0;
            if (curr > next) {
                dig = 1;
            }
            prefix.add(dig);
        }
        int sum  = 0;
        for (int i = 0; i < len; i++) {
            int curr  = prefix.get(i);
            sum += curr;
            prefix.set(i, sum);
        }
        int rows = B.size();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            int startIndex = B.get(i).get(0) - 1;
            int endIndex = B.get(i).get(1) - 1;
            int prefStart = prefix.get(startIndex);
            int prefEnd = prefix.get(endIndex);
            if (prefEnd - prefStart == 0) {
                result.add(1);
            } else {
                result.add(0);
            }
        }
        return result;
    }
}
