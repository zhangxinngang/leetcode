package com.custom.zh3ng.algorithms;


import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  zhangxingang
 * @created on 2021/7/6
 */
public class DynamicPlanning {
    /**
     * 1 5 10 20人民币，用最少的张数，组合总价
     */
    static int[] money = new int[]{20, 10, 5, 1};
    public int make(int sum, List<Integer> list){
        for (int m:money){
            if (sum > m){
                list.add(m);
                return make(sum-m, list);
            }else if (sum == m){
                list.add(m);
                return list.size();
            }
        }
        if (list.size() == 0){
            return 0;
        }
        sum += list.get(list.size()-1);
        list.remove(list.size() - 1);
        return make(sum, list);
    }

    public static void main(String[] args) {
        DynamicPlanning dynamicPlanning = new DynamicPlanning();
        List<Integer> list = new ArrayList<>();
        System.out.println(dynamicPlanning.make(15, list));
        for (Integer i:list){
            System.out.println(i);
        }
    }
}