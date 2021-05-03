public class MonkeysAndDoors {
    public static void main(String args[]) {
        System.out.println(monkeysAndDoors(100));
    }

    public static int monkeysAndDoors(int A) {
        int count = 0;
        for (int i = 1; i < A+1; i++) {
            if (Math.sqrt(i) % 1 == 0) {
                count++;
            }
        }
        // double i = A;
        // while(i > 0) {
        //     double sqrt = Math.sqrt(i);
        //     if (sqrt % 1 == 0) {
        //         count++;
        //     }
        //     i = sqrt;
        // }
        return count;
    }
}