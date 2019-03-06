package Algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName : ThreeSum
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-01 10:42
 * @Version : 1.0
 */
public class ThreeSum {
    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     */

    /**
     * @Description : 解法一：暴力循环 O(n^3)
     * @Date : 2019-03-01 10:50
     * @param 
     * @return : java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> solution1(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int length = nums.length;

        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length -1; j++){
                for (int k = j + 1; k < length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> innerList = new ArrayList<>();
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[k]);
                        int flag = 0;
                        for (List<Integer> list : result){
                            if(list.equals(innerList)){
                                flag = 1;
                            }
                        }
                        if(flag == 0){
                            result.add(innerList);
                        }

                    }
                }
            }

        }




        return result;
    }

    /***
     * @Description : 双指针 O(n^2)
     * @Date : 2019-03-05 20:03
     * @param nums
     * @return : java.util.List<java.util.List<java.lang.Integer>>
     */
    public static List<List<Integer>> solution2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){

                if(nums[left] + nums[right] + nums[i] > 0){
                    right--;
                } else if(nums[left] + nums[right] + nums[i] < 0){
                    left++;
                } else {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
            
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        System.out.println(solution2(nums));
    }
}
