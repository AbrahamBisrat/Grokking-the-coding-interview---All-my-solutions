package mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Statement #
	Given a list of non-overlapping intervals sorted by their start time, 
	insert a given interval at the correct position and merge all necessary intervals 
	to produce a list that has only mutually exclusive intervals.
	
	Example 1:
	Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
	Output: [[1,3], [4,7], [8,12]]
	Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].

	Example 2:
	Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
	Output: [[1,3], [4,12]]
	Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].

	Example 3:
	Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
	Output: [[1,4], [5,7]]
	Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].
 * 
 * @author Er. Abraham Bisrat https://github.com/abrahammehari
 *
 */
public class InsertInterval {
	public static void p(Object line) { System.out.println(line); }
	public static void pA(int[] arr) { p(Arrays.toString(arr)); }
	public static void pAA(int[][] grid) { for(int[] each : grid) pA(each); }

	public static void main(String[] args) {
		pAA(insertInterval(new int[][] {{1, 3}, {5, 7}, {8, 12}}, new int[] {4, 6}));
	}
	public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
		if(intervals == null || intervals.length == 0) return intervals;
		List<int[]> mergedIntervals = new ArrayList<>();
		
		// we need to skip all the intervals which end before the start of the new interval
		// if ( intervals[i][1] < newInterval[0] ) add them and move on.
		
		int i = 0;
		
		// skip (and add to output) all the intervals that come before the 'newInterval'
		// all all the elements up to where the modification needs to be set, update the cursor

		// if the end is less than the new interval start, add them and move on.
		while(i < intervals.length && intervals[i][1] < newInterval[0])
			mergedIntervals.add(intervals[i++]);
		
		// merge all intervals that overlap with the new interval
		// also make sure we don't run of the edge of the cliff.
		while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}
		
		// add the merged gap
		mergedIntervals.add(newInterval);
		
		while(i < intervals.length)
			mergedIntervals.add(intervals[i++]);
		
		return mergedIntervals.toArray(new int[0][0]);
	}
}
