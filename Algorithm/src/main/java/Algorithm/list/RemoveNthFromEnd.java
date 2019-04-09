package Algorithm.list;

/**
 * @ClassName : RemoveNthFromEnd
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-09 9:00
 * @Version : 1.0
 */
public class RemoveNthFromEnd {
    public static ListNode solution(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode next = head;

        for (int i = 1; i < n; i++) {
            next = next.next;
        }
        while (next.next != null) {
            next = next.next;
            dummy = dummy.next;
        }
        ListNode removeNode = dummy.next;
        dummy.next = dummy.next.next;

        if (removeNode == head) {
            return dummy.next;
        }
        return head;


    }



    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        //l.next = new ListNode(2);
        ListNode ln = solution(l,1);
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
