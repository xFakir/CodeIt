package Algorithm.list;

/**
 * @ClassName : DeleteDuplicates2
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-10 18:44
 * @Version : 1.0
 */
public class DeleteDuplicates2 {
    public static ListNode solution(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode result = new ListNode(-1);
        ListNode dummy = result;
        dummy.next = head;

        ListNode first = head;
        ListNode second = first.next;

        int flag = 0;

        while (second != null) {

            while (second != null && first.val == second.val ) {
                second = second.next;
                flag = 1;
            }

            if (flag == 1 && second != null) {
                dummy.next = second;
                first = second;
                second = second.next;
            } else if (flag == 1){
                dummy.next = second;

            } else {
                dummy = dummy.next;
                first = first.next;
                second = second.next;
            }
            flag = 0;


        }
        return result.next;

        /**
         if(head==null||head.next == null) return head;
         ListNode node = head;
         boolean flag = false;
         while(head.next!=null&&head.val==head.next.val){
         head = head.next;
         flag = true;
         }
         if(!flag){
         node.next = deleteDuplicates(head.next);
         return node;
         }
         return deleteDuplicates(head.next);
         **/
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);
        /*l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(5);*/
        ListNode ln = solution(l1);
        while (ln != null) {
            System.out.println(ln.val);
            ln = ln.next;
        }
    }
}
