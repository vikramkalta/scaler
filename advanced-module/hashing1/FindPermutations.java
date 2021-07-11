import java.util.HashMap;

public class FindPermutations {
    public static void main(String args[]) {
        // System.out.println(solve("abc", "abcbacabc"));
        // System.out.println(solve("aca", "acaa"));
        // System.out.println(solve("aabc", "abdcbacabc"));
        // System.out.println(solve("eddq",
        // "boddooaedeeddpcdecpeeqooddaedoadddqdecbea"));
        // System.out.println(solve("eddq", "deeddpcdecpeeqooddaedoadddqdecbea"));
        System.out.println(solve("eddq",
                "acodeopbopdoeoqqddadoaabcapqobadpbeaboddooaedeeddpcdecpeeqooddaedoadddqdecbeapoqbbbdqbaqpccpa"));
    }

    public static int solve(String A, String B) {
        int patternLen = A.length();
        int strLen = B.length();

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < patternLen; i++) {
            char curr = A.charAt(i);
            if (hm.containsKey(curr)) {
                int val = hm.get(curr);
                val++;
                hm.put(curr, val);
            } else {
                hm.put(curr, 1);
            }
        }

        int count = 0;
        // "aabc", "abdcbacabc"
        Queue3 q = new Queue3(patternLen);
        for (int i = 0; i < strLen; i++) {
            char curr = B.charAt(i);

            if (hm.containsKey(curr)) {
                q.enqueue(curr);
                int val = hm.get(curr);
                val--;
                if (val < 0) {
                    while (q.lookup() != curr) {
                        char ch = q.lookup();
                        q.dequeue();
                        int val1 = hm.get(ch);
                        val1++;
                        hm.put(ch, val1);
                    }
                    q.dequeue();
                } else {
                    hm.put(curr, val);
                }

            } else {
                while (!q.isEmpty()) {
                    char ch = q.lookup();
                    int val = hm.get(ch);
                    val++;
                    hm.put(ch, val);
                    q.dequeue();
                }
            }

            if (q.isFull()) {
                char ch = q.lookup();
                q.dequeue();
                int val = hm.get(ch);
                val++;
                hm.put(ch, val);
                count++;
            }
        }

        return count;
    }
}

class Queue3 {
    char[] queue;
    int end = -1;
    int start = 0;
    int size = 0;
    int currentSize = 0;

    Queue3(int n) {
        queue = new char[n];
        size = n;
    }

    public void enqueue(char c) {
        if (isFull()) {
            System.out.println("Illegal operation");
            System.exit(0);
        }
        end++;
        end = end % size;
        queue[end] = c;
        currentSize++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Illegal operation");
            System.exit(0);
        }
        int temp = queue[start];
        start++;
        start = start % size;
        currentSize--;
        return temp;
    }

    public boolean isFull() {
        return currentSize == size;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public char lookup() {
        return queue[start];
    }

    public int getCurrentSize() {
        return currentSize;
    }
}