package com.company;

public class Main {

    public static void main(String[] args) {

	    CWCLinkedList List1 = new CWCLinkedList();

        List1.addLast("Jack");
        List1.addLast("David");
        List1.addLast("Kathleen");
        List1.addLast("Paul");
        List1.addLast("dart");
        List1.addLast("leaky");
        List1.addLast("sam");
        List1.contains("sam");
        /*
        for(String data : List1){
            System.out.println(data);
        }
        */
    }
}
