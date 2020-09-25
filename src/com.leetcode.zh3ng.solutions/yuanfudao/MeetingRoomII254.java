package com.leetcode.zh3ng.solutions.yuanfudao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangxingang
 * @created on 2020/9/23
 */
public class MeetingRoomII254 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval:intervals){
            Integer peek = queue.peek();
            if (peek == null){
                queue.add(interval[1]);
            }else{
                if (interval[0] >= peek){
                    queue.poll();
                    queue.add(interval[1]);
                }else{
                    queue.add(interval[1]);
                }
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        MeetingRoomII254 meetingRoomII254 = new MeetingRoomII254();

        int num = meetingRoomII254.minMeetingRooms(new int[][]{new int[]{0,30},new int[]{5,10},new int[]{15,20}});
        System.out.println(num);
    }
}
