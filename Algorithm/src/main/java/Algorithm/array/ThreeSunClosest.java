package Algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : ThreeSunClosest
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-06 18:38
 * @Version : 1.0
 */
public class ThreeSunClosest {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
     * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
     * 假定每组输入只存在唯一答案。
     * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
     *
     * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
     */

    public static int solution(int[] nums,int target){
        if(nums.length < 3){
            return target;
        } else if (nums.length == 3){
            return nums[0] + nums[1] + nums[2];
        } else {
            Arrays.sort(nums);
            int result = nums[0] + nums[1] + nums[2];

            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right){
                    int sum = nums[left] + nums[right] + nums[i];
                    int difference = sum - target;
                    if(Math.abs(difference) < Math.abs(result - target)){
                        result = sum;
                    }
                    if(difference > 0){
                        right--;
                    } else if(difference < 0){
                        left++;
                    } else {
                        return sum;
                    }
                }

            }
            return result;
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};
        System.out.println(solution(nums,-1));
    }
}
