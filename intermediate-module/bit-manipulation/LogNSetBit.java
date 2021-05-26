public class LogNSetBit {
    public static void main(String args[]) {
        System.out.println(getSetBits(31));
    }

    public static int getSetBits(int A) {
        long val1,val2,cnt;
        cnt = 0;
        for (int i = 1; i < 32; i++) {
            val1 = (int)((A+1)/Math.pow(2, i));
            val2 = (int)((A+1)%Math.pow(2, i));
            if (val2>Math.pow(2, i-1)) {
                val2 = val2 - (int)(Math.pow(2, i-1));
            } else {
                val2 = 0;
            }
                
            cnt = cnt + (int)(val1*Math.pow(2, i-1)) + val2;
        }
        return (int)(cnt%1000000007);
    }

    public static int getTotalBits(int A) {
        int count = 0;
        while (A > 0) {
            count++;
            A>>=1;
        }
        return count;
    }
}
