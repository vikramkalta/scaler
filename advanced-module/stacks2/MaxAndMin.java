import java.util.Stack;

public class MaxAndMin {
    public static void main(String[] args) {
        // int[] A = {4, 7, 3, 8};
        int[] A = {1,3,3};
        // -1,0,-1,2
        // 2,2,4,4
        // (0-(-1) * 2-0), (1-0)*(2-1), (2-(-1) * 4-2), (3-2)*(4-3)
        // 2,1,6,1 - Min count

        // -1,-1,1,-1
        // 1,3,3,4
        // (0-(-1) * 1-0), (1-(-1) * 3-1), (2-1 * 3-2), (3-(-1) * 4-3)
        // 1,4,1,4 - Max count

        // (4*1)-(4*2)=-4
        // (7*4)-(7*1)=21
        // (3*1)-(3*6)=-15
        // (8*4)-(8*1)=24
        // -----------=26
        // 4        -  0
        // 4,7      -  3
        // 4,7,3    -  4
        // 4,7,3,8  -  5
        // 7        -  0
        // 7,3      -  4
        // 7,3,8    -  5
        // 3        -  0
        // 3,8      -  5
        // 8        -  0
        //             26
        // {8,3,7,4}
        // -1,-1,1,1
        // 4,4,2,2

        // -1,0,-1,2
        // 2,2,4,4
        // (0-0)*(2-0), (1-0)*(2-1), (-1-2)*(4-2), (3-2)*(3-3) 

        // abs(0,1)+1, abs(1,1)+1, abs(0,3)+1, abs(3,3)+1
        // 2,1,3,1

        // 2,1,4,1 ----- 3 is 6 times min
        // 1,3,1,4 ----- 7 is 5 times max
        System.out.println(solve(A));
    }

    static int[] a;
    public static void findNextGreaterElement(int[] Next_greater_element, int n){
        // this function calculates next_greater element index
        Stack < Integer > s = new Stack < Integer > ();
        for (int i = 0; i < n; i++) Next_greater_element[i + 1] = n + 1;
        for (int i = 1; i <= n; i++) { 
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[s.peek()] <= a[i]) {
                    Next_greater_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }
    public static void findPreviousGreaterElement(int[] Previous_greater_element, int n){
        // this function calculates Previous_greater element index
        Stack < Integer > s = new Stack < Integer > ();
        for (int i = n; i > 0; i--) { 
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[i] > a[s.peek()]) {
                    Previous_greater_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }
    public static void findPreviousSmallerElement(int[] Previous_smaller_element, int n){
        // this function calculates Previous smaller element index
        Stack < Integer > s = new Stack < Integer > ();
        for (int i = n; i > 0; i--) { 
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[i] <= a[s.peek()]) {
                    Previous_smaller_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }
    public static void findNextSmallerElement(int[] Next_smaller_element, int n){
        // function function calculates Next smaller element index
        Stack < Integer > s = new Stack < Integer > ();
        for (int i = 0; i < n; i++) Next_smaller_element[i + 1] = n + 1;
        for (int i = 1; i <= n; i++) { 
            if (s.empty()) {
                s.push(i);
            } else {
                while (!s.empty() && a[i] < a[s.peek()]) {
                    Next_smaller_element[s.peek()] = i;
                    s.pop();
                }
                s.push(i);
            }
        }
    }
    
    public static int solve(int[] A) {
        int n = A.length, mod = 1000 * 1000 * 1000 + 7;
        a = new int[n + 1];
        int Next_greater_element[] = new int[n + 1];
        int Previous_greater_element[] = new int[n + 1];
        int Previous_smaller_element[] = new int[n + 1];
        int Next_smaller_element[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            a[i + 1] = A[i];
        }
        
        findNextGreaterElement(Next_greater_element, n);
        findPreviousGreaterElement(Previous_greater_element, n);
        findPreviousSmallerElement(Previous_smaller_element, n);
        findNextSmallerElement(Next_smaller_element, n);
       
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            long right = Next_greater_element[i] - i;
            long left = i - Previous_greater_element[i];
            ans += (((left * right) % mod) * a[i]) % mod;
            ans %= mod;
            left = i - Previous_smaller_element[i];
            right = Next_smaller_element[i] - i;
            ans -= (((left * right) % mod) * a[i]) % mod;
            ans += mod;
            ans %= mod;
        }
        return (int) ans;
    }

    public static int solve1(int[] A) {
        int len = A.length;
        int[] revArr = new int[len];
        for (int i = len-1; i>=0; i--) {
            revArr[len-i-1] = A[i];
        }
        int[] prevMin = new int[len];
        int[] nextMin = new int[len];
        getPrevMin(A, len, prevMin);
        getPrevMin(revArr, len, nextMin);
        for (int i = 0; i < len; i++) {
            int curr = nextMin[i];
            if (curr == -1) {
                nextMin[i] = len;
            } else {
                nextMin[i] = len - curr - 1;
            }
        }
        for (int i = 0; i < len/2; i++) {
            int temp = nextMin[i];
            nextMin[i] = nextMin[len-i-1];
            nextMin[len-i-1] = temp;
        }
        int[] minCount = new int[len];
        for (int i = 0; i < len; i++) {
            int x = i - prevMin[i];
            int y = nextMin[i] - i;
            int z = x*y;
            minCount[i] = z;
        }

        int[] prevMax = new int[len];
        int[] nextMax = new int[len];
        getPrevMax(A, len, prevMax);
        getPrevMax(revArr, len, nextMax);
        for (int i = 0; i < len; i++) {
            int curr = nextMax[i];
            if (curr == -1) {
                nextMax[i] = len;
            } else {
                nextMax[i] = len - curr - 1;
            }
        }
        for (int i = 0; i < len/2; i++) {
            int temp = nextMax[i];
            nextMax[i] = nextMax[len-i-1];
            nextMax[len-i-1] = temp;
        }

        int[] maxCount = new int[len];
        for (int i = 0; i < len; i++) {
            int x = i - prevMax[i];
            int y = nextMax[i] - i;
            int z = x*y;
            maxCount[i] = z;
        }

        long ans = 0l;
        long mod = 1000000007l;
        for (int i = 0; i < len; i++) {
            long a = A[i] * 1l;
            long x = ((minCount[i] * 1l) * a) % mod;
            if (x<0) {
                x+=mod;
            }
            long y = ((maxCount[i] * 1l) * a) % mod;
            if (y<0) {
                y+=mod;
            }
            long z = y - x;
            ans = (ans + z) % mod;
            if (ans<0) {
                ans += mod;
            }
        }

        return (int)ans;
    }
    public static void getPrevMin(int[] A, int len, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int curr = A[i];
            if (stack.empty()) {
                arr[i] = -1;
            } else {
                while (!stack.empty()) {
                    if ( A[stack.peek()] >= curr ) {
                        stack.pop();
                    } else {
                        arr[i] = stack.peek();
                        break;
                    }
                }
                if (stack.empty()) {
                    arr[i] = -1;
                }
            }
            stack.push(i);
        }
    }
    public static void getPrevMax(int[] A, int len, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int curr = A[i];
            if (stack.empty()) {
                arr[i] = -1;
            } else {
                while(!stack.empty()) {
                    if ( A[stack.peek()] < curr ) {
                        stack.pop();
                    } else {
                        arr[i] = stack.peek();
                        break;
                    }
                }
                if (stack.empty()) {
                    arr[i] = -1;
                }
            }
            stack.push(i);
        }
    }
}
