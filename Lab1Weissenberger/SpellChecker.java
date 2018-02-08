/*
 * Jack Weissenberger February 2018, Lab 1 Spell Checker
 * Spell Checker that reads in a text file(text.txt) and a dictionary file(dictionary.txt) that compares every word in
 * the text file to the dictionary and outputs the number of words, number of unique words, number of misspelled words
 * and prints all of the misspelled words
 ********NOTE******** I HAVE THE DICTIONARY AS MY FIRST ARGUMENT AND THE TEXT FILE AS MY SECOND ARGUMENT, THE PROGRAM
 * WILL NOT RUN PROPERLY IF THEY ARE SWITCHED
 */


package com.company;
import java.io.*;
import java.util.Scanner;


public class Main {

    //method that reads and checks the dictionary
    private static boolean checkDict(String[] args, String word){
        /*
         * Method that reads the dictionary and outputs a boolean True if the word is in the dictionary and false if
         * is not
         * Inputs: String [] args: the documents including the dictionary as the first argument
         *         String word: the word that will be checked against the words in the dictionary
         *
         * Outputs: a boolean that is true if the word is in the dictionary and false if it is not
         *
         * ****NOTE**** THIS ASSUMES THAT THE DICTIONARY IS THE FIRST (0TH) ARGUMENT
         *
         */
        word = word.toLowerCase();

        for (int i = 0; i < args.length; i++){
            System.out.println(args[i] + " ");
            if (args.length != 2){ //the number of files you want to read
                System.out.println("ussage error ...");
                System.exit(1);
            }
        }

        try {
            Scanner input = new Scanner(new File(args[0])); //reading in the dictionary
            //and separate the arguments by a space in run-edit configurations
            while (input.hasNext()) {
                String line = input.nextLine();
                line = line.toLowerCase();

                if (word.equals(line)){
                    return true;
                }

            }

            input.close();
        }

        catch (FileNotFoundException e){
            System.exit(2);
        }
        return false;
    }


    public static void main(String[] args) {

        //Initialize variables, ArrayList and Doubly linked list
        int numWords = 0;
        int misspelled = 0;
        DLinkedList UWords = new DLinkedList();
        DLinkedList MisWords = new DLinkedList();


        //Handels tha exception that there are not to files as arguments
        for (int i = 0; i < args.length; i++){
            System.out.println(args[i] + " ");
            if (args.length != 2){ //the number of files you want to read
                System.out.println("ussage error ...");
                System.exit(1);
            }
        }

        //try block for opening and reading the text file
        try {
            Scanner input = new Scanner(new File(args[1])); //scanner for the second argument, which for me is

            //reads the next input
            while (input.hasNext()) {
                String line = input.nextLine();

                //initializes a empty string variable for a word
                String word = "";

                //uses .isLetter to check if the character is a letter and then creates a word with a set of characters
                for (int i = 0; i < (line.length()-1); i++) {
                    if (Character.isLetter(line.charAt(i))) {
                        word = word + line.charAt(i);
                    }

                    //this represents the end of a word
                    if (!Character.isLetter(line.charAt(i + 1)) && Character.isLetter(line.charAt(i))) {
                        word = word.toLowerCase();

                        //check if the word is in the dictionary
                        if (!checkDict(args, word)){
                            misspelled += 1;
                            MisWords.addFirst(word);
                        }

                        //if the word is not in the list of unique words add it
                        if (!UWords.contains(word)){
                            UWords.addFirst(word);
                        }

                        numWords += 1;
                        word = "";
                    }

                    // case when there is a word at the end of the file
                    if (Character.isLetter(line.charAt(i)) && (i == line.length() - 2)) {
                        word = word + line.charAt(i+1);
                        word = word.toLowerCase();
                        if (!checkDict(args, word)){
                            misspelled += 1;
                            MisWords.addFirst(word);
                        }

                        //if the word is not in the list of unique words add it
                        if (!UWords.contains(word)){
                            UWords.addFirst(word);
                        }

                        numWords += 1;
                    }
                }

            }

                input.close();
        }

        //catch for if the file is not found
        catch (FileNotFoundException e){
            System.exit(2);
        }

        System.out.println("\n" + "Number of Words: " + numWords);

        //print the number of unique words by printing the size of the UWords list
        System.out.println("Number of Unique Words: " + UWords.size);

        System.out.println("Number of Misspelled Words: " + misspelled);

        System.out.println("\n" + "Misspelled Words: " + "\n" + "-----------------");
        //prints out the misspelled words that was stored in the doubly linked list using an enhanced for loop
        for(String data : MisWords){
            System.out.println(data);
        }


    }



}

