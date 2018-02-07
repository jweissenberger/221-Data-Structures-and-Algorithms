/*
 * Jack Weissenberger February 2018
 * Double Linked List Project CS 221 Data Structures and Algorithms
 */

package com.company;



public class Main {

    public static void main(String[] args) {
	    DLinkedList List1 = new DLinkedList();

	    List1.addFirst("Jack");
        List1.addFirst("David");
	    System.out.println(List1.isEmpty());

	    for(String data : List1){
	        System.out.println(data);
        }

    }
}
