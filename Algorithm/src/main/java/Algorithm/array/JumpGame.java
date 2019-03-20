package Algorithm.array;

/**
 * @ClassName : JumpGame
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-20 9:17
 * @Version : 1.0
 */
public class JumpGame {
    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个位置。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,1,1,4]
     * 输出: true
     * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
     * 示例 2:
     * <p>
     * 输入: [3,2,1,0,4]
     * 输出: false
     * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
     */

    public static boolean solution(int[] nums) {
        int maxStep = nums[0];
        for (int i = 1; i <= maxStep && i < nums.length;i++) {
            int step = i + nums[i];
            maxStep = Math.max(maxStep,step);
        }
        return maxStep >= nums.length -1;
    }

    public static boolean solution2(int[] nums){
        //max为当前最大可达的位置
        int max = nums[0];
        int len = nums.length;

        for(int i = 1;i <= max && i < len ;i++)
            if(nums[i] + i > max){
                max = nums[i]+i;
            }

        return max >= nums.length-1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0};
        System.out.println(solution2(nums));
    }
}
