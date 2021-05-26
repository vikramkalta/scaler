import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMax {
    public static void main(String args[]) {
        // int[] arr = {1, 3, -1, -3, 5, 3, 6, 7}; // 3,3,5,5,6,7
        // int[] arr = { 3, 1, -1, -3, 5, 3, 6, 7 };
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        // int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        // int[] arr = { 648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665,
        // 876, 448, 4, 81, 807, 578, 712, 951,
        // 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158,
        // 698, 536, 165, 892, 327, 574,
        // 516, 36, 705, 900, 482, 558, 937, 207, 368 };
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        // System.out.println(slidingWindowMax(A, 3));
        System.out.println(slidingWindowMax(A, 2));
        // System.out.println(slidingWindowMax(A, 1));
        // System.out.println(slidingWindowMax(A, 9));
    }

    public static ArrayList<Integer> slidingWindowMax(List<Integer> A, int B) {
        int len = A.size();
        Queue queue = new Queue(B);
        ArrayList<Integer> result = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int curr = A.get(i);
            if (max < curr) {
                max = curr;
            }
            if (B - 1 == i) {
                result.add(max);
            }
            // {1, 3, -1, -3, 5, 3, 6, 7};
            // {3, 1, -1, -3, 5, 3, 6, 7};
            if (queue.size() < B) {
                queue.enqueue(curr);
            } else {
                int peek = queue.peek();
                queue.dequeue();

                if (curr < max) {
                    // This means max is still part of queue.
                    if (peek != max) {
                        result.add(max);
                        queue.enqueue(curr);
                    } else {
                        queue.enqueue(curr);
                        int _max = queue.getMax();
                        max = _max;
                        result.add(_max);
                    }
                } else {
                    result.add(curr);
                    queue.enqueue(curr);
                }

            }
        }

        return result;
    }

    public static ArrayList<Integer> slidingWindowMax1(List<Integer> A, int B) {
        if (B == 1) {
            return new ArrayList<>(A);
        }
        int len = A.size();

        ArrayList<Integer> result = new ArrayList<>();

        int max = 0;
        ArrayList<Integer> slidingWindow = new ArrayList<>();
        for (int i = 0; i < len; i++) {

            int curr = A.get(i);
            if (curr > max) {
                max = curr;
            }
            if (i == B - 1) {
                result.add(max);
            }

            if (i > B - 1) {
                if (curr <= max) {
                    if (slidingWindow.get(0) != max) {
                        slidingWindow.remove(0);
                        slidingWindow.add(curr);
                        result.add(max);
                    } else {
                        if (slidingWindow.size() == B) {
                            slidingWindow.remove(0);
                            slidingWindow.add(curr);
                            max = Integer.MIN_VALUE;
                            for (int j = 0; j < slidingWindow.size(); j++) {
                                int swCurr = slidingWindow.get(j);
                                if (max < swCurr) {
                                    max = swCurr;
                                }
                            }
                            result.add(max);
                        }
                    }

                } else {
                    max = curr;
                    // slidingWindow.remove(0);
                    slidingWindow.clear();
                    slidingWindow.add(curr);
                    result.add(max);
                }
            } else {
                slidingWindow.add(curr);
            }
        }
        return result;
    }
}

class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int length;

    Queue(int cap) {
        arr = new int[cap];
        front = 0;
        rear = -1;
        capacity = cap;
        length = 0;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Operation not allowed");
            System.exit(1);
        }
        front = (front + 1) % capacity;
        length--;
    }

    public void enqueue(int num) {
        if (isFull()) {
            System.out.println("Operation not allowed");
            System.exit(1);
        }
        rear = (rear + 1) % capacity;
        arr[rear] = num;
        length++;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Operation not allowed");
            System.exit(1);
        }
        return arr[front];
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public boolean isFull() {
        return (size() == capacity);
    }

    public int getMax() {
        if (length == 0) {
            System.out.println("Operation not allowed");
            System.exit(1);
        }

        int max = Integer.MIN_VALUE;
        if (front == rear)
            max = arr[front];

        int i = front;

        int count = 0;
        while (count < capacity) {
            int curr = arr[i];
            if (max < curr) {
                max = curr;
            }
            i = (i + 1) % capacity;
            count++;
        }

        return max;
    }
}

// BRUTE

// if (i + 1 >= B) {
// result.add(max);
// }
// for (int j = i; j < B+i; j++) {
// int curr = A.get(j);
// if (curr > max) {
// max = curr;
// }
// }
// result.add(max);
