package Algorithm.array;

/**
 * @ClassName : MaxArea
 * @Description :
 * @Author : xcx
 * @Date : 2019-03-09 10:04
 * @Version : 1.0
 */
public class MaxArea {
    /**
     * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     */

    /**
     * @Description :O(n^2) 暴力法，求出所有n(n-1)/2个面积比较
     * @Date : 2019-03-09 10:17
     * @param height
     * @return : int
     */
    public static int solution(int[] height){
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * (height[i] >= height[j] ? height[j] : height[i]);
                if (area > result){
                    result = area;
                }
            }
        }

        return result;
    }

    /**
     * @Description :O(n) 双指针
     * @Date : 2019-03-09 10:17
     * @param height
     * @return : int
     */
    public static int solution2(int[] height){
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
            boolean h = height[left] >= height[right];
            int area = (right - left) * (h ? height[right] : height[left]);
            result = area > result ? area:result;
            if (h){
                right --;
            } else {
                left ++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution(nums));
    }
}
