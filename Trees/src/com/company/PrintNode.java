package com.company;

public class PrintNode<E> implements BinaryTreeNode.Visitor<E> {
    public void visit(BinaryTreeNode<E> node){
        System.out.println(node);
    }
}
