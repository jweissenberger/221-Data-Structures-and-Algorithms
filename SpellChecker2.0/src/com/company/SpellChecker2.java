/*
 * Jack Weissenberger March 2018
 * SpellChecker 2.0
 * Spellchecker checks a text file for words and compares it to a dictionary file.
 * The dictionary file is stored in an auto updating doubly linked list that uses the transpose or count method
 * depending on if your first command line argument it "-c" for count "-t" for transpose or "-s" or nothing for a regular
 * non-self updating list
 */

package com.company;
import java.util.Scanner;
import java.io.*;

public class SpellChecker2 {

    public static void main(String[] args) {
        //Initialize variables, Doubly linked list
        int numWords = 0;
        int misspelled = 0;
        WCLinkedList UWords = new WCLinkedList();
        WCLinkedList MisWords = new WCLinkedList();
        WCLinkedList dictionary = new WCLinkedList();
        int n = 0;


        //Handels tha exception that there are not to files as arguments
        for (int i = 0; i < args.length; i++){
            if (args.length < 2){ //the number of files you want to read
                System.out.println("ussage error ...");
                System.exit(1);
            }
        }

        //these next three if statements determine what kind of linked list is used for the dictionary and misspelled
        //words, it also updates the variable n that allows the correct argument to be accessed later on in the code
        if (args[0].equals("-t")){
            dictionary = new TWCLinkedList();
            MisWords = new TWCLinkedList();
            n = 1;
        }

        if (args[0].equals("-c")){
            dictionary = new CWCLinkedList();
            MisWords = new CWCLinkedList();
            n = 1;
        }

        if (args[0].equals("-s")){
            dictionary = new WCLinkedList();
            MisWords = new WCLinkedList();
            n = 1;
        }


        //Read the dictionary file into the dictionary list
        try {
            Scanner input = new Scanner(new File(args[n])); //reading in the dictionary
            //and separate the arguments by a space in run-edit configurations
            while (input.hasNext()) {
                String line = input.nextLine();
                line = line.toLowerCase();

                dictionary.addLast(line);

            }

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(2);
        }


        //starts timing the spellchecker
        final long startTime = System.currentTimeMillis();

        //try block for opening and reading the text file
        try {
            Scanner input = new Scanner(new File(args[n+1])); //scanner for the second argument, which for me is

            //reads the next input
            while (input.hasNext()) {
                String line = input.nextLine();

                //initializes a empty string variable for a word
                String word = "";

                //uses .isLetter to check if the character is a letter and then creates a word with a set of characters
                for (int i = 0; i < (line.length()-1); i++) {
                    if (Character.isLetter(line.charAt(i)) || Character.isDigit(line.charAt(i))) {
                        word = word + line.charAt(i);
                    }

                    //this represents the end of a word
                    if ((!Character.isLetter(line.charAt(i + 1)) && !Character.isDigit(line.charAt(i + 1))) && (Character.isLetter(line.charAt(i)) || Character.isDigit(line.charAt(i)))) {
                        word = word.toLowerCase();

                        //check if the word is in the dictionary
                        if (!dictionary.contains(word)){
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
                        if (!dictionary.contains(word)){
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
            System.out.println("File not found");
            System.exit(2);
        }

        //ends the timer
        final long endTime = System.currentTimeMillis();

        //this is the try and catch blocks for the writing of the output file of the dictionary with the number of counts
        try {
            FileOutputStream fileByteStream = new FileOutputStream("final." + args[n]);
            PrintWriter outFS = new PrintWriter(fileByteStream);
            for (String data : dictionary){
                outFS.println(data);
            }
            outFS.flush();
            fileByteStream.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(2);
        }
        catch (IOException e){
            System.out.println("IOException");
            System.exit(7);
        }

        //these are the print statements that give the statistics of the file

        System.out.println("\n" + "Number of Words: " + numWords);

        //print the number of unique words by printing the size of the UWords list
        System.out.println("Number of Unique Words: " + UWords.size);

        System.out.println("Number of Misspelled Words: " + misspelled);

        System.out.println("Time to complete: " + (endTime-startTime) + " msec");

        System.out.println("Managed dictionary written to: final." + args[n]);



    }
}
