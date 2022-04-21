package leetcode.editor.cn.solution118;

//Given an integer numRows, return the first numRows of Pascal's triangle. 
//
// In Pascal's triangle, each number is the sum of the two numbers directly abov
//e it as shown: 
//
// 
// Example 1: 
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Example 2: 
// Input: numRows = 1
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 743 👎 0


import java.util.ArrayList;
import java.util.List;

/**
 * leetcode submit region begin(Prohibit modification and deletion)
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        result.add(list1);
        for (int i = 1; i< numRows; i++){
            List<Integer> upperList = result.get(result.size() - 1);
            List<Integer> rowList = new ArrayList<>();
            rowList.add(1);
            for (int n = 0; n < upperList.size() - 1; n++){
                int sum = upperList.get(n) + upperList.get(n + 1);
                rowList.add(sum);
            }
            rowList.add(1);
            result.add(rowList);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new Solution().generate(6);

        System.out.println(result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
