import java.util.List;

public class LinkedListDeque<any_type>{

    private class ListNode{
        private ListNode prev;
        private any_type value;
        private ListNode next;

        private ListNode(ListNode p,any_type v,ListNode n){
            prev = p;
            value = v;
            next = n;
        }
    }

    private ListNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new ListNode(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(any_type a){
        size += 1;
        sentinel.next = new ListNode(sentinel,a,sentinel.next);
        sentinel.next.next.prev = sentinel.next;
    }

    public void addLast(any_type a){
        size += 1;
        sentinel.prev.next = new ListNode(sentinel.prev,a,sentinel);
        sentinel.prev = sentinel.prev.next;
    }

    public boolean isEmpty(){
        return (this.size == 0);
    }

    public int size(){
        return this.size;
    }

    public void printDeque(){
        ListNode cache = sentinel;
        while(cache.next != sentinel){
            System.out.println(cache.next.value + " ");
            cache = cache.next;
        }
    }

    public any_type removeFirst(){
        if(size == 0){
            return null;
        }
        size -= 1;
        //sentinel.next.next.prev = sentinel;
        //sentinel.next = sentinel.next.next;
        any_type returnValue = sentinel.next.value;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return returnValue;
    }

    public any_type removeLast(){
        if(size == 0){
            return null;
        }
        size -= 1;
        any_type returnValue = sentinel.prev.value;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        return returnValue;
    }

    public any_type get(int index){
        ListNode temp = sentinel;
        while(index != 0){
            temp = temp.next;
            index -= 1;
        }
        return temp.next.value;
    }

    public any_type getRecursive(int index){
        if(index > this.size - 1){
            return null;
        } else{
            return helper(sentinel.next,index);
        }
    }

    public any_type helper(ListNode p,int index){
        if(index == 0){
            return p.value;
        }else{
            return helper(p.next,index - 1);
        }
    }

}
