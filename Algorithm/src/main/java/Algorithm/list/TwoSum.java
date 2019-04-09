package Algorithm.list;

import java.util.List;

/**
 * @ClassName : TwoSum
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-08 9:47
 * @Version : 1.0
 */
public class TwoSum {
    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(-1);
        ListNode result = sumList;
        int flag = 0;
        int sum = l1.val + l2.val;
        result.val = sum%10;
        if (sum >= 10) {
            flag = 1;
        }
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + flag;

            result.next = new ListNode(sum%10);


            l1 = l1.next;
            l2 = l2.next;
            result = result.next;

            flag = (sum >= 10)? 1 : 0;

        }

        while (l1 != null) {
            sum = l1.val + flag;
            result.next = new ListNode(sum%10);
            l1 = l1.next;
            result = result.next;
            flag = (sum >= 10)? 1 : 0;
        }

        while (l2 != null) {
            sum = l2.val + flag;
            result.next = new ListNode(sum%10);
            l2 = l2.next;
            result = result.next;
            flag = (sum >= 10)? 1 : 0;
        }

        if (flag == 1) {
            result.next = new ListNode(1);
        }

        return sumList;


    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);
        //l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(2);
        //l2.next.next = new ListNode(7);
        ListNode result = solution(l1,l2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
