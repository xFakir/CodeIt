package Algorithm.array;

/**
 * @ClassName : SearchRotationArray
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-11 9:02
 * @Version : 1.0
 */
public class SearchRotationArray {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 示例 1:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     */

    /**
     * 递归方法
     * @param nums
     * @param target
     * @return
     */
    public static int solution(int[] nums,int target){
        return solution(nums,target,0,nums.length - 1);
    }

    public static int solution(int[] nums,int target,int left,int right){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target){
            return mid;
        }
        if (nums[mid] < nums[right]) {
            if (nums[mid] < target && target <= nums[right]){
                return solution(nums,target,mid + 1, right);
            }
            else{
                return solution(nums, target, left, mid - 1);
            }
        } else {
            if (nums[left] <= target && target < nums[mid]){
                return solution(nums, target, left, mid - 1);
            } else{
                return solution(nums, target, mid + 1, right);
            }
        }
    }

    /**
     * 非递归
     * @param nums
     * @param target
     * @return
     */
    public static int solution2(int[] nums,int target){
        if(nums.length==0)
            return -1;
        if(nums[0]==target)
            return 0;
        else if(nums[0]<target){
            int low=1,high=nums.length-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(nums[mid]==target)
                    return mid;
                else if(nums[mid]>=nums[low])
                {
                    if(nums[mid]>target)
                        high=mid-1;
                    else
                        low=mid+1;
                }
                else high=mid-1;
            }
            return -1;
        }
        else{
            int low=1,high=nums.length-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(nums[mid]==target)
                    return mid;
                else if(nums[mid]<=nums[high])
                {
                    if(nums[mid]>target)
                        high=mid-1;
                    else
                        low=mid+1;
                }
                else low=mid+1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(solution2(nums,0));
    }
}
