package Algorithm.list;

import java.util.HashMap;

/**
 * @ClassName : CopyRandomList
 * @Description :
 * @Author : xcx
 * @Date : 2019-04-14 15:17
 * @Version : 1.0
 */
public class CopyRandomList {
    public static RandomListNode solution(RandomListNode head) {
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode current = head;
        while (current != null) {
            RandomListNode newNode = new RandomListNode(current.val,current.next,current.random);
            map.put(current,newNode);
            current = current.next;
        }

        current = head;

        while (current != null) {
            RandomListNode newNode = map.get(current);
            newNode.next = map.get(current.next);
            newNode.random = map.get(current.random);
            current = current.next;
        }

        return map.remove(head);
    }

    public static RandomListNode solution2(RandomListNode head) {
       RandomListNode current = head;
       while (current != null) {
           RandomListNode newNode = new RandomListNode(current.val,current.next,null);
           current.next = newNode;
           current = current.next.next;
       }

       current = head;

       while (current != null) {
           current.next.random = current.random == null ? null : current.random.next;
           current = current.next.next;
       }

       current = head;

       RandomListNode result = new RandomListNode(-1,null,null);
       RandomListNode result_current = result;
       while (current != null) {
           result_current.next = current.next;
           current.next = current.next.next;
           current = current.next;
           result_current = result_current.next;
       }

       return result.next;


    }
}
