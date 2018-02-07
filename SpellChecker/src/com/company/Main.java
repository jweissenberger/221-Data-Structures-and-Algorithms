/*
 * Jack Weissenberger Febuary 2018
 * Spell Checker that reads in a text file(text.txt) and a dictionary file(dictionary.txt) that compares every word in
 * the text file to the dictionary and outputs the number of words, number of unique words and prints all of the
 * misspelled words
 ********NOTE******** I HAVE THE DICTIONARY AS MY FIRST ARGUMENT AND THE TEXT FILE AS MY SECOND ARGUMENT, THE PROGRAM
 * WILL NOT RUN PROPERLY IF THEY ARE SWITCHED
 */


package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    //method that reads and checks the dictionary
    private static boolean checkDict(String[] args, String word){
        /*
         * Function that reads the dictionary and outputs a boolean True if the word is in the dictionary and false if
         * is not
         * Inputs: String [] args: the documents including the dictionary as the first argument
         *         String word: the word that will be checked against the words in the dictionary
         *
         * Outputs: a boolean that is true if the word is in the dictionary and false if it is not
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
            Scanner input = new Scanner(new File(args[0])); //to open another file need to use args[1]
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

        //Initialize variables and ArrayLists
        int numWords = 0;
        long numUWords = 0;
        int misspelled = 0;
        ArrayList<String> Words = new ArrayList<>();
        ArrayList<String> MWords = new ArrayList<>();


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
            Scanner input = new Scanner(new File(args[1])); //scanner for the second argument

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
                            MWords.add(word);
                        }

                        //adds the word to the arrayList of all words
                        Words.add(word);
                        numWords += 1;
                        word = "";
                    }

                    // case when there is a word at the end of the file
                    if (Character.isLetter(line.charAt(i)) && (i == line.length() - 2)) {
                        word = word + line.charAt(i+1);
                        word = word.toLowerCase();
                        if (!checkDict(args, word)){
                            misspelled += 1;
                            MWords.add(word);
                        }
                        Words.add(word);

                        numWords += 1;
                    }
                }

            }

                input.close();
        }

        catch (FileNotFoundException e){
            System.exit(2);
        }

        System.out.println("Number of Words: " + numWords);

        //counts the number of unique words by converting the arraylist to a stream and then counts only the distinct
        //elements
        numUWords = Words.stream().distinct().count();
        System.out.println("Number of Unique Words: " + numUWords);

        System.out.println("Number of Misspelled Words" + misspelled);

        System.out.println("Misspelled Sords: ");
        for (int i = 0; i < misspelled; i++){
            System.out.println(MWords.get(i));
        }


    }



}

