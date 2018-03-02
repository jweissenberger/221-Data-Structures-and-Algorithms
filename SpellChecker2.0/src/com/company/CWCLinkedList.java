/*
 * This is the CWCLinkedList class that extends WCLinkedList
 */
package com.company;

public class CWCLinkedList extends WCLinkedList{
    @Override
    public boolean contains(String data){
        /*
         * This method returns a boolean True if the input data is in the list and False if it is not. It does this by
         * checking to see if both the head and tail are defined to be null. It also uses the update function to move
         * the current node up the list until it reaches the top or a node with more counts than it
         *
         * Inputs: String data: the string that is searched for in the list
         * Outputs: a boolean that is True if the input data is in the list and False if it is not
         *
         */
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
                update(second);
                return true;
            }
            second = second.next;
        }

        return false;
    }

    private void update(Node current){
        /*
         * Moves the current node up the list until it reaches the top or a node with more counts than it
         *
         * Inputs: Node current: the node you want to see if it can move up the list
         */
        while(current.prev != null && current.w.getCount() > current.prev.w.getCount()) {
            swap(current, current.prev);
            current = current.prev;
        }
    }
}
