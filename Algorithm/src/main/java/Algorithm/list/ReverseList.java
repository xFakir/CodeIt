package Algorithm.list;

/**
 * @ClassName : ReverseList
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-12 9:43
 * @Version : 1.0
 */
public class ReverseList {
    public static ListNode solution(ListNode head){

        ListNode p = null;
        ListNode q = head;


        while (q != null) {

            head = q.next;
            q.next = p;
            p = q;
            q = head;

        }
        return p;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(5);
        ListNode ln = solution(l1);
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
