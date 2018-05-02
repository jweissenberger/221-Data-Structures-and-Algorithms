package com.company;
import java.util.Comparator;

//AVL class code

public class AVLTree<E> extends BinarySearchTree<E> {

    //constructs an empty AVL that only accepts Comparables
    public AVLTree(){
        this(null);
    }

    //constructs an AVL that orders its items according to the given comparator
    public AVLTree(Comparator<E> c){
        super(c);
    }

    //adds a single item to the AVL tree, can overwrite
    @Override
    public void add(E data){
        super.add(data);
        //find the new node containing the data
        BinaryTreeNode<E> n = nodeContaining(data);
        //if there is a new node, then rebalance
        if(n != null){
            rebalance(n);
        }
    }

    //removes node containing data
    @Override
    public void remove(E data){
        //find the node containing the data
        BinaryTreeNode<E> n = nodeContaining(data);

        if(n != null){
            if(n.getLeft() != null && n.getRight()!= null){
                n = predecessor(n).getParent();
                super.remove(data);
                rebalance(n);
            }
            else{
                n = n.getParent();
                super.remove(data);
                rebalance(n);
            }
        }
    }

    //method that returns the height given a node
    protected int getHeight(BinaryTreeNode<E> n){
        if(n == null){
            return -1;
        }
        else{
            int leftD = getHeight(n.getLeft());
            int rightD = getHeight(n.getRight());
            if(leftD > rightD){
                return leftD +1;
            }
            else {
                return rightD +1;
            }
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

                if (heightDiff < 0) {
                    rotateLeft(node);
                }

                else{
                    rotateRight(node.getRight());
                    rotateLeft(node);
                }

            }

            node = node.getParent();
        }
    }


}
