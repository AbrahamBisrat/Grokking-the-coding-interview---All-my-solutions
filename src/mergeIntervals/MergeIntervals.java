package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Problem Statement #
	Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
	
	Example 1:
	Intervals: [[1,4], [2,5], [7,9]]
	Output: [[1,5], [7,9]]
	Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into 
	one [1,5].

	Example 2:
	Intervals: [[6,7], [2,4], [5,9]]
	Output: [[2,4], [5,9]]
	Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].
	 
	Example 3:
	Intervals: [[1,4], [2,6], [3,5]]
	Output: [[1,6]]
	Explanation: Since all the given intervals overlap, we merged them into one.
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class MergeIntervals {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }
	
	static class Interval {
		private int start;
		private int end;
		Interval(int s, int e) {
			start = s;
			end = e;
		}
		@Override public String toString() { return "[" + start + " - " + end + "]";};
	}
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(2, 5));
		intervals.add(new Interval(7, 9));
		p(intervals);
		p(mergeIntervals(intervals));
	}
	public static List<Interval> mergeIntervals(List<Interval> intervals) {
		if(intervals.size() < 2) return intervals;
		List<Interval> mergedIntervals = new ArrayList<>();
		
		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		
		Iterator<Interval> intervalIterator = intervals.iterator();
		Interval interval = intervalIterator.next();
		int start = interval.start;
		int end = interval.end;
		
		while(intervalIterator.hasNext()) {
			interval = intervalIterator.next();
					
			if(interval.start <= end) end = Math.max(interval.end, end);
			else {
				mergedIntervals.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		mergedIntervals.add(new Interval(start, end));
		return mergedIntervals;
	}
	// Array version
	public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        
        // sorting by start of the interval is critical to the whole operation
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if(current[0] <= end) end = Math.max(current[1], end);
            else {
                mergedIntervals.add(new int[] {start, end});
                start = current[0];
                end = current[1];
            }
        }
        
        mergedIntervals.add(new int[] {start, end});
        
        int[][] mergedResult = new int[mergedIntervals.size()][2];
        for(int i = 0; i < mergedIntervals.size(); i++)
            mergedResult[i] = mergedIntervals.get(i);
        return mergedResult;
    }
}



