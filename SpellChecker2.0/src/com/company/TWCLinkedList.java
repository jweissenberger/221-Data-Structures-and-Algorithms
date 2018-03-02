/*
 * This is the TWCLinkedList class that extends WCLinkedList
 */
package com.company;

public class TWCLinkedList extends WCLinkedList {
    @Override
    public boolean contains(String data){
        /*
         * This method returns a boolean True if the input data is in the list and False if it is not. It does this by
         * checking to see if both the head and tail are defined to be null. It also follows the transpose rule to swap
         * the current node with the node above it if it is found in the text file
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
                swap(second, second.prev);
                return true;
            }
            second = second.next;
        }
        return false;
    }
}
