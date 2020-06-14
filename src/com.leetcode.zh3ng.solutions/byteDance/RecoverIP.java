package com.leetcode.zh3ng.solutions.byteDance;

import javax.crypto.spec.RC2ParameterSpec;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangxingang
 * @created on 2020/6/14
 *
 * 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 *
 *
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class RecoverIP {
    Set<String> ips = new HashSet<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0,3, 0,new String[4]);
        dfs(s, 0,2, 0,new String[4]);
        dfs(s, 0,1, 0, new String[4]);
        return new ArrayList<>(ips);
    }

    private void dfs(String s, int index, int len, int num,String[] ipChunks){
        if (num == 3){
            if (index >= s.length()){
                return;
            }
            String ipChunk = s.substring(index, s.length());
            if (ipChunk.startsWith("0") && ipChunk.length() > 1){
                return;
            }

            if (ipChunk.length() <= 3&&Integer.valueOf(ipChunk) < 256){
                ipChunks[num] = ipChunk;
                ips.add(String.join(".",ipChunks));
            }
            return;
        }else{
            if ((index + len) > s.length()){
                return;
            }
            String ipChunk = s.substring(index, index+len);
            if (ipChunk.startsWith("0") && ipChunk.length() > 1){
                return;
            }
            if (Integer.valueOf(ipChunk) < 256){
                ipChunks[num] = ipChunk;
                dfs(s, index+len,1, num+1, ipChunks);
                dfs(s, index+len,2, num+1, ipChunks);
                dfs(s, index+len,3, num+1, ipChunks);
            }else{
                return;
            }
        }
    }

    public static void main(String[] args) {
        RecoverIP recoverIP = new RecoverIP();
        System.out.println(recoverIP.restoreIpAddresses("0279245587303"));
    }
}
