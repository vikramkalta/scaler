import java.util.ArrayList;

public class MergeIntervals {
    public static void main(String args[]) {
        // int[] arr = { 1, 2, 4, 6, 8, 12, 13, 16 };
        // int[] arr = {1, 3, 6, 9};
        // int[] arr ={1, 2,3, 6};
        // int[] arr = { 1, 2, 8, 10 };
        int[] arr = { 3, 5, 8, 10 };
        // int[] arr ={6037774, 6198243, 6726550, 7004541, 8842554, 10866536, 11027721,
        // 11341296, 11972532, 14746848, 16374805, 16706396, 17557262, 20518214,
        // 22139780, 22379559, 27212352, 28404611, 28921768, 29621583, 29823256,
        // 32060921, 33950165, 36418956, 37225039, 37785557, 40087908, 41184444,
        // 41922814, 45297414, 48142402, 48244133, 48622983, 50443163, 50898369,
        // 55612831, 57030757, 58120901, 59772759, 59943999, 61141939, 64859907,
        // 65277782, 65296274, 67497842, 68386607, 70414085, 73339545, 73896106,
        // 75605861, 79672668, 84539434, 84821550, 86558001, 91116470, 92198054,
        // 96147808, 98979097};
        ArrayList<Interval> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i += 2) {
            int currStart = arr[i];
            int currEnd = arr[i + 1];
            A.add(new Interval(currStart, currEnd));
        }

        // System.out.println(insert(A, new Interval(3,4)));
        // System.out.println(insert(A, new Interval(10, 15)));
        // System.out.println(insert(A, new Interval(2, 5)));
        // System.out.println(insert(A, new Interval(2, 6)));
        // System.out.println(insert(A, new Interval(10, 8)));
        // System.out.println(insert(A, new Interval(36210193, 61984219)));
        System.out.println(insert(A, new Interval(3, 6)));
        // System.out.println(insert(A, new Interval(1, 12)));
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int len = intervals.size();
        int newIntStart = newInterval.start;
        int newIntEnd = newInterval.end;

        int startIndex = -1, endIndex = -1;
        boolean startOverlap = false, endOverlap = true;
        ArrayList<Interval> result = new ArrayList<>();
        // 2,5|8,16|25,30|40,45|55,60 --- 42,52
        for (int i = 0; i < len; i++) {
            int currStart = intervals.get(i).start;
            int x = i == len - 1 ? i : i + 1;
            int nextStart = intervals.get(x).start;
            int currEnd = intervals.get(i).end;

            if (newIntStart >= currStart && newIntStart <= currEnd) {
                startOverlap = true;
                startIndex = i;
            } else if (newIntEnd > currEnd && newIntEnd < nextStart) {
                startIndex = i;
            } else if (newIntEnd >= currStart && newIntEnd <= currEnd) {
                endOverlap = true;
                endIndex = i;
            } else if (newIntEnd > currEnd && newIntEnd < nextStart) {
                endIndex = i;
            } else if (startIndex == -1 || endIndex == -1) {
                result.add(new Interval(currStart, currEnd));
            }
            if (startIndex == endIndex && startIndex > -1) {
                int s = intervals.get(startIndex).start;
                int e = intervals.get(endIndex).end;
                int end;
                if (startOverlap && endOverlap) {
                    result.add(new Interval(s, e));
                    end = e;
                } else if (startOverlap && !endOverlap) {
                    result.add(new Interval(s, newIntEnd));
                    end = newIntEnd;
                } else if (!startOverlap && endOverlap) {
                    result.add(new Interval(newIntStart, e));
                    end = e;
                } else {
                    // if (!startOverlap && !endOverlap)
                    result.add(new Interval(newIntStart, newIntEnd));
                    end = newIntEnd;
                }

                if (currStart > end) {
                    result.add(new Interval(currStart,currEnd));
                }
            }
        }

        return result;
    }

    // for (int i = 0; i < len; i++) {
    // int currStart = intervals.get(i).start;
    // int currEnd = intervals.get(i).end;
    // if (i < startIndex) {
    // result.add(new Interval(currStart,currEnd));
    // } else {
    // Interval interval = new Interval(-1,-1);
    // if (startOverlap && !endOverlap) {
    // result.add(new Interval(currStart, newIntEnd));
    // }
    // if (!startOverlap && !endOverlap && newIntStart > currEnd) {
    // result.add(new Interval(newIntStart,newIntEnd));
    // }
    // if (startOverlap && endOverlap && startIndex == endIndex) {
    // result.add(new Interval(currStart,currEnd));
    // }
    // if (startOverlap && i == startIndex) {
    // interval.start = currStart;
    // }
    // if (endOverlap && i == endIndex) {
    // interval.end = currEnd;
    // }
    // if (interval.start != -1 && interval.end != -1) {
    // result.add(startIndex, interval);
    // }
    // }
    // }
    public static ArrayList<Interval> insert1(ArrayList<Interval> intervals, Interval newInterval) {
        int len = intervals.size();
        ArrayList<Interval> result = new ArrayList<>();
        if (len == 0) {
            result.add(newInterval);
            return result;
        }

        int newIntervalStart = newInterval.start;
        int newIntervalEnd = newInterval.end;

        int startIndex = -1, endIndex = -1;
        for (int i = 0; i < len; i++) {
            int currStart = intervals.get(i).start;
            int currEnd = intervals.get(i).end;
            if (newIntervalStart >= currStart && newIntervalStart <= currEnd) {
                startIndex = i;
            }
            if (newIntervalStart <= currStart && startIndex == -1) {
                startIndex = i;
            }
            if (newIntervalEnd >= currStart && newIntervalEnd <= currEnd) {
                endIndex = i;
            }
            if (newIntervalEnd == currStart && endIndex == -1) {
                endIndex = i;
            }
            if (newIntervalEnd < currStart && endIndex == -1) {
                endIndex = i;
            }
            if (startIndex != -1 && endIndex != -1) {
                break;
            }
        }
        if (startIndex == endIndex && startIndex == -1) {
            if (newIntervalEnd < intervals.get(0).start) {
                intervals.add(0, new Interval(newIntervalStart, newIntervalEnd));
            } else {
                intervals.add(new Interval(newIntervalStart, newIntervalEnd));
            }
            return intervals;
        }
        int x = intervals.get(len - 1).end;
        if (endIndex == -1 && x <= newIntervalEnd) {
            result.add(new Interval(newIntervalStart, newIntervalEnd));
            return result;
        }

        Interval endInterval = intervals.get(endIndex);
        int startIntervalStart = intervals.get(startIndex).start;
        int startIntervalEnd = intervals.get(endIndex).end;
        // int endIntervalStart = endInterval.start;
        int endIntervalEnd = endInterval.end;
        if (startIndex == endIndex) {
            int s, e;
            if (newIntervalStart <= startIntervalStart) {
                s = newIntervalStart;
            } else {
                s = startIntervalStart;
            }
            if (newIntervalEnd >= startIntervalEnd) {
                e = newIntervalEnd;
                intervals.remove(startIndex);
            } else {
                e = startIntervalEnd;
                intervals.remove(startIndex);
            }
            intervals.add(startIndex, new Interval(s, e));
        } else {
            int e, s;
            if (newIntervalStart >= startIntervalStart) {
                s = startIntervalStart;
            } else {
                s = newIntervalStart;
            }
            if (newIntervalEnd >= endIntervalEnd) {
                e = newIntervalEnd;
                intervals.remove(endIndex);
            } else {
                e = endIntervalEnd;
                intervals.remove(endIndex);
            }
            intervals.set(startIndex, new Interval(s, e));
        }

        int intervalLen = intervals.size();
        // int checkStart = intervals.get(startIndex).start;
        int checkEnd = intervals.get(startIndex).end;
        for (int i = 0; i < intervalLen; i++) {
            int currStart = intervals.get(i).start;
            int currEnd = intervals.get(i).end;
            if (i <= startIndex) {
                result.add(new Interval(currStart, currEnd));
            } else {
                if (checkEnd < currStart) {
                    result.add(new Interval(currStart, currEnd));
                }
            }
        }

        return result;
    }
}

