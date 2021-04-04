import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// 1 2 3 4 5
// 5 4 3 2 1
// 4 5 1 2 3
public class RotateArray {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            int arrLen = scanner.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < arrLen; j++) {
                int curr = scanner.nextInt();
                arr.add(curr);
            }
            int rotationCount = scanner.nextInt();

            ArrayList<Integer> resultArr = new ArrayList<>();
            for (int j = 0; j < arrLen; j++) {
                resultArr.add(arr.get(j));
            }
            
            for (int j = arrLen - 1; j >= 0; j--) {
                resultArr.set(arrLen - 1 - j, arr.get(j));
            }
            Collections.copy(arr, resultArr);

            int pos = rotationCount;
            for (int j = arrLen - 1; j >= rotationCount; j--) {
                resultArr.set(pos, arr.get(j));
                pos++;
            }
            pos = 0;
            for (int j = rotationCount - 1; j >= 0; j--) {
                resultArr.set(pos, arr.get(j));
                pos++;
            }
            
            for (int j = 0; j < arrLen; j++) {
                System.out.print(resultArr.get(j) + " ");
            }
            System.out.println("");

            // int rotatePos = arrLen - 1;
            // ArrayList<Integer> resultArr = new ArrayList<>();
            // // Collections.copy(resultArr, arr);
            // for (int j = 0; j < arrLen; j++) {
            //     resultArr.add(arr.get(j));
            // }
            
            // for (int j = arrLen - 1; j >= 0; j--) {
            //     resultArr.set(arrLen - 1 - j, arr.get(j));
            // }
            // Collections.copy(arr, resultArr);
            // // Length of array to rotate.
            // int splitArrayLen = arrLen - rotationCount;
            // for (int j = splitArrayLen - 1; j >= 0; j--) {
            //     resultArr.set(splitArrayLen - 1 - j, arr.get(j));
            // }
            // int pos = splitArrayLen;
            // for (int j = arrLen - 1; j >= splitArrayLen; j--) {
            //     resultArr.set(pos, arr.get(j));
            //     pos++;
            // }
            // // while (rotationCount > 0) {
            // //     int elementToRotate = arr.get(rotatePos);
            // //     for (int j = 0; j < arrLen - 1; j++) {
            // //         int toMove = arr.get(j);
            // //         // System.out.println("toMove " + toMove);
            // //         int indexToMove = j + 1;
            // //         // System.out.println("indexToMove " + indexToMove);
            // //         resultArr.set(indexToMove, toMove);
            // //         // resultArr.add(indexToMove, toMove);
            // //     }
            // //     resultArr.set(pos, elementToRotate);

            // //     // for (int j = 0; j < arrLen; j++) {
            // //     // arr.set(j, resultArr.get(j));
            // //     // }
            // //     Collections.copy(arr, resultArr);
            // //     rotationCount--;
            // // }

            // for (int j = 0; j < arrLen; j++) {
            //     System.out.print(resultArr.get(j) + " ");
            // }
            // System.out.println("");
        }

    }

}