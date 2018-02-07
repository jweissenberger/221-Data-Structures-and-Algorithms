package com.company;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLinkedList implements Iterable<String> {

    private static class Node{
        private String data;
        private Node next;
        private Node prev;

        public Node(String data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head;
    Node tail;

    public DLinkedList(){
        head = null;
        tail = null;
    }

    public void addFirst(String data){
        head = new Node(data, head, null);
        Node second = head.next;
        if (second != null){ //there is already at least one node
            second.prev = head;
        }

        else{ //case that we are adding to an empty list
            tail = head;
        }
    }

    public boolean isEmpty(){
        if (head == null && tail == null){
            return true;
        }
        else{
            return false;
        }
    }



    private class DListIterator implements Iterator<String> {
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
            String data = nextNode.data;
            nextNode = nextNode.next;
            return data;
        }
    }



    @Override
    public Iterator iterator(){
        return new DListIterator();
    }


}

