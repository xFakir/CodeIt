package Algorithm.array;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : FourSum
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-06 20:33
 * @Version : 1.0
 */
public class FourSum {
    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     *
     * 满足要求的四元组集合为：
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     *
     * [-1,0,1,2,-1,-4]
     * -1
     */

    public static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if(nums.length < 4){
            return result;
        } else if (nums.length == 4){
            if(nums[0] + nums[1] + nums[2] + nums[3] == target){
                result.add(Arrays.asList(nums[0],nums[1],nums[2],nums[3]));
            }
            return result;
        } else {
            for (int i = 0; i < nums.length - 3; i++) {
                if(i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if(j > i + 1 && nums[j] == nums[j - 1]){
                        continue;
                    }
                    int left = j + 1;
                    int right = nums.length - 1;
                    while(left < right){
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        System.out.println(i + " " + j +  " " + left + " " + right+ " "+ sum);
                        if(sum < target){
                            left++;
                        } else if (sum > target){
                            right--;
                        } else {
                            result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                            while (left < right && nums[left] == nums[left + 1]){
                                left++;
                            }
                            while (left < right && nums[right] == nums[right -1]){
                                right--;
                            }
                            left++;
                            right--;
                        }
                    }
                }

            }
            return result;
        }

    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution(nums,-1));
    }

}
