package Algorithm.list;

/**
 * @ClassName : HasCycle
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-14 14:34
 * @Version : 1.0
 */
public class HasCycle {
    public static boolean solution(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;

       while (fast != null && fast.next != null) {
           fast = fast.next.next;
           slow = slow.next;
           if (fast == slow) {
               return true;
           }
       }
       return false;
    }
}
