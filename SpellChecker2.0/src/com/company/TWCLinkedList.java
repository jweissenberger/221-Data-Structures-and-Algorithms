package com.company;

public class TWCLinkedList extends WCLinkedList {
    @Override
    public boolean contains(String data){
        if (isEmpty()){
            return false;
        }
        if (head.w.getData().equals(data)){
            head.w.incr();
            return true;
        }
        Node second = head.next;
        while (second !=null){
            if (second.w.getData().equals(data)){
                second.w.incr();
                swap(second);
                return true;
            }
            second = second.next;
        }
        return false;
    }
}
