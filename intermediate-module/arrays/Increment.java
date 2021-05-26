import java.util.ArrayList;

public class Increment {
    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        // int number[] = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        // int number[] = {1, 9, 9, 9, 9, 9, 9};
        int number[] = {0, 0, 4, 4, 6, 0, 9, 6, 5, 1};
        // int number[] = {1,2,9};
        for (int i = 0; i < number.length; i++) {
            arr.add(number[i]);
        }
        
        System.out.println(increment(arr));
    }

    public static ArrayList<Integer> increment(ArrayList<Integer> A) {
        int len = A.size();
        ArrayList<Integer> result = new ArrayList<>();

        boolean isLast9 = false;
        for (int i = len - 1; i >= 0; i--) {
            int curr = A.get(i);

            if (isLast9 && curr == 9) {
                A.set(i, 0);
            }
            if (isLast9 && curr != 9) {
                A.set(i, curr + 1);
                isLast9 = false;
                break;
            }

            if (curr != 9) {
                A.set(i, curr + 1);
                break;
            } else {
                A.set(i, 0);
                isLast9 = true;
            }
        }

        if (isLast9) {
            result.add(1);
            for (int i = 0; i < len; i++) {
                result.add(A.get(i));
            }
            return result;
        }

        boolean isNot0 = false;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (curr != 0) {
                isNot0 = true;
            }
            if (isNot0) {
                result.add(curr);
            }
        }

        return result;





        // String str = new String();
        // for (int i = 0; i < len; i++) {
        //     str += A.get(i);
        // }
        // Long number = Long.parseLong(str);
        // number++;
        // String resultStr = String.valueOf(number);
        // int resultLen = resultStr.length();
        // for (int i= 0; i < resultLen; i++) {
        //     int digit = Character.getNumericValue(resultStr.charAt(i));
        //     result.add(digit);
        // }
        // return result;
        // if (arr.get(0) == 0) {
        //     for (int i = 1; i < len; i++) {
        //         result.add(arr.get(i));
        //     }
        // }
        // int last = result.get(len - 1);
        // if (last != 9) {
        //     result.set(len - 1, last + 1);
        //     return result;
        // }
        // boolean isLast9 = false;
        // // 999
        // for (int i = len - 1; i >= 0; i--) {
        //     int curr = result.get(i);
        //     if (isLast9) {
        //         result.set(i, curr + 1);
        //     }
        //     if (curr == 9) {
        //         isLast9 = true;
        //         result.set(i, 0);
        //     }
        // }
        // return result;
    }
}
