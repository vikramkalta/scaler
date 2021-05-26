import java.util.ArrayList;

public class LargestNumber {
    public static void main(String args[]) {
        // int[] arr = { 3, 30, 34, 5, 9 };
        int[] arr = {0, 0, 0, 0, 0};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(largestNumber(A));
    }

    public static String largestNumber(ArrayList<Integer> A) {
        int len = A.size();

        ArrayList<String> AStr = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            String currStr = String.valueOf(curr);
            AStr.add(currStr);
        }

        int max = 0;
        int maxIndex = 0;
        int modifiedIndex = -1;
        String modifiedStr = new String();

        for (int i = 0; i < len; i++) {
            String currStrI = AStr.get(i);
            char chI = currStrI.charAt(0);
            int currI = Character.getNumericValue(chI);
            max = currI;
            maxIndex = i;

            for (int j = i; j < len; j++) {
                String currStrJ = AStr.get(j);
                char chJ = currStrJ.charAt(0);
                int currJ = Character.getNumericValue(chJ);

                if (max == currJ) {
                    int parsedVal = Integer.parseInt(currStrJ);
                    String prevMaxStr = AStr.get(maxIndex);
                    int prevMax = Integer.parseInt(prevMaxStr);

                    int lastVal = Character.getNumericValue(currStrJ.charAt(currStrJ.length() - 1));

                    if (!currStrJ.equals("0") && lastVal == 0 && prevMaxStr.length() == 1) {
                        max = currJ;
                        prevMaxStr += "1";
                        modifiedIndex = maxIndex;
                        modifiedStr = prevMaxStr;
                        AStr.set(maxIndex, prevMaxStr);
                    } else {
                        if (parsedVal > prevMax) {
                            max = currJ;
                            maxIndex = j;
                        }
                    }
                }

                if (max < currJ) {
                    max = currJ;
                    maxIndex = j;
                }

            }

            String temp = AStr.get(i);
            AStr.set(i, AStr.get(maxIndex));
            AStr.set(maxIndex, temp);
        }

        StringBuilder sb = new StringBuilder();
        boolean isZero = true;
        for (int i = 0; i < len; i++) {
            String curr = AStr.get(i);

            if (!curr.equals("0")) {
                isZero = false;
            }

            if (modifiedStr == curr) {
                curr = curr.substring(0, curr.length() - 1);
            }
            if (!isZero) {
                sb.append(curr);
            }
            if(i == len-1 && isZero){
                sb.append(curr);
            }
        }

        String result = new String(sb);
        return result;
    }
}
