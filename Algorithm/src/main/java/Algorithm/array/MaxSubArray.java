package Algorithm.array;

/**
 * @ClassName : MaxSubArray
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-18 10:21
 * @Version : 1.0
 */
public class MaxSubArray {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 示例:
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     *
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */

    public static int solution(int[] nums){
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else//若小于零，则取当前值，相当于清零后加当前值
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
