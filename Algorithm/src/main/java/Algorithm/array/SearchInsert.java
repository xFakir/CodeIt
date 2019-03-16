package Algorithm.array;

import java.util.Arrays;

/**
 * @ClassName : SearchInsert
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-14 9:30
 * @Version : 1.0
 */
public class SearchInsert {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     * 示例 1:
     *
     * 输入: [1,3,5,6], 5
     * 输出: 2
     */

    public static int solution(int[] nums,int target){

        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        if (nums[left] >= target) {
            return left;
        } else {
            return left + 1;
        }

    }


    public int searchInsert(int[] nums, int target) {
        int begin = 0, end = nums.length - 1, mid = 0;
        while (begin <= end) {
            mid = (begin + end) >>> 1;
            if (nums[mid] < target) {
                begin = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                return mid;
            }
        }if (begin == 0 || begin == nums.length) {
            return begin;
        }else {
            return ((begin + end) >>> 1) + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(solution(nums,4));
    }
}
