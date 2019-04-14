package Algorithm.list;

/**
 * @ClassName : DeleteDuplicates1
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-10 18:44
 * @Version : 1.0
 */
public class DeleteDuplicates1 {
    public ListNode solution(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode second = first.next;
        while (second != null) {
            if (second.val == first.val) {
                first.next = second.next;
            } else {
                first = first.next;
            }
            second = second.next;
        }
        return head;

        /**
         if(head == null || head.next == null){
         return head;
         }

         head.next = deleteDuplicates(head.next);
         if(head.val == head.next.val){
         head = head.next;
         }
         return head;**/
    }
}
