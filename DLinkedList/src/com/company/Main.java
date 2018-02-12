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
        List1.addFirst("Kathleen");
        List1.addFirst("Paul");
	    System.out.println(List1.isEmpty());

	    for(String data : List1){
	        System.out.println(data);
        }

        System.out.println(List1.size);

	    //List1.printIndx();

        //System.out.println(List1.indexOf("blob"));
        System.out.println(List1.contains("Kathleen"));
        System.out.println(List1.toString());
        List1.swap();
        System.out.println(List1.toString());

    }
}
