package com.company;

public class AVLHashSet<E> {

    private AVLTree<E>[] table = null;
    //int intArray[];    //declaring array
    //intArray = new int[20];  // allocating memory to array
    private int size = 0;

    public AVLHashSet(){
        table = new AVLTree[11];
    }

    public AVLHashSet(int size){
        table = new AVLTree[size];
    }

    public boolean add(E data){
        //hash the data
        int hash = data.hashCode();
        hash = Math.abs(hash);
        int index = hash%table.length;

        if(table[index] == null){
            table[index] = new AVLTree<>();
        }
        int s1 = table[index].size;
        table[index].add(data);
        int s2 = table[index].size;

        if (s1 == s2){return false;}

        else{
            size++;
            return true;
        }

    }


    public int getSize(){
        return size;
    }

    public boolean contains(E data){
        int hash = data.hashCode();
        hash = Math.abs(hash);
        int index = hash%table.length;

        if(table[index] == null){
            return false;
        }
        else{ return table[index].contains(data);}

    }


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
