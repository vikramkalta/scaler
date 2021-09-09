import java.util.HashMap;

public class FirstNonRepeatingCharacter {
    public static void main(String args[]) {
        // System.out.println(solve("abcabc"));
        // System.out.println(solve("abadbc"));
        // System.out.println(solve("iergxwhddh"));
        System.out.println(solve("jyhrcwuengcbnuchctluxjgtxqtfvrebveewgasluuwooupcyxwgl"));
        // jyhrcyjht
        // jjjjjjht#
    }

    public static String solve(String A) {
        int len = A.length();

        StringBuilder B = new StringBuilder();
        HashMap<Character, Boolean> hm = new HashMap<>();
        Queue4 q = new Queue4(len);
        Queue4 q1 = new Queue4(len);
        
        for (int i = 0; i < len; i++) {
            char curr = A.charAt(i);
            if (!hm.containsKey(curr)) {
                if (!q.isFull()) {
                    q.enqueue(curr);
                }
                hm.put(curr, true);
            }
        }
        char x = q.dequeue();
        B.append(x);
        for (int i = 1; i < len; i++) {
            char curr = A.charAt(i);
            if (x == curr) {
                if (q.isEmpty()) {
                    x = '#';
                }else{
                    x = q.dequeue();
                }
            }
            B.append(x);
        }

        return new String(B);
    }

    public static String solve1(String A) {
        int len = A.length();

        StringBuilder B = new StringBuilder();
        HashMap<Character, Boolean> hm = new HashMap<>();
        Queue4 q = new Queue4(len);

        for (int i = 0; i < len; i++) {
            char curr = A.charAt(i);
            if (!hm.containsKey(curr)) {
                if (!q.isFull()) {
                    q.enqueue(curr);
                }
                hm.put(curr, true);
            }
        }
        char x = q.dequeue();
        B.append(x);
        for (int i = 1; i < len; i++) {
            char curr = A.charAt(i);
            if (x == curr) {
                if (q.isEmpty()) {
                    x = '#';
                }else{
                    x = q.dequeue();
                }
            }
            B.append(x);
        }

        return new String(B);
    }
}

class Queue4 {
    int size;
    char[] queue;
    int front = 0;
    int rear = -1;
    int currentSize = 0;

    Queue4(int n) {
        queue = new char[n];
        size = n;
    }

    public void enqueue(char c) {
        if (isFull()) {
            System.exit(1);
        }
        rear = (rear + 1) % size;
        currentSize++;
        queue[rear] = c;
    }

    public char dequeue() {
        if (isEmpty()) {
            System.exit(1);
        }
        char temp = queue[front];
        front = (front + 1) % size;
        currentSize--;
        return temp;
    }

    public char isPeek() {
        return queue[front];
    }

    public boolean isFull() {
        return size == currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }
}