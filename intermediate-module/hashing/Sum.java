import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sum {
    public static void main(String args[]) {
        // Integer arr[] = {2, 7, 11, 15};
        // Integer arr[] = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9,
        //         -4, 4, -8 };
        // Integer arr[]= {-10, -10, -10};
        Integer arr[] = {1, 1, 1};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // System.out.println(sum(A, -3));
        // System.out.println(sum(A, 9));
        // System.out.println(sum(A, -5));
        System.out.println(sum(A, 2));
    }

    public static ArrayList<Integer> sum(ArrayList<Integer> A, int B) {
        int len = A.size();

        ArrayList<Integer> result = new ArrayList<>();

        HashMap<String, ArrayList<Integer>> sum = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int currI = A.get(i);
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = i; j < len; j++) {
                int currJ = A.get(j);
                if (currI + currJ == B && i != j) {
                    int i1 = i + 1;
                    int j1 = j + 1;
                    arr.add(i1);
                    arr.add(j1);
                    String key = i1 + "" + j1;
                    ArrayList<Integer> cloneArr = new ArrayList<>();
                    cloneArr = (ArrayList) arr.clone();
                    sum.put(key, cloneArr);
                    arr.clear();

                }
            }
        }

        int minIndex2 = Integer.MAX_VALUE;
        int minIndex1 = Integer.MIN_VALUE;
        String key = new String();
        for (Map.Entry m : sum.entrySet()) {
            ArrayList<Integer> arr = (ArrayList) m.getValue();
            System.out.println(m.getKey() + " : " + m.getValue());
            int index1 = arr.get(1);
            int index0 = arr.get(0);

            if (minIndex2 == index1 && minIndex1 > index0) {
                minIndex2 = index1;
                minIndex1 = index0;
                key = (String) m.getKey();
            }

            if (minIndex2 > index1) {
                minIndex2 = index1;
                minIndex1 = index0;
                key = (String) m.getKey();
            }

        }
        boolean isEmpty = key.isEmpty();
        if (!isEmpty) {
            result = sum.get(key);
        }
            
        return result;
    }
}
