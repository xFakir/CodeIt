package Algorithm.array;

import java.util.Arrays;

/**
 * @ClassName : NextPermutation
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-09 12:03
 * @Version : 1.0
 */
public class NextPermutation {
    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
     * 必须原地修改，只允许使用额外常数空间。
     *
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     */

    public static void solution(int[] nums){
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if(i >= 0){
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums,i,j);

        }

        reverse(nums,i + 1);

    }

    private static void swap(int[] nums,int first,int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
     }

    private static void reverse(int[] nums,int begin){
        int end = nums.length - 1;
        while (begin < end){
            swap(nums,begin,end);
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,5,3,4,2};
        solution(nums);
        System.out.println(Arrays.toString(nums));
    }
}
