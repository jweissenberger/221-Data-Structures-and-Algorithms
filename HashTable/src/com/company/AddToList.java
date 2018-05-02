package com.company;

public class AddToList<E> implements BinaryTreeNode.Visitor<E> {

    public E[] list;
    int i = 0;

    public AddToList(E[] list){
        this.list = list;
    }

    @Override
    public void visit(BinaryTreeNode<E> node){
        if(list != null && list.length != 0){
            list[i] = node.getData();
            i++;
        }
    }
}
