package com.company;
import java.util.Comparator;

public class BinarySearchTree<E> {

    //root
    protected BinaryTreeNode<E> root = null;

    //comparator used to order the items in the tree
    private Comparator<E> comparator;

    //constructs an empty BST that can only accept comparables as items
    public BinarySearchTree(){
        this(null);
    }

    //constructs a BST that orders its items according to the given comparator
    public BinarySearchTree(Comparator<E> c){
        comparator = c;
    }

    //returns whether or not the tree contains an object with the given value
    public boolean contains(E data){
        return nodeContaining(data) != null;
    }

    //adds a single data item to the tree, can overide
    public void add(E data){
        if (root == null){
            root = new LinkedBinaryTreeNode<E>(data);
        }
        BinaryTreeNode<E> n = root;
        while (true){
            int comparisonResult = compare(data, n.getData());
            if(comparisonResult == 0){
                n.setData(data);
                return;
            }
            else if (comparisonResult < 0){
                if(n.getLeft() == null){
                    n.setLeft(new LinkedBinaryTreeNode<E>(data));
                    return;
                }
                n = n.getLeft();
            }

            else{
                if(n.getRight() == null){
                    n.setRight(new LinkedBinaryTreeNode<E>(data));
                    return;
                }
                n = n.getRight();
            }
        }
    }

    //removes the node with the given data
    public void remove(E data){
        // find the node containing the data
        BinaryTreeNode<E> node = nodeContaining (data);
        if( node == null ){ return;}// No such object , do nothing
        else if( node.getLeft()!= null && node.getRight()!= null ){
            // Node has two children , we cannot delete it . Copy
            // predecessor data and prepare to delete predecessor
            BinaryTreeNode<E> predecessor = predecessor(node);
            node.setData(predecessor.getData());
            node = predecessor;
        }
        BinaryTreeNode<E> pullUp = (node.getLeft() == null)?node.getRight():node.getLeft();
        if(node == root){ setRoot(pullUp);}
        else if(node.getParent().getLeft()==node){
            node.getParent().setLeft(pullUp);
        }
        else{
            node.getParent().setRight(pullUp);
        }
    }

    //returns the root of the tree
    protected BinaryTreeNode getRoot(){
        return root;
    }

    protected void setRoot(BinaryTreeNode<E> node){
        if(node != null) node.removeFromParent();
        root = node;
    }

    //returns the rightmost node in the left subtree
    protected BinaryTreeNode<E> predecessor(BinaryTreeNode<E> node){
        BinaryTreeNode<E> n = node.getLeft();
        if(n != null){
            while(n.getRight() != null){
                n = n.getRight();
            }
        }
        return n;
    }

    //helper method that returns node containing data
    protected BinaryTreeNode<E> nodeContaining(E data){
        for(BinaryTreeNode<E> n = root; n !=null;){
            int comparisonResult = compare(data, n.getData());
            if (comparisonResult == 0){
                return n;
            }
            else if (comparisonResult < 0) {
                n = n.getLeft();
            }
            else
                n = n.getRight();
        }
        return null;
    }

    //comparison method
    protected int compare (E x, E y){
        if (comparator == null){
            return ((Comparable<E>)x).compareTo(y);
        }
        else{
            return comparator.compare(x,y);
        }
    }

    //rotate left around the given node
    protected void rotateLeft(BinaryTreeNode<E> n){
        if (n.getRight() == null){return;}
        BinaryTreeNode<E> oldRight = n.getRight();

        //set right child of n (piv
        n.setRight(oldRight.getLeft());

        //determine if rotated around BST root
        if(n.getParent() == null){root = oldRight;}
        else if (n.getParent().getLeft() == n){n.getParent().setLeft(oldRight);}
        else{
            n.getParent().setRight(oldRight);
        }

        //set left child of R to n (the pivot)
        oldRight.setLeft(n);
    }

    //rotate right around the given node
    protected void rotateRight(BinaryTreeNode<E> n){
        if (n.getLeft() == null){return;}
        BinaryTreeNode<E> oldLeft = n.getLeft();

        //set right child of n
        n.setRight(oldLeft.getRight());

        //determine if rotated around BST root
        if(n.getParent() == null){root = oldLeft;}
        else if (n.getParent().getRight() == n){n.getParent().setRight(oldLeft);}
        else{
            n.getParent().setLeft(oldLeft);
        }

        //set left child of R to n (the pivot)
        oldLeft.setRight(n);
    }



}
