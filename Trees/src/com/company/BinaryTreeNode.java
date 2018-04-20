package com.company;
import java.util.List;

public interface BinaryTreeNode<E> {

    //Returns data stored in node
    E getData();

    //Replaces data object stored in this node with data
    void setData(E data);

    //Returns the parent of this node, or null if root
    BinaryTreeNode<E> getParent();

    //returns the left child of this node, or null if none
    BinaryTreeNode<E> getLeft();

    //returns right child of this node, null if none
    BinaryTreeNode<E> getRight();

    /*
     * Removes child from its current parent and inserts it as the left child of this node. If this node already has a
     * left child, it is removed
     * @exception IllegalArgument Exception if the child is an ancestor
     */
    void setLeft(BinaryTreeNode<E> child);

    /*
     * Removes child from its current parent and inserts it at the right child of node, remove existing left child
     * @exception IllegalArgumentException if child is ancestor
     */
    void setRight(BinaryTreeNode<E> child);

    //removes this node and all its descendants from tree
    void removeFromParent();

    //Visitor pattern used by traversals to process
    public interface Visitor<E>{
        void visit(BinaryTreeNode<E> node);
    }

    //visits the nodes in this tree in preorder
    void traversePreorder(Visitor<E> visitor);

    //visits the nodes inorder
    void traverseInorder(Visitor<E> visitor);

}
