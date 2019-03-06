package DataStructures.list;

/**
 * @ClassName : MyLinkedList
 * @Description :
 * @Author : xcx
 * @Date : 2019-02-11 20:25
 * @Version : 1.0
 */
public class MyLinkedList<T> {
    private int size = 0;

    private MyNode<T> first;

    private MyNode<T> last;

    MyLinkedList(){

    }

    MyLinkedList(MyLinkedList list){

    }



    private void linkLast(T data){
        MyNode l = last;
        MyNode<T> newNode = new MyNode<T>(data,l,null);
        last = newNode;

        if(l == null){
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;

    }

    private void linkFirst(T data){
        MyNode f = first;
        MyNode<T> newNode = new MyNode<>(data,null,f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
    }

    private T unlink(MyNode<T> node){
        T element = node.elementData;
        MyNode next = node.next;
        MyNode prev = node.prev;
        if (prev == null){
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null){
           last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.elementData = null;
        size--;
        return element;

    }


    public boolean add(T data){
        linkLast(data);
        return true;
    }

    public T remove(T data){


        return null;
    }




    private static class MyNode<T>{
        MyNode(T data,MyNode prev,MyNode next){
            this.elementData = data;
            this.next = next;
            this.prev = prev;
        }

        public T elementData;
        public MyNode next;
        public MyNode prev;
    }
}
