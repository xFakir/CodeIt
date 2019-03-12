package Algorithm.array;

/**
 * @ClassName : SearchRotatedArray
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-12 9:19
 * @Version : 1.0
 */
public class SearchRotatedArray {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     *
     * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     *
     * 示例 1:
     *
     * 输入: nums = [2,5,6,0,0,1,2], target = 0
     * 输出: true
     * 示例 2:
     *
     * 输入: nums = [2,5,6,0,0,1,2], target = 3
     * 输出: false
     * 进阶:
     *
     * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
     * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
     */

    /**
     * 二分 如果mid和right相等 则right--继续循环
     * @param nums
     * @param target
     * @return
     */
    public static boolean solution(int[] nums,int target){
        if(nums.length == 0) return false;
        int left = 0,right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target) return true;
            else if(nums[mid] < nums[right]){
                if(nums[mid] < target && nums[right] >= target) left = mid + 1;
                else right = mid - 1;
            }else if(nums[mid] > nums[right]){
                if (nums[mid] > target && nums[left] <= target) right = mid - 1;
                else left = mid + 1;
            }else right--;
        }
        return false;
    }

    /**
     * 双指针
     * @param nums
     * @param target
     * @return
     */
    public static boolean solution2(int[] nums,int target){
        int l = nums.length;
        if (l == 0)
            return false;
        if (l == 1) {
            if (target == nums[0])
                return true;
            return false;
        }
        int left = 0, right = l - 1;
        while (left < right) {
            if (nums[left] == target || nums[right] == target)
                return true;
            if (nums[right] < target && nums[left] > target)
                return false;
            if (nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int[] nums = {1,1,3,1};
        System.out.println(solution(nums,3));
    }
}
