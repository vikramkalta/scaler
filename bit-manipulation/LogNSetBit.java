public class LogNSetBit {
    public static void main(String args[]) {
        System.out.println(getSetBits(3));
    }

    public static int getSetBits(int A) {
        int rows= getTotalBits(A);

        for (int i = rows - 1; i >= 0; i--) {
            int power = 0;
            while (power < A) {
                power = power << 1;
            }
        }
    }
    






    // public static int getSetBits(int A) {
    //     int i = 0;
    //     int result = 0;
    //     System.out.print(1<<i);
    //     while ((1 << i) <= A) {
    //         boolean k = false;

    //         int change = 1 << i;

    //         for (int j = 0; j <= A; j++) {
    //             if (k == true) {
    //                 result+=1;
    //             } else {
    //                 result+=0;
    //             }
    //             if (change == 1) {
    //                 k = !k;
    //                 change = 1 << i;
    //             } else {
    //                 change--;
    //             }
    //         }
    //         i++;
    //     }

    //     return result;
    // }

    public static int getTotalBits(int A) {
        int count = 0;
        while (A > 0) {
            count++;
            A>>=1;
        }
        return count;
    }
}
