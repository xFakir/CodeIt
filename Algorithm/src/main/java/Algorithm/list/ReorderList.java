package Algorithm.list;

/**
 * @ClassName : ReorderList
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-14 12:22
 * @Version : 1.0
 */
public class ReorderList {
    public static ListNode solution(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode p = null;
        ListNode q = second;
        while (q != null) {

            second = q.next;
            q.next = p;
            p = q;
            q = second;

        }

        second = p;

        ListNode first = head;
        while (second != null) {
            ListNode first_next = first.next;
            ListNode second_next = second.next;
            first.next = second;
            second.next = first_next;
            first = first_next;
            second = second_next;

        }

        return head;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode ln = solution(l1);
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
