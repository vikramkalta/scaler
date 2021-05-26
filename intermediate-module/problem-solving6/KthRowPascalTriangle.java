import java.util.ArrayList;
import java.util.Collections;

public class KthRowPascalTriangle {
    public static void main(String args[]) {
        System.out.println(kthRow(1));
    }

    public static ArrayList<Integer> kthRow(int A) {
        ArrayList<Integer> prev= new ArrayList<>();
        prev.add(1);
        if (A == 0) {
            return prev;
        }
        if (A == 1) {
            prev.add(1);
            return prev;
        }
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i < A; i++) {
            ArrayList<Integer> pascal = new ArrayList<>();
            pascal.add(1);
            for (int j = 1; j < i + 1; j++) {
                int firstNumToAdd = 1;
                if (prev.size() > 1) {
                    firstNumToAdd = prev.get(j);
                }
                int numToAdd = firstNumToAdd + prev.get(j - 1);
                pascal.add(numToAdd);
            }
            if (i == A-1) {
                for (int k = 0, pLen = pascal.size(); k < pLen; k++) {
                    result.add(pascal.get(k));
                }
                result.add(1);
            } else {
                prev.clear();
                for (int k = 0, pLen = pascal.size(); k < pLen; k++) {
                    prev.add(pascal.get(k));
                }
                prev.add(1);
            }
        }
        return result;
    }
}
