package Algorithm.SortAndSearch;

/**
 * @ClassName : BinarySearch
 * @Description : 二分查找
 * @Author : xcx
 * @Date : 2019-03-11 9:18
 * @Version : 1.0
 */
public class BinarySearch {
    /**
     * 非递归实现
     * @param nums
     * @param target
     * @return
     */
    public static int solution(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;

    }

    /**
     * 递归实现
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int solution2(int[] nums,int target,int left,int right){
        if(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] < target){
                return solution2(nums,target,mid + 1,right);
            } else if(nums[mid] > target){
                return solution2(nums,target,left,mid - 1);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {6,7,8,1,2,4};
        System.out.println(solution(nums,2));
        //System.out.println(solution2(nums,4,0,nums.length - 1));
    }
}
