package com.company;
import java.util.Comparator;

public class AVLTree<E> extends BinarySearchTree<E> {

    //constructs an empty AVL that only accepts Comparables
    public AVLTree(){
        this(null);
    }

    //constructs an AVL that orders its items according to the given comparator
    public AVLTree(Comparable<E> c){
        super(c);
    }

    //adds a single item to the AVL tree, can overwrite
    @Override
    public void add(E data){
        super.add(data);
        //find the new node containing the data
        BinaryTreeNode<E> n = nodeContaining(data);
        //if there is a new node, then rebalance
        if(n != null) rebalance(n);
    }

    @Override
    public void remove(E data){
        //find the node containing the data
        BinaryTreeNode<E> n = nodeContaining(data);

        if(n != null){
            //code here to determine the node n where the rebalance should start (done before removal)

            //remove node containing the data
            super.remove(data);
            //rebalance starting at n
            rebalance(n);
        }
    }

    protected void rebalance(BinaryTreeNode<E> node){
        //check every node until we reach root
        while(node != null){
            int heightDiff = getHeight(node.getLeft())-getHeight(node.getRight());

            //left rebalance
            if (heightDiff == 2){
                heightDiff = getHeight(node.getLeft().getLeft()) - getHeight(node.getLeft().getRight());

                if (heightDiff > 0) {//left-left
                    rotateRight(node);
                }

                //left - right
                else{
                    rotateLeft(node.getLeft());
                    rotateRight(node);
                }
            }

            //right rebalance
            else if(heightDiff == -2){
                heightDiff = getHeight(node.getRight().getLeft())-getHeight(node.getRight().getRight());

                //magic right right or right- left rotate code
            }

            node = node.getParent();
        }
    }




















}
