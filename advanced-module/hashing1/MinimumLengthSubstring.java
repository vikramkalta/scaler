import java.util.HashMap;

public class MinimumLengthSubstring {
    public static void main(String args[]) {
        // System.out.println(solve("ADOBECODEBANC", "ABC"));
        // System.out.println(solve("Aa91b", "ab"));
        // System.out.println(solve("AABC", "ABC"));
        // mine
        // ZpYhshyWHh01vLmtpG0IXRDDiBtqI7Yjh5HdNfgvcnv23zftwNI9Oq7JzHF7xUc6E2FNuzAtM5tYRAvfcksvIy1JcSDMpKusvo26Dqd74QTI5tW0e9U0saWoY5hOsPHtjchOnUQ6yYPTC4KLaIXmtorTutElQfAR3bCrIN2o5j8KW4UcsXGuRuk66nvePQKLaB93JCPOKv3p8Lu8Hhs4zcHdQjpnlFM1wPGADAWWR3llubPAFps0GShB4Q1yWO8I3Z21V1chiJI48hRIKqKrtnmO7Ca29yuN1AXzYkqqmS3mVSQqkhucEkQoWjhBsUp3K5OXVaFvb3zPbTq4pO44zpf7i6MNHbBMlGtkpZ
        // scaler
        // ZpYhshyWHh01vLmtpG0IXRDDiBtqI7Yjh5HdNfgvcnv23zftwNI9Oq7JzHF7xUc6E2FNuzAtM5tYRAvfcksvIy1JcSDMpKusvo26Dqd74QTI5tW0e9U0saWoY5hOsPHtjchOnUQ6yYPTC4KLaIXmtorTutElQfAR3bCrIN2o5j8KW4UcsXGuRuk66nvePQKLaB93JCPOKv3p8Lu8Hhs4zcHdQjpnlFM1wPGADAWWR3llubPAFps0GShB4Q1yWO8I3Z21V1chiJI48hRIKqKrtnmO7Ca29yuN1AXzYkqqmS3mVSQqkhucEkQoWjhBsUp3K5OXVaFvb3zPbTq4pO44zpf7i6MNHbBMlGtkpZ
        // test
        // ZpYhshyWHh01vLmtpG0IXRDDiBtqI7Yjh5HdNfgvcnv23zftwNI9Oq7JzHF7xUc6E2FNuzAtM5tYRAvfcksvIy1JcSDMpKusvo26Dqd74QTI5tW0e9U0saWoY5hOsPHtjchOnUQ6yYPTC4KLaIXmtorTutElQfAR3bCrIN2o5j8KW4UcsXGuRuk66nvePQKLaB93JCPOKv3p8Lu8Hhs4zcHdQjpnlFM1wPGADAWWR3llubPAFps0GShB4Q1yWO8I3Z21V1chiJI48hRIKqKrtnmO7Ca29yuN1AXzYkqqmS3mVSQqkhucEkQoWjhBsUp3K5OXVaFvb3zPbTq4pO44zpf7i6MNHbBMlGtkpZ
        System.out.println(solve(
                "8tsKH5KzgeOrT0cIDcnnjf59PHEl4ZKgVmBSWbqbygXIFhpQuMmK52dlTLTLW6pnQSpkSO0o2MWpjIFailUVL1ESQVe7CmhF8GBc9y5STUKfmtfjB0yWHOltGKOTDtoYWc1J4UV4GjXywPSiNFnOvJeGK4Lbwpl7JViQkRM0RkJs6TrlsBje3GUO3XXLTUPhU3xQQxZrrM90t8KwGf4u37vwTIhYaDBJmaB5qcvgydfvwe8S8iIhI5EoyOPko1bD2Bb0ozDtf0BK0zXxI1FNQr0j6XgW77UbE257JhUtNJLxTnX5xaw4b6Fte2NvhpMMdDzTlCg0wHfFbxTV9PFzOlga6g9kwJwR1g2WHilv0Yq8kMc6cYtfCq6Q5sdYWyHNLQl8jnKB5ZpYhshyWHh01vLmtpG0IXRDDiBtqI7Yjh5HdNfgvcnv23zftwNI9Oq7JzHF7xUc6E2FNuzAtM5tYRAvfcksvIy1JcSDMpKusvo26Dqd74QTI5tW0e9U0saWoY5hOsPHtjchOnUQ6yYPTC4KLaIXmtorTutElQfAR3bCrIN2o5j8KW4UcsXGuRuk66nvePQKLaB93JCPOKv3p8Lu8Hhs4zcHdQjpnlFM1wPGADAWWR3llubPAFps0GShB4Q1yWO8I3Z21V1chiJI48hRIKqKrtnmO7Ca29yuN1AXzYkqqmS3mVSQqkhucEkQoWjhBsUp3K5OXVaFvb3zPbTq4pO44zpf7i6MNHbBMlGtkpZuJPe1f4mJVIPXiud1kMt9PyIQ0I6C12TRKtdEQB",
                "rxeK5bZ89wYYl9EALgujuqpsLc8qPTMZMOwnfjVorcZiUYCEs"));

    }

    public static String solve(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();

        HashMap<Character, Integer> b = new HashMap<>();
        for (int i = 0; i < lenB; i++) {
            char curr = B.charAt(i);
            if (b.containsKey(curr)) {
                int val = b.get(curr);
                val++;
                b.replace(curr, val);
            } else {
                b.put(curr, 1);
            }
        }

        // StringBuilder str = new StringBuilder();
        String str = new String();
        Queue q = new Queue(lenA);
        // ADOBECODEBANC, ABC
        int bLenTracker = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lenA; i++) {
            char curr = A.charAt(i);
            if (q.isEmpty() && b.containsKey(curr)) {
                q.enqueue(curr);
            } else {
                if (!q.isEmpty()) {
                    q.enqueue(curr);
                }
            }

            if (b.containsKey(curr)) {
                int val = b.get(curr);
                val--;
                if (val >= 0) {
                    bLenTracker++;
                }
                b.replace(curr, val);
            }

            while (bLenTracker == lenB) {
                int lenSubstr = q.getCurrentSize();
                if (min > lenSubstr) {
                    str = q.constructStr();
                    min = lenSubstr;
                }
                char firstChar = q.dequeue();
                int val = b.get(firstChar);
                val++;
                b.replace(firstChar, val);
                if (val > 0) {
                    bLenTracker--;
                }

                while (true) {
                    char toRemove = q.lookUp();
                    if (b.containsKey(toRemove)) {
                        break;
                    }
                    q.dequeue();
                }
            }
        }

        return str;
    }
}

class Queue {
    char[] queue;
    int start = 0;
    int end = -1;
    int size = 0;
    int currentSize = 0;

    Queue(int n) {
        size = n;
        queue = new char[size];
    }

    // size=10,end=-1,start=-1
    public void enqueue(char n) {
        if (isFull()) {
            System.out.println("Illegal operation");
            System.exit(0);
        }
        end++;
        this.currentSize++;
        end = end % size;
        queue[end] = n;
    }

    public char dequeue() {
        if (isEmpty()) {
            System.out.println("Illegal operation");
            System.exit(0);
        }
        char n = queue[start];
        start++;
        this.currentSize--;
        start = start % size;
        return n;
    }

    public char lookUp() {
        return queue[start];
    }

    public boolean isFull() {
        return this.currentSize == size;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public String constructStr() {
        int _start = start;
        int _end = end;
        StringBuilder str = new StringBuilder();
        while (_start != _end) {
            str.append(queue[_start]);
            _start++;
            _start = _start % size;
        }
        if (_start == _end) {
            str.append(queue[_end]);
        }
        return new String(str);
    }
}
