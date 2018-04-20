package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inventory {

    public static void main(String[] args) {

        BinarySearchTree<String> BST = new BinarySearchTree<>();
        AVLTree<String> AVL = new AVLTree<>();

        //Read the invent.dat file
        try {
            Scanner input = new Scanner(new File(args[0])); //reading in the file



            while (input.hasNext()) {
                String line = input.nextLine();
                line = line.toUpperCase();
                String[] parsed = line.split("\\s+");

                if(parsed[0].equals("A")){
                    BST.add(parsed[1]);
                    AVL.add(parsed[1]);
                }
                else if (parsed[0].equals("D")){
                    BST.remove(parsed[1]);
                    AVL.remove(parsed[1]);
                }
                else{
                    System.out.println("Illegal Argument");
                    throw new IllegalArgumentException();
                }


            }


            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(2);
        }

        System.out.println("Number of inventory Updates: " + BST.updates);

        System.out.println("\nBST, tree size: " + BST.size+ ", Height: " + BST.getHeight(BST.root));
        BST.getRoot().printTree();
        System.out.println("\n \nAVL, tree size: " + BST.size + ", Height: " + AVL.getHeight(AVL.getRoot()));
        AVL.getRoot().printTree();


    }
}
