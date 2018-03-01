package com.company;

public class CWCLinkedList extends WCLinkedList{
    @Override
    public boolean contains(String data){
        /*
         * This method returns a boolean True if the input data is in the list and False if it is not. It does this by
         * checking to see if both the head and tail are defined to be null.
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
            /*
            if (second.w.getCount() > second.prev.w.getCount()){
                swap(second);
            }
            */
            second = second.next;
        }

        return false;
    }

    private void update(Node current){
        while(current.prev != null ||current.w.getCount() > current.prev.w.getCount()) {
            System.out.println("Current: " + current.w.toString());
            System.out.println("Previous: " + current.prev.w.toString());
            swap(current);

            System.out.println("New Current: " + current.w.toString());
            System.out.println("New Previous: " + current.prev.w.toString());
            //System.out.println("New Previous prev: " + current.prev.prev.w.toString());
            current = current.prev;
        }
    }
}
