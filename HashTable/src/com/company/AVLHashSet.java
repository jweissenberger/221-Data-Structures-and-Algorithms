package com.company;

import java.util.ArrayList;

public class AVLHashSet<E> {

    //int[] userVals = new int[NUM_ELEMENTS];
    //ArrayList<Integer> arr=new ArrayList<Integer>(10);
    private ArrayList<AVLTree<E>> table;
    private int size = 0;

    public AVLHashSet(){
        table = new ArrayList<AVLTree<E>>(11);
    }

    public AVLHashSet(int size){
        table = new ArrayList<AVLTree<E>>(size);
    }

    public boolean add(E data){
        //hash the data
        int hash = 7;
        if(data.getClass().getSimpleName().equals("String")){
            for (int i = 0; i < data.length(); i++) {
                hash = hash*31 + charAt(i);
            }

        }
        else {
            hash = (int)(data) * 31;
        }
        int index = hash%table.size();
        int s1 = table.get(index).size;
        table.get(index).add(data);
        int s2 = table.get(index).size;

        //if the tree is the same size data was not added, so return false
        if(s1 == s2){
            return false;
        }
        //if the tree is a different size then the data was added so return true
        else{
            size +=1;
            return true;
        }
    }


    public int getSize(){
        return size;
    }


    public E[] toArray(E[] list){



        return list;
    }


}
