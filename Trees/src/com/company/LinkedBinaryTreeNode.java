package com.company;

public class LinkedBinaryTreeNode<E> implements BinaryTreeNode<E> {

    protected E data;
    protected LinkedBinaryTreeNode<E> parent;
    protected LinkedBinaryTreeNode<E> left;
    protected LinkedBinaryTreeNode<E> right;

    //constructs a node as root of its own one-element tree
    public LinkedBinaryTreeNode(E data){
        this.data = data;
    }

    //returns the data stored in this node
    public E getData(){return data; }

    //modifies the data stored in this node
    public void setData(E data){
        this.data = data;
    }

    //returns the parent of this node, or null if root
    public BinaryTreeNode<E> getParent() {
        return parent;
    }

    //returns left child of this node or null if none
    public BinaryTreeNode<E> getLeft(){
        return left;
    }

    //returns right child of this node or null if none
    public BinaryTreeNode<E> getRight(){
        return right;
    }

    /*
     * Removes child from its current parent and inserts it as the left child of this node. If this node already has a
     * left child then it is removed.
     * @exception IllegalArgumentException if the child is an ancestor fo this node
     */
    public void setLeft(BinaryTreeNode<E> child){
        //ensure the child is not an ancestor
        for(LinkedBinaryTreeNode<E> n = this; n!= null; n = n.parent) {
            if (n == child) {
                throw new IllegalArgumentException();
            }
        }

        //ensure child is instance of LinkedBinaryTreeNode
        LinkedBinaryTreeNode<E> childNode = (LinkedBinaryTreeNode <E>) child;

        //break old links, then reconnect properly
        if(this.left != null){
            left.parent = null;
        }
        if(childNode != null){
            childNode.removeFromParent();
            childNode.parent = this;
        }

        this.left = childNode;


    }

    /*
     * Removes child from its current parent and inserts it as the right child of this node. If this node already has a
     * right child then it is removed.
     * @exception IllegalArgumentException if the child is an ancestor fo this node
     */
    public void setRight(BinaryTreeNode<E> child){
        //ensure the child is not an ancestor
        for(LinkedBinaryTreeNode<E> n = this; n!= null; n = n.parent) {
            if (n == child) {
                throw new IllegalArgumentException();
            }
        }

        //ensure child is instance of LinkedBinaryTreeNode
        LinkedBinaryTreeNode<E> childNode = (LinkedBinaryTreeNode <E>) child;

        //break old links, then reconnect properly
        if(this.right != null){
            right.parent = null;
        }
        if(childNode != null){
            childNode.removeFromParent();
            childNode.parent = this;
        }

        this.right = childNode;


    }

    //removes node and all descendants from tree, nothing if node is root
    public void removeFromParent(){
        if(parent != null){
            if(parent.left == this){
                parent.left = null;
            }
            else if(parent.right == this){
                parent.right = null;
            }
            this.parent = null;
        }
    }

    //visits the nodes in this tree in preorder
    public void traversePreorder(BinaryTreeNode.Visitor<E> visitor){
        visitor.visit(this);
        if(left != null){
            left.traversePreorder(visitor);
        }

        if(right != null){
            right.traversePreorder(visitor);
        }
    }

    //visits the nodes in post order
    public void traversePostorder(BinaryTreeNode.Visitor<E> visitor){
        if(left != null) left.traversePostorder(visitor);
        if(right != null) right.traversePostorder(visitor);
        visitor.visit(this);
    }

    //visits nodes in order
    public void traverseInorder(BinaryTreeNode.Visitor<E> visitor){
        if(left != null) left.traverseInorder(visitor);
        visitor.visit(this);
        if(right!= null) right.traverseInorder(visitor);
    }

    //prints data of current node
    @Override
    public String toString(){
        return data.toString();
    }

    public void printTree(){
        System.out.print("(");
        if (this.left !=null){
            this.left.printTree();
        }
        System.out.print(this.data);

        if(this.right != null){
            this.right.printTree();
        }
        System.out.print(")");
    }
}
