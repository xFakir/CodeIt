package Algorithm.list;

/**
 * @ClassName : ReverseBetween
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-12 16:38
 * @Version : 1.0
 */
public class ReverseBetween {
    public static ListNode solution(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        int index = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = head;
        ListNode first = head;
        ListNode second = head;
        ListNode temp = null;
        while (true) {
            index ++;
            if (index <= m) {
                first = p;
                p = q;
                q = q.next;
                second = p;
            } else if (index <= n){
                temp = q.next;
                q.next = p;
                p = q;
                q = temp;

            } else {
                first.next = p;
                second.next = q;
                break;
            }

        }

        return first == dummy ? first.next : head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        /*l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);*/
        ListNode ln = solution(l1,1,2);
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
