import java.util.ArrayList;

public class FindDuplicateRows {
    public static void main(String args[]) {
        // String keys[] = {"the", "a", "there"};
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        int[][] arr = { { 0,1,0 }, { 1,0,1 }, { 1,1,1 }, {0,1,0} };
        for (int i = 0; i < arr.length; i++) {
            int[] currArr = arr[i];
            ArrayList<Integer> b = new ArrayList<>();
            for (int j = 0; j < currArr.length; j++) {
                b.add(currArr[j]);
            }
            A.add(b);
        }
        // new FindDuplicateRows().findDuplicateRows(A);
        System.out.println(new FindDuplicateRows().findDuplicateRows(A));
    }

    TrieNode root = new TrieNode();

    public int insert(ArrayList<Integer> A) {
        int len = A.size();

        TrieNode pCrawl = root;
        int duplicateFound = 0;
        
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (pCrawl.children[curr] == null) {
                pCrawl.children[curr] = new TrieNode();
            }
            pCrawl = pCrawl.children[curr];
            if (i == len - 1 && pCrawl.isEndOfArray) {
                duplicateFound = 1;
            }
        }
        pCrawl.isEndOfArray = true;
        return duplicateFound;
    }

    public ArrayList<Integer> findDuplicateRows(ArrayList<ArrayList<Integer>> A) {
        int rows = A.size();
        ArrayList<Integer> result = new ArrayList<>();


        for (int i = 0; i < rows; i++) {
            int duplicateIndex = insert(A.get(i));
            if (duplicateIndex != 0) {
                result.add(i+1);
            }
        }

        return result;
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[2];
    boolean isEndOfArray;

    TrieNode() {
        for (int i = 0; i < 2; i++) {
            children[i] = null;
        }
    }
}

