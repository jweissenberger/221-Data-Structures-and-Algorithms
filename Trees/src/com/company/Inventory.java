package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inventory {

    public static void main(String[] args) {

        BinarySearchTree<String> BST = new BinarySearchTree<>();

        //Read the invent.dat file
        try {
            Scanner input = new Scanner(new File(args[0])); //reading in the file



            while (input.hasNext()) {
                String line = input.nextLine();
                line = line.toLowerCase();
                String[] splited = line.split("\\s+");
                System.out.println(splited[0]);

                if(splited[0] == "a"){
                    //check contains
                    BST.add(splited[1]);
                }
                else if (splited[0] == "d"){
                    //check contains
                    BST.remove(splited[1]);
                }
                else{
                    System.out.println("Illegal Argument");
                    throw new IllegalArgumentException();
                }


                //once you do all your work do this
                splited = null;
            }


            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(2);
        }


    }
}
