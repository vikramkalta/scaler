import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sudoku {
    public static void main(String args[]) {
        String[] strArr = { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.",
                "...419..5", "....8..79" };
        List<String> A = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            A.add(strArr[i]);
        }
        System.out.println(sudoku(A));
    }

    public static int sudoku(List<String> A) {

        ArrayList<ArrayList<Integer>> _sudoku = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String str = A.get(i);

            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                char ch = str.charAt(j);
                int curr = Character.getNumericValue(ch);
                arr.add(curr);
            }
            ArrayList<Integer> copyArr = new ArrayList<>();// (ArrayList)arr.clone();
            copyArr = (ArrayList) arr.clone();
            _sudoku.add(copyArr);
            arr.clear();
        }

        boolean isValid = true;

        for (int i = 0; i < 9; i++) {
            HashMap<Integer, Boolean> horizontal = new HashMap<>();
            HashMap<Integer, Boolean> vertical = new HashMap<>();
            HashMap<Integer, Boolean> box = new HashMap<>();

            for (int j = 0; j < 9; j++) {

                int currH = _sudoku.get(i).get(j);

                if (currH != -1) {
                    boolean containsH = horizontal.containsKey(currH);
                    if (containsH) {
                        isValid = false;
                        break;
                    } else {
                        horizontal.put(currH, true);
                    }
                }

                int currV = _sudoku.get(j).get(i);

                if (currV != -1) {
                    boolean containsV = vertical.containsKey(currV);
                    if (containsV) {
                        isValid = false;
                        break;
                    } else {
                        vertical.put(currV, true);
                    }
                }

                int bI = (j / 3);
                int x = (i / 3);
                x = x * 3;
                bI = bI + x;
                int bJ = (j % 3) + (3 * i);
                bJ = bJ % 9;
                // System.out.println("i,j " + i + "," + j);
                // System.out.println(bI + " : " + bJ);
                int currB = _sudoku.get(bI).get(bJ);

                if (currB != -1) {
                    boolean containsB = box.containsKey(currB);
                    if (containsB) {
                        isValid = false;
                        break;
                    } else {
                        box.put(currB, true);
                    }
                }
            }

            if (!isValid) {
                break;
            }
        }

        if (isValid) {
            return 1;
        } else {
            return 0;
        }
    }
}