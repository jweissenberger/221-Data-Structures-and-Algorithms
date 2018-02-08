package com.company;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLinkedList implements Iterable<String> {

    private static class Node{
        private String data;
        private Node next;
        private Node prev;
        private int indx;

        public Node(String data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
            indx = 0;
        }
    }

    Node head;
    Node tail;
    public int size =0;

    public DLinkedList(){
        head = null;
        tail = null;
    }

    public void addFirst(String data){
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
        if (head.data.equals(data)){
            return head.indx;
        }
        Node second = head.next;
        while (second !=null){
            if (second.data.equals(data)){
                return second.indx;
            }
            second = second.next;
        }
        return -1;
    }

    public boolean contains(String data){
        if (head.data.equals(data)){
            return true;
        }
        Node second = head.next;
        while (second !=null){
            if (second.data.equals(data)){
                return true;
            }
            second = second.next;
        }
        return false;
    }

    public String toString(){
        String all = head.data;
        Node second = head.next;
        while (second !=null){
            all = all.concat(second.data);
            second = second.next;
        }

        return all;

    }


    public void printIndx(){
        System.out.println(head.indx);
        Node second = head.next;
        while (second !=null){
            System.out.println(second.indx);
            second = second.next;
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

    public int size(){
        return size;
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

