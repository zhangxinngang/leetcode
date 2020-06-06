package com.leetcode.zh3ng.solutions.june30days;

import java.util.*;

/**
 * @author zhangxingang
 * @created on 2020/6/6
 *
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 *
 * Note:
 * The number of people is less than 1,100.
 *
 *
 * Example
 *
 * Input:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * Output:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 */
public class QueueReconstructionbyHeight {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> peopleList = Arrays.asList(people);
        Collections.sort(peopleList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });

        int[][] result = new int[people.length][];

        for (int[] p : people){
            int count = 0;
            for (int i = 0;i<result.length;i++){
                if (count == p[1]){
                    if (result[i] == null){
                        result[i] = p;
                        break;
                    }else{
                        continue;
                    }
                }
                if (count < p[1]){
                    if (result[i] == null){
                        count++;
                    }else if (result[i] != null && result[i][0] >= p[0]){
                        count++;
                    }
                }
            }
        }

        return result;
    }

    public int[][] reconstructQueue2(int[][] people) {

        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int[] o1,int[] o2){
                return o1[0]==o2[0] ? o1[1]-o2[1] : o2[0]-o1[0];
            }
        });

        ArrayList<int[]> res = new ArrayList<>();

        for(int[] person : people){
            res.add(person[1], person);
        }

        return res.toArray(new int[people.length][2]);


    }

    public static void main(String[] args) {
        QueueReconstructionbyHeight q = new QueueReconstructionbyHeight();

        int[][] result = q.reconstructQueue2(new int[][]{
                new int[]{7,0},
                new int[]{4,4},
                new int[]{7,1},
                new int[]{5,0},
                new int[]{6,1},
                new int[]{5,2},
        });

        for (int[] r:result){
            System.out.println(r[0]+" "+r[1]);
        }
    }
}
