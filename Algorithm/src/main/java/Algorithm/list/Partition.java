package Algorithm.list;

/**
 * @ClassName : Partition
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-11 12:35
 * @Version : 1.0
 */
public class Partition {
    public static ListNode solution(ListNode head,int x){
        if(head == null || head.next == null)
            return head;

        ListNode result = new ListNode(-1);
        result.next = head;


        ListNode first = result;



        while (first.next != null){
            if (first.next.val < x) {
                first = first.next;
            } else {
                break;
            }
        }

        //first = first == head ? result : first;

        ListNode second = first;

        while (second != null && second.next != null) {
            if (second.next.val < x) {
                ListNode temp = first.next;
                first.next = second.next;
                second.next = second.next.next;
                first.next.next = temp;
                first = first.next;
            } else {
                second = second.next;
            }

        }
        return result.next;

        /*ListNode less_head = new ListNode(0);
        ListNode more_head = new ListNode(0);

        ListNode less_cur = less_head;
        ListNode more_cur = more_head;

        while(head != null){
            if(head.val < x){
                less_cur.next = head;
                less_cur = less_cur.next;
            }
            else{
                more_cur.next = head;
                more_cur = more_cur.next;
            }
            head = head.next;
        }

        less_cur.next = more_head.next;
        more_cur.next = null;
        return less_head.next;*/

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(1);
        l1.next.next.next.next.next = new ListNode(2);
        ListNode ln = solution(l1,3);
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
