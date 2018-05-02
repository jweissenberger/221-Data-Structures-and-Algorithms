package com.company;

public class AVLHashSet<E> {

    //initialize the array of AVL trees
    private AVLTree<E>[] table;
    private int size = 0;

    //Null constructor that initializes the size of the array to 11
    public AVLHashSet(){
        table = new AVLTree[11];
    }

    //constructor that sets the size of the array
    public AVLHashSet(int size){
        table = new AVLTree[size];
    }

    //hashes the data and then stores the information into an AVL tree
    public boolean add(E data){
        //hash the data
        int hash = Math.abs(data.hashCode());
        int index = hash%table.length;

        //creates a new tree if one has not already been created
        if(table[index] == null){
            table[index] = new AVLTree<>();
        }

        //checks the size of the tree before and after we try to add an item so that we can see if it is added
        int s1 = table[index].size;
        table[index].add(data);
        int s2 = table[index].size;

        if (s1 == s2){return false;}

        else{
            size++;
            return true;
        }

    }

    //returns the size of the hash table
    public int getSize(){
        return size;
    }

    //checks to see if the inputted data is in the hash table
    public boolean contains(E data){
        int hash = Math.abs(data.hashCode());
        int index = hash%table.length;

        if(table[index] == null){
            return false;
        }
        else{ return table[index].contains(data);}

    }

    //converts the hashtable into an array by traversing each node of the table and then printing out the tree at each
    public E[] toArray(E[] list){

        AddToList<E> visitor = new AddToList<E>(list);

        for (int i = 0; i < table.length; i++){
            if (table[i] != null) {
                table[i].getRoot().traverseInorder(visitor);
            }
        }
        return list;
    }


}
