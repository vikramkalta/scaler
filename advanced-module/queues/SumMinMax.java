import java.util.ArrayDeque;
import java.util.Deque;

public class SumMinMax {
    public static void main(String[] args) {
        int[] A = { 2, 5, -1, 7, -3, -1, -2 };
        int B = 4;
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {
        int mod = 1000 * 1000 * 1000 + 7;
        // maintain increasing order of values from front to rear
        Deque < Integer > minn = new ArrayDeque < Integer > ();
        // maintain decreasing order of values from front to rear
        Deque < Integer > maxx = new ArrayDeque < Integer > ();
        int i = 0;
        
        // Process first window of size B
        for (; i < B; i++) {
            // Remove all previous greater elements that are useless.
            while (minn.size() > 0 && A[minn.getLast()] >= A[i]) {
                minn.removeLast();
            }
            // Remove all previous smaller that are elements are useless.
            while (maxx.size() > 0 && A[maxx.getLast()] <= A[i]) {
                maxx.removeLast();
            }
            // Add current element at rear of both deque
            minn.addLast(i);
            maxx.addLast(i);
        }
        long sum = A[minn.getFirst()] + A[maxx.getFirst()];
        
        while (i < A.length) {
            // remove all previous greater element that are useless
            while (minn.size() > 0 && A[minn.getLast()] >= A[i]) {
                minn.removeLast();
            }
            // remove all previous smaller that are elements are useless
            while (maxx.size() > 0 && A[maxx.getLast()] <= A[i]) {
                maxx.removeLast();
            }
            // Add current element at rear of both deque
            minn.addLast(i);
            maxx.addLast(i);
            // Remove all elements which are out of this window
            while (i - minn.getFirst() >= B) {
                minn.removeFirst();
            }
            while (i - maxx.getFirst() >= B) {
                maxx.removeFirst();
            }
            // Element at the front of the deque are the largest and smallest  element of previous window respectively
            sum += A[maxx.getFirst()] + A[minn.getFirst()];
            sum %= mod;
            i++;
        }
        sum += mod;
        sum %= mod;
        return (int) sum;
    }

    // public static int solve(int[] A, int B) {
    //     int len = A.length;
    //     LinkedList<Integer> queueMax = new LinkedList<>();
    //     long[] maxList = new long[len - B + 1];
    //     LinkedList<Integer> queueMin = new LinkedList<>();
    //     long[] minList = new long[len - B + 1];

    //     for (int i = 0; i < len; i++) {
    //         long curr = A[i] * 1l;
    //         while (!queueMax.isEmpty() && i - queueMax.peek() >= B) {
    //             queueMax.removeFirst();
    //         }
    //         if (queueMax.isEmpty()) {
    //             queueMax.addFirst(i);
    //         } else {
    //             while (!queueMax.isEmpty() && A[queueMax.peekLast()] < curr) {
    //                 queueMax.removeLast();
    //             }
    //             queueMax.addLast(i);
    //         }
            
    //         if (i >= B - 1) {
    //             maxList[i - B + 1] = A[queueMax.peekFirst()] * 1l;
    //         }
    //     }

    //     for (int i = 0; i < len; i++) {
    //         long curr = A[i] * 1l;
    //         while (!queueMin.isEmpty() && i - queueMin.peek() >= B) {
    //             queueMin.removeFirst();
    //         }
    //         if (queueMin.isEmpty()) {
    //             queueMin.addFirst(i);
    //         } else {
    //             while (!queueMin.isEmpty() && A[queueMin.peek()] > curr) {
    //                 queueMin.removeLast();
    //             }
    //             queueMin.addLast(i);
    //         }
    //         if (i>=B-1) {
    //             minList[i-B+1] = A[queueMin.peekFirst()] * 1l;
    //         }
    //     }
    //     long mod = 1000000007l;
    //     long ans = 0l;
    //     for (int i = 0; i < minList.length; i++) {
    //         ans = ans + (maxList[i] * 1l) + (minList[i] * 1l);
    //         ans = ans % mod;
    //         if (ans < 0) {
    //             ans += mod;
    //         }
    //     }
    //     if (ans < 0) {
    //         ans += mod;
    //     }
    //     return (int)ans;
    // }
}
