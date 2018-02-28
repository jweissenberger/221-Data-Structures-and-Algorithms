/*
 * Jack Weissenberger February 2018
 * Double Linked List Project CS 221 Data Structures and Algorithms
 * This file contains the DLinkedList class which is a doubly linked list which contains the following: Node, isEmpty(),
 * contains() size(), indexOf(), addFirst(), and toString(). It also contains an Iterator interface the supports
 * enhanced for loops.
 */


package com.company;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class WCLinkedList implements Iterable<String> {

    private static class Node{
        /*
         * This node class initializes the data that the node contains, points to the next node and the previous node
         * and also contains the index of the node
         */
        private Node next;
        private Node prev;
        private WordCount w = new WordCount();

        public Node(String data, Node next, Node prev){
            w.setData(data);
            this.next = next;
            this.prev = prev;
        }
    }

    //here the head and tail nodes are initialized so that they can be used later on as well as initializing the size of
    //the list to be zero
    Node head;
    Node tail;
    public int size =0;

    public WCLinkedList(){
        /*
         * This initializes the head and the tail to be null which makes an empty list
         */
        head = null;
        tail = null;
    }

    public void addFirst(String data){
        /*
         * The addFirst method adds a node at the beginning of the list by making a new head node, having it point to
         * the previous head node, updating the previous head to point back to it and then making the new node's
         * previous pointer to be null. This method also increments the overall size of the list by one and increments
         * the index of all of the following nodes by one (if there are any), so that the indexes are correct.
         *
         * Inputs: String data: the string that the new node will be holding
         * Outputs: N/A, but the list is updated with the new node as the head
         *
         */
        head = new Node(data, head, null);
        Node second = head.next;
        if (second != null){ //there is already at least one node
            second.prev = head;

            //increment each of the next of the indexes
            while (second !=null){
                second.indx += 1;
                second = second.next;
            }

        }

        else{ //case that we are adding to an empty list
            tail = head;
        }
        size+=1;
    }

    public int indexOf(String data){
        /*
         * This method returns the index of the node that contains the input data and returns -1 if the data is not
         * found in the string. It does this by iterating though the list, and checking to see if the string being
         * searched for is equal to the data stored in each node.
         *
         * Inputs: String data: the string that is searched for in the double linked list
         * Outputs: the integer output of the index of the node that contains the data or -1 if the data is not in the
         * list
         *
         */
        if (isEmpty()){
            return -1;
        }
        if (head.w.getData().equals(data)){
            return head.indx;
        }
        Node second = head.next;
        while (second !=null){
            if (second.w.getData().equals(data)){
                return second.indx;
            }
            second = second.next;
        }
        return -1;
    }

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
            return true;
        }
        Node second = head.next;
        while (second !=null){
            if (second.w.getData().equals(data)){
                return true;
            }
            second = second.next;
        }
        return false;
    }

    public String toString(){
        /*
         * This method returns all of the data within the list as a single string with no spaces between the words. It
         * does this by creating a string of the data of the head node and then iterating through the list and concating
         * all of the following strings
         *
         * Inputs: N/A
         * Outputs: A string with all of the data within the list as a single string with no spaces between the words
         *
         */

        if (isEmpty()){
            return " ";
        }

        String all  = head.w.getData();
        Node second = head.next;
        while (second !=null){
            all = all.concat(second.w.getData());
            second = second.next;
        }

        return all;

    }


    public void printIndx(){
        /*
         * This method prints out the all of the indexes of the list, which should be a list from 0 to size-1. It does
         * this by iterating through the list and printing node.indx of each node.
         *
         * Inputs: N/A
         * Outputs: prints out the all of the indexes of the list, which should be a list from 0 to size-1
         *
         */

        if (isEmpty()){
            System.out.println("Empty list");
            System.exit(3);
        }

        System.out.println(head.indx);
        Node second = head.next;
        while (second !=null){
            System.out.println(second.indx);
            second = second.next;
        }
    }

    public boolean isEmpty(){
        /*
         * This method checks to see if the list is empty and returns true if the list is empty and false if it is not
         *
         * Inputs: N/A
         * Outputs: returns true if the list is empty and false if it is not
         *
         */
        if (head == null && tail == null){
            return true;
        }
        else{
            return false;
        }
    }

    public void addLast(String data){
        tail = new Node(data, null, tail);
        Node second = tail.prev;
        if (second != null){
            second.next = tail;
        }
        else{
            head = tail;
        }
    }

    public int size(){
        /*
         * This method returns the size of the list by printing out the variable size that is incremented by one every
         * time the addFirst method is called
         *
         * Inputs: N/A
         * Outputs: an integer of the size of the list.
         */
        return size;
    }



    private class WCListIterator implements Iterator<String> {
        /*
         * This is the iterator interface that allows for the use of for loops and enhanced for loops to iterate through
         * the list.
         *
         */
        private Node nextNode = head;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Iterator exceeded.");
            }
            String data = nextNode.w.getData();
            nextNode = nextNode.next;
            return data;
        }
    }



    @Override
    public Iterator iterator(){
        /*
         * This is required for the iterator and returns a new DListIterator
         */
        return new WCListIterator();
    }


}

