package com.company;

public class Main {

    public static void main(String[] args) {
	    WordCount a = new WordCount("jack");
        a.incr();
        WordCount b = new WordCount("david");
	    System.out.println(a.compareTo(b));

	    WCLinkedList List1 = new WCLinkedList();

        List1.addLast("Jack");
        List1.addLast("David");
        List1.addLast("Kathleen");
        List1.addLast("Paul");
        for(String data : List1){
            System.out.println(data);
        }
    }
}
