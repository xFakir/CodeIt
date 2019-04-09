package Algorithm.list;

/**
 * @ClassName : MergeTwoLists
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-09 9:46
 * @Version : 1.0
 */
public class MergeTwoLists {
    public static ListNode solution(ListNode l1,ListNode l2){

        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                dummy.next = l2;
                l2 = l2.next;
            } else {
                dummy.next = l1;
                l1 = l1.next;
            }
            dummy = dummy.next;
        }

        while (l1 != null) {
            dummy.next = l1;
            l1 = l1.next;
            dummy = dummy.next;
        }

        while (l2 != null) {
            dummy.next = l2;
            l2 = l2.next;
            dummy = dummy.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode ln = solution(l1,l2);
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
