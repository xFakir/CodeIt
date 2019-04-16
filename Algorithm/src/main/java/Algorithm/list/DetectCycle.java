package Algorithm.list;

/**
 * @ClassName : DetectCycle
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-14 14:35
 * @Version : 1.0
 */
public class DetectCycle {
    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
