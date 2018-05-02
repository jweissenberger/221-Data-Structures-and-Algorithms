package com.company;

public class AddToList<E> implements BinaryTreeNode.Visitor<E> {

    @Override
    public void visit(BinaryTreeNode<E> node){
        node.getData();
    }
}
