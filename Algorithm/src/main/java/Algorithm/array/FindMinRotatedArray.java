package Algorithm.array;

/**
 * @ClassName : FindMinRotatedArray
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-12 10:59
 * @Version : 1.0
 */
public class FindMinRotatedArray {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 请找出其中最小的元素。
     *
     * 你可以假设数组中不存在重复元素。
     *
     * 示例 1:
     *
     * 输入: [3,4,5,1,2]
     * 输出: 1
     * 示例 2:
     *
     * 输入: [4,5,6,7,0,1,2]
     * 输出: 0
     */

    /**
     * 遍历
     * @param nums
     * @return
     */
    public static int solution(int[] nums){
        for (int i = 0; i < nums.length ; i++) {
            if(i + 1 < nums.length && nums[i] > nums[i + 1]){
                return nums[i + 1];
            }
        }
        return nums[0];
    }

    public static int solution2(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }

    public static int solution3(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        if(nums[left] < nums[right]){
            return nums[left];
        }
        while(left < right){
            int mid = (right + left)/2;
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];

    }

    public static void main(String[] args) {
        int[] nums = {3,1,2};
        System.out.println(solution3(nums));
    }
}
