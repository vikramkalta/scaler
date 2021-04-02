import java.util.ArrayList;

public class Pattern {
    public static void main(String args[]) {
        int n = 2;
        System.out.println("x : " + getPattern(n));
    }
    
    public static ArrayList<ArrayList<Integer>> getPattern(int A) {
        ArrayList<Integer> innerArr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < A; i++) {
            innerArr.add(i + 1);
            if (innerArr.size() == i + 1) {
                ArrayList<Integer> copyInnerArr = (ArrayList<Integer>) innerArr.clone();
                result.add(copyInnerArr);
                // result.add(innerArr);
                // innerArr.clear();
            }
        }

        return result;
    }
}
