package Algorithm.list;

/**
 * @ClassName : RotateRight
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-10 10:08
 * @Version : 1.0
 */
public class RotateRight {
    public static ListNode solution(ListNode head,int k){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode last = null;
        int length = 0;
        while (current.next != null) {
            length++;
            current = current.next;
        }
        length++;
        last = current;
        current = head;
        int separate = length - k % length;

        for (int i = 0; i < separate - 1; i++) {
            current = current.next;
        }
        last.next = head;
        head = current.next;
        current.next = null;
        return head;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        ListNode ln = solution(l1,2);
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
