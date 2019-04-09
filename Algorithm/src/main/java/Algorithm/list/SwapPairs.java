package Algorithm.list;

/**
 * @ClassName : SwapPairs
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-09 10:32
 * @Version : 1.0
 */
public class SwapPairs {
    public static ListNode solution(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        dummy.next = head;
        ListNode first = head;
        ListNode second = head.next;
        while (first.next != null) {
            swap(dummy,first,second);
            dummy = dummy.next.next;

            first = first.next;
            if (first == null) {
                return result.next;
            }

            int n = 0;
            while (second.next != null && n <= 2) {
                if (second.next == null) {
                    return result.next;
                } else {
                    second = second.next;
                    n++;
                }
            }

        }
        return result.next;
    }

    private static void swap(ListNode l1,ListNode l2,ListNode l3){
        ListNode l4 = l3.next;
        l1.next = l3;
        l3.next = l2;
        l2.next = l4;

    }

    /**
     * 递归
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        //l1.next.next = new ListNode(3);
        //l1.next.next.next = new ListNode(4);
        ListNode ln = solution(l1);
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
