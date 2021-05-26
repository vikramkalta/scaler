import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindEqual {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 7, 1, 2, 9, 8 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(equal(A));
    }

    public static ArrayList<Integer> equal(ArrayList<Integer> A) {
        int len = A.size();

        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int currI = A.get(i);
            for (int j = i + 1; j < len; j++) {
                int currJ = A.get(j);
                int sum = currI + currJ;

                boolean contains = hm.containsKey(sum);
                if (contains) {
                    ArrayList<Integer> hashVal = hm.get(sum);
                    boolean isValid = true;
                    for (int k = 0; k < hashVal.size(); k++) {
                        int currK = hashVal.get(k);
                        if (i == currK || j == currK) {
                            isValid = false;
                        }
                    }
                    if (isValid) {
                        hashVal.add(i);
                        hashVal.add(j);
                    }
                } else {
                    ArrayList<Integer> hashVal = new ArrayList<>();
                    hashVal.add(i);
                    hashVal.add(j);
                    hm.put(sum, hashVal);
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        int _minI = len;
        int _minJ = len;
        int _minK = len;
        int _minL = len;
        for (Map.Entry m : hm.entrySet()) {
            // System.out.println(m.getKey() + " : " + m.getValue());
            ArrayList<Integer> hashVal = (ArrayList) m.getValue();
            if (hashVal.size() >= 4) {
                for (int i = 0; i < 4; i++) {
                    
                    int currI = hashVal.get(0);
                    int currJ = hashVal.get(1);
                    int currK = hashVal.get(2);
                    int currL = hashVal.get(3);

                    if (_minI > currI) {
                        result.add(currI);
                        result.add(currJ);
                        result.add(currK);
                        result.add(currL);
                        _minI = currI;
                    }
                    if (_minI == currI && _minJ > currJ) {
                        result.clear();
                        result.add(currI);
                        result.add(currJ);
                        result.add(currK);
                        result.add(currL);
                        _minJ = currJ;
                    }
                    if (_minI == currI && _minJ == currJ && _minK > currK) {
                        result.clear();
                        result.add(currI);
                        result.add(currJ);
                        result.add(currK);
                        result.add(currL);
                        _minK = currK;
                    }
                    if (_minI == currI && _minJ == currJ && _minK == currK && _minL > currL) {
                        result.clear();
                        result.add(currI);
                        result.add(currJ);
                        result.add(currK);
                        result.add(currL);
                        _minK = currL;
                    }
                }
            }
        }
        return result;

    }
}
