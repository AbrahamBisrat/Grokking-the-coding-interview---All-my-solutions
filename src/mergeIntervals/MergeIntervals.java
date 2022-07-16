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
}



