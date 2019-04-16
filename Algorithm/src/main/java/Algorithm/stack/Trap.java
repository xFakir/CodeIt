package Algorithm.stack;

import java.util.Stack;

/**
 * @ClassName : Trap
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-16 10:11
 * @Version : 1.0
 */
public class Trap {
    public static int solution(int[] height) {
        if (height == null || height.length <= 2) return 0;
        int sum = 0;
        int max = 0;
        int pos = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                pos = i;
            }
        }
        int temp = height[0];// 水位线
        for (int i = 1; i < pos; i++) {
            if (height[i] < temp) {
                sum += temp - height[i];
            } else {
                temp = height[i];
            }
        }
        temp = height[height.length - 1];// 水位线
        for (int i = height.length - 2; i > pos; i--) {
            if (height[i] < temp) {
                sum += temp - height[i];
            } else {
                temp = height[i];
            }
        }

        return sum;
    }

    public int solution2(int[] height) {
        int n = height.length;
        if (n < 3) return 0;
        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }

    public int solution3(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int leftMax = 0, rightMax = 0;
        while(left < right)
        {
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }

    public int solution4(int[] height) {
        int ans = 0;
        int current = 0;

        // 存储的是idx
        Stack<Integer> st = new Stack<Integer>();

        while (current < height.length) {
            while (!st.isEmpty() && height[current] > height[st.peek()]) {
                int top = st.pop();

                if (st.empty())
                    break;

                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()]);

                ans += distance * (bounded_height - height[top]);
            }

            st.push(current);
            current++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {3,2,1,2,1};
        System.out.println(solution(a));
    }
}
