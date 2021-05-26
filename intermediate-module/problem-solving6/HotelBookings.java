import java.util.ArrayList;

public class HotelBookings {
    public static void main(String args[]) {
        int[] arr = {1,5,9,10,16};
        // int[] arr = { 1, 3, 5 };
        // int[] arr = {1, 2, 3, 4};
        // int[] arr = {1, 2, 3};
        // int[] arr = {13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8};
        // int[] arr = {9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46, 15, 33, 47, 47, 10, 11, 27};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            A.add(arr[i]);
        ArrayList<Integer> B = new ArrayList<>();
        int[] arr1 = { 15,8,10,30,20 };
        // int[] arr1 = { 2, 6, 8 };
        // int[] arr1 = { 10, 2, 6, 14 };
        // int[] arr1 = { 2, 3, 4};
        // int[] arr1 = {28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53};
        // int[] arr1 = {32, 82, 39, 86, 81, 58, 64, 53, 40, 76, 40, 46, 63, 88, 56, 52, 50, 72, 22, 19, 38};
        for (int i = 0; i < arr1.length; i++) {
            B.add(arr1[i]);
        }
        // System.out.println(hotelBookingsPossible(A, B, 1));
        // System.out.println(hotelBookingsPossible(A, B, 1));
        System.out.println(hotelBookingsPossible(A, B, 2));
        // System.out.println(hotelBookingsPossible(A, B, 23));
    }

    public static boolean hotelBookingsPossible(ArrayList<Integer> arrive, ArrayList<Integer> depart, int k) {
        boolean isBookingPossible = true;
        int len = arrive.size();
        mergeSort(arrive, 0, len - 1);
        mergeSort(depart, 0, len - 1);

        ArrayList<Integer> stateList = new ArrayList<>();
        ArrayList<Integer> mergedList = new ArrayList<>();
        mergedList(arrive, depart, stateList, mergedList);
        // System.out.println(stateList);
        // System.out.println(mergedList);
        
        int bookingCount = 0;
        // 0 for arrival and 1 for departure.
        int stateListLen = stateList.size();
        for (int i = 0; i < stateListLen; i++) {
            int curr = stateList.get(i);
            if (curr == 0) {
                bookingCount++;
            } else {
                bookingCount--;
            }
            
            if (bookingCount > k) {
                isBookingPossible = false;
                break;
            }
        }
        return isBookingPossible;
    }

    private static void mergedList(ArrayList<Integer> arrive,ArrayList<Integer> depart,ArrayList<Integer> stateList,ArrayList<Integer>mergedList) {
        int i = 0, j = 0, len = arrive.size();

        while(i < len && j < len) {
            int currA = arrive.get(i);
            int currD=depart.get(j);
            if (currA <= currD) {
                mergedList.add(currA);
                stateList.add(0);
                i++;
            } else {
                mergedList.add(currD);
                stateList.add(1);
                j++;
            }
        }
        while(i < len) {
            mergedList.add(arrive.get(i));
            stateList.add(0);
            i++;
        }
        while(j < len){
            mergedList.add(depart.get(j));
            stateList.add(1);
            j++;
        }
    }

    public static void mergeSort(ArrayList<Integer> arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m+1, r);
        merge(arr,l,m,r);
    }
    private static ArrayList<Integer> merge(ArrayList<Integer> arr, int l, int m, int r) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = l; i <= m; i++){
            arr1.add(arr.get(i));
        }
        for (int i = m+1; i <=r;i++){
            arr2.add(arr.get(i));
        }
        int len1= m+1-l;
        int len2=r-m;
        int i = 0, j = 0, k = l;
        while(i < len1 && j < len2) {
            int curr1 = arr1.get(i);
            int curr2 = arr2.get(j);
            if (curr1 <= curr2) {
                arr.set(k, curr1);
                i++;
            } else {
                arr.set(k, curr2);
                j++;
            }
            k++;
        }
        while(i < len1) {
            arr.set(k, arr1.get(i));
            i++;
            k++;
        }
        while(j < len2) {
            arr.set(k, arr2.get(j));
            j++;
            k++;
        }
        return arr;
    }
}
