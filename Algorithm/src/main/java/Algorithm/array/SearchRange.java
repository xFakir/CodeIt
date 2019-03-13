package Algorithm.array;

import java.util.Arrays;

/**
 * @ClassName : SearchRange
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-13 9:24
 * @Version : 1.0
 */
public class SearchRange {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     */

    /**
     * 最初的思路是使用二分法找到目标值的其中一个下标，再根据该下标左右遍历得出初始下标和结束下标。
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution(int[] nums,int target) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                while (mid >= left && nums[mid] == target) {
                    mid--;
                }
                result[0] = mid + 1;
                mid = (left + right) / 2;
                while (mid <= right && nums[mid] == target) {
                    mid++;
                }
                result[1] = mid - 1;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }


    /**
     * 假设我们目前有左指针，右指针，并判断中间值和目标值之间的关系，那么一共有三种关系情况
     *
     * 中间值小于目标值，则目标值只可能在右子数组
     * 中间值大于目标值，则目标值只可能在左子数组
     * 中间值等于目标值，则目标值在左右子数组都可能存在
     *
     * 结合情况1和情况3，当中间值小于目标值，则将左指针右移至中间，
     * 否则将右指针左移至中间。这样一定可以找到目标值的初始下标
     *
     * 同理，结合情况2和情况3，当中间值大于目标值，则将右指针左移至中间，
     * 否则将左指针右移至中间，这样一定可以找到目标值的结束下标。
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution2(int[] nums,int target){
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;

    }

    private static int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private static int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }



    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(solution(nums,8)));
    }
}
