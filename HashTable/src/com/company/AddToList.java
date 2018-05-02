package com.company;

public class AddToList<E> implements BinaryTreeNode.Visitor<E> {

    //initialize variables
    private E[] list;
    int i = 0;

    //constructor
    public AddToList(E[] list){
        this.list = list;
    }

    //visit each node in the list
    @Override
    public void visit(BinaryTreeNode<E> node){
        if(list != null && list.length != 0){
            list[i] = node.getData();
            i++;
        }
    }
}
