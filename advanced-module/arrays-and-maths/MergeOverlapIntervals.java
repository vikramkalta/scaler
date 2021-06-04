import java.util.ArrayList;

public class MergeOverlapIntervals {
    public static void main(String args[]) {
        // int[] arr = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6, 6, 6};
        // int[]arr = {27, 54, 33, 60, 79, 80, 22, 89, 21, 27, 39, 49, 41, 80, 83, 87, 4, 29, 44, 82, 72, 81, 20, 73};
        // int[] arr = {47, 76, 51, 99, 28, 78, 54, 94, 12, 72, 31, 72, 12, 55, 24, 40, 59, 79, 41, 100, 46, 99, 5, 27, 13, 23, 9, 69, 39, 75, 51, 53, 81, 98, 14, 14, 27, 89, 73, 78, 28, 35, 19, 30, 39, 87, 60, 94, 71, 90, 9, 44, 56, 79, 58, 70, 25, 76, 18, 46, 14, 96, 43, 95, 70, 77, 13, 59, 52, 91, 47, 56, 63, 67, 28, 39, 51, 92, 30, 66, 4, 4, 29, 92, 58, 90, 6, 20, 31, 93, 52, 75, 41, 41, 64, 89, 64, 66, 24, 90, 25, 46, 39, 49, 15, 99, 50, 99, 9, 34, 58, 96, 85, 86, 13, 68, 45, 57, 55, 56, 60, 74, 89, 98, 23, 79, 16, 59, 56, 57, 54, 85, 16, 29, 72, 86, 10, 45, 6, 25, 19, 55, 21, 21, 17, 83, 49, 86, 67, 84, 8, 48, 63, 85, 5, 31, 43, 48, 57, 62, 22, 68, 48, 92, 36, 77, 27, 63, 39, 83, 38, 54, 31, 69, 36, 65, 52, 68};
        // 27,54|33,60|79,80|22,89|21,27|39,49|41,80|83,87|4,29|44,82|72,81|20,73
        // 4,29|20,73|21,27|22,89|27,54|33,60|39,49|41,80|44,82|72,81|79,80|83,87

        int[] arr ={4, 100, 48, 94, 16, 21, 58, 71, 36, 53, 49, 68, 18, 42, 37, 90, 68, 75, 6, 57, 25, 78, 58, 79, 18, 29, 69, 94, 5, 31, 10, 87, 21, 35, 1, 32, 7, 24, 17, 85, 30, 95, 5, 63, 1, 17, 67, 100, 53, 55, 30, 63, 7, 76, 33, 51, 62, 68, 78, 83, 12, 24, 31, 73, 64, 74, 33, 40, 51, 63, 17, 31, 14, 29, 9, 15, 39, 70, 13, 67, 27, 100, 10, 71, 18, 47, 48, 79, 70, 73, 44, 59, 68, 78, 24, 67, 32, 70, 29, 94, 45, 90, 10, 76, 12, 28, 31, 78, 9, 44, 29, 83, 21, 35, 46, 93, 66, 83, 21, 72, 29, 37, 6, 11, 56, 87, 10, 26, 11, 12, 15, 88, 3, 13, 56, 70, 40, 73, 25, 62, 63, 73, 47, 74, 8, 36 };
        // int[] arr = {65, 96, 1, 46, 54, 89, 79, 98, 11, 84, 27, 60, 31, 86, 19, 82, 4, 61, 54, 95, 12, 73, 72, 90, 32, 80, 65, 84, 92, 95, 56, 88, 35, 65, 50, 94, 57, 96, 29, 46, 22, 46, 3, 38, 33, 39, 58, 79, 17, 70, 1, 92, 6, 89, 22, 65, 23, 79, 28, 75, 15, 18, 21, 69, 7, 8, 35, 86, 9, 43, 2, 50, 17, 60, 45, 48, 4, 27, 81, 93, 46, 49, 7, 70, 24, 77, 22, 64, 1, 31, 13, 81, 24, 73, 17, 21, 81, 84, 21, 37, 50, 98, 3, 35, 5, 80, 18, 81, 97, 100, 46, 57, 74, 74, 60, 61, 17, 19, 47, 62, 11, 49, 64, 88, 65, 91, 16, 97, 22, 53, 33, 83, 71, 76, 30, 88, 14, 82, 16, 79, 21, 79, 3, 84, 56, 92, 5, 24, 4, 41, 23, 37, 3, 97, 22, 63, 16, 27, 1, 11, 17, 54, 36, 47, 41, 55, 31, 47, 61, 94, 6, 84, 93, 94};
        // int[] arr = { 54, 75, 56, 60, 61, 86, 22, 43, 56, 87, 32, 53, 14, 81, 64, 65, 9, 42, 12, 33, 22, 58, 84, 90, 27,
        //         59, 41, 48, 43, 47, 22, 29, 16, 23, 41, 72, 15, 87, 20, 59, 45, 84, 14, 77, 72, 93, 20, 58, 47, 53, 25,
        //         88, 5, 89, 34, 97, 14, 47 };
        // int[] arr = { 1, 2, 4, 6, 8, 12, 13, 16 };
        // int[] arr = {10, 12, 2, 4, 9, 11};
        // int[] arr = { 1, 3, 2, 6, 8, 10, 15, 18 };
        // int[] arr = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6, 6, 6};
        // int[] arr = {13, 71};
        ArrayList<Interval> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i += 2) {
            int currStart = arr[i];
            int currEnd = arr[i + 1];
            A.add(new Interval(currStart, currEnd));
        }
        System.out.println(merge(A));
    }

    public static ArrayList<Interval> merge(ArrayList<Interval> A) {
        int len = A.size();
        if (len == 0 || len ==1) return A; 

        mergeSort(A, 0, len - 1);

        ArrayList<Interval> result = new ArrayList<>();
        // 27,54|33,60|79,80|22,89|21,27|39,49|41,80|83,87|4,29|44,82|72,81|20,73
        // 4,29|20,73|21,27|22,89|27,54|33,60|39,49|41,80|44,82|72,81|79,80|83,87
        int firstEnd = A.get(0).end;
        result.add(new Interval(A.get(0).start, firstEnd));
        int prevIndex = 0;
        for (int i = 1; i < len; i++) {
            Interval interval = A.get(i);
            int start = interval.start;
            int end = interval.end;
            if (end >= firstEnd && start <= firstEnd) {
                result.set(prevIndex, new Interval(A.get(prevIndex).start, end));
                firstEnd = end;
            }
            if (firstEnd < start) {
                result.add(new Interval(start, end));
                firstEnd = end;
                prevIndex = result.size() - 1;
            }
        }

        return result;
    }

    public static void mergeSort(ArrayList<Interval> arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    private static void merge(ArrayList<Interval> arr, int l, int m, int r) {
        ArrayList<Interval> arr1 = new ArrayList<>();
        ArrayList<Interval> arr2 = new ArrayList<>();
        for (int i = l; i <= m; i++) {
            arr1.add(arr.get(i));
        }
        for (int i = m + 1; i <= r; i++) {
            arr2.add(arr.get(i));
        }
        int len1 = arr1.size();
        int len2 = arr2.size();

        int i = 0, j = 0, k = l;
        while (i < len1 && j < len2) {
            int arr1Start = arr1.get(i).start;
            int arr2Start = arr2.get(j).start;
            if (arr1Start <= arr2Start) {
                arr.set(k, arr1.get(i));
                i++;
            } else {
                arr.set(k, arr2.get(j));
                j++;
            }
            k++;
        }

        while (i < len1) {
            arr.set(k, arr1.get(i));
            i++;
            k++;
        }
        while (j < len2) {
            arr.set(k, arr2.get(j));
            j++;
            k++;
        }
    }

    public static ArrayList<Interval> merge1(ArrayList<Interval> A) {
        int len = A.size();

        ArrayList<Integer> intervals = new ArrayList<>();
        ArrayList<Integer> tracker = new ArrayList<>();
        // 0 for start, 1 for end;
        for (int i = 0; i < len; i++) {
            Interval interval = A.get(i);
            intervals.add(interval.start);
            tracker.add(0);
            intervals.add(interval.end);
            tracker.add(1);
        }
        int intervalLen = intervals.size();
        mergeSort(intervals, tracker, 0, intervalLen-1);

        ArrayList<Interval> result = new ArrayList<>();
        ArrayList<Integer> preResult = new ArrayList<>();

        preResult.add(intervals.get(0));
        int countZeroes = 0;
        int countOnes = 0;
        for (int i = 1; i < intervalLen-1; i++) {
            int curr = intervals.get(i);
            int track = tracker.get(i+1);
            int previous = intervals.get(i-1);
            if (track == 0) {
                countZeroes++;
            } else {
                countOnes++;
            }
            if (countZeroes == countOnes && track == 0) {
                preResult.add(previous);
                preResult.add(curr);
                countOnes = 0;
                countZeroes = 0;
            }
        }
        if (preResult.size() % 2 != 0){
            preResult.add(intervals.get(intervalLen-1));
        }

        int preResLen = preResult.size();
        for (int i = 0; i < preResLen; i+=2) {
            int curr = preResult.get(i);
            int next = preResult.get(i+1);
            result.add(new Interval(curr, next));
        }
        return result;
    }

    public static void mergeSort(ArrayList<Integer> arr, ArrayList<Integer> tracker, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l+r)/2;
        mergeSort(arr, tracker, l, m);
        mergeSort(arr, tracker, m+1, r);
        merge(arr, tracker, l, m, r);
    }

    private static void merge(ArrayList<Integer> arr, ArrayList<Integer> tracker, int l, int m, int r) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> tracker1 = new ArrayList<>();
        ArrayList<Integer> tracker2 = new ArrayList<>();
        for (int i = l; i <= m; i++) {
            arr1.add(arr.get(i));
            tracker1.add(tracker.get(i));
        }
        for (int i = m+1; i<=r;i++) {
            arr2.add(arr.get(i));
            tracker2.add(tracker.get(i));
        }
        int len1 = arr1.size();
        int len2 = arr2.size();
        int i = 0, j = 0, k = l;
        
        while(i < len1 && j < len2) {
            int curr1 = arr1.get(i);
            int curr2 = arr2.get(j);
            if (curr1 <= curr2) {
                arr.set(k, curr1);
                tracker.set(k, tracker1.get(i));
                i++;
                k++;
            } else {
                arr.set(k, curr2);
                tracker.set(k, tracker2.get(j));
                j++;
                k++;
            }
        }
        while(i < len1) {
            arr.set(k, arr1.get(i));
            tracker.set(k, tracker1.get(i));
            i++;
            k++;
        }
        while(j < len2) {
            arr.set(k, arr2.get(j));
            tracker.set(k, tracker2.get(j));
            j++;
            k++;
        }
    }

}

// class Interval {
//     int start;
//     int end;
//     Interval() {
//         start = 0;
//         end = 0;
//     }
//     Interval(int s, int e) {
//         start = s;
//         end = e;
//     }
// }