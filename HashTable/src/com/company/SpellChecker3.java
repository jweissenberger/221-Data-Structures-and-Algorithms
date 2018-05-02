/**
 * This program spell checks a file compared to a given dictionary, then counts
 * and lists the total, misspelled and unique words
 *
 * Useage:
 *    java SpellChecker3 tableSize dictionary.txt text.txt
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Apr. 22, 2018
 */

package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class SpellChecker3{

    /**
     * main method, where the magic starts...
     *
     * @param args String[] first is table siz, dictionary, then text file
     */

    public static void main(String[] args) {

        AVLHashSet<String> words = new AVLHashSet<>();

        words.add("aa");
        words.add("aa");
        words.add("bb");
        words.add("cc");

    }
        /*
        AVLHashSet<String> dictionary;  // set of dictionary words
        AVLHashSet<String> misspelled;  // set of mispelled words
        int numWords = 0;               // number of words in the file
        HashOpts hashOpts = new HashOpts(args);  // command line arguments

        // make certain command line args are correct
        if(!hashOpts.isOK())
            System.exit(1);

        dictionary = new AVLHashSet<String>(hashOpts.getTableSize());
        misspelled = new AVLHashSet<String>(hashOpts.getTableSize());

        // reading dictionary file
        try{
            Scanner input = new Scanner(new File(hashOpts.getDictionaryFileName()));
            while (input.hasNext()){
                String line = input.nextLine();
                processDictionaryLine(line, dictionary);
            }
            input.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error in opening dictionary file.");
            e.printStackTrace();
            System.exit(1);
        }

        final long startTime = System.currentTimeMillis();
        // reading text file (to be spell checked)
        try{
            Scanner input = new Scanner(new File(hashOpts.getTextFileName()));
            while (input.hasNext()){
                String line = input.nextLine();
                numWords += processTextLine(line, dictionary, misspelled);
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error in opening text file.");
            // Some useful commands…
            e.printStackTrace();
            System.exit(1);
        }
        final long endTime = System.currentTimeMillis();

        // print the results to the screen
        System.out.println("words: " + numWords + ", misspelled: " + misspelled.getSize());
        System.out.println("time to complete check: " + (endTime - startTime) + " msec ");

        // covert misspelled hash table to list, sort, then print to file
        String[] list = misspelled.toArray(new String[misspelled.getSize()]);
        Arrays.sort(list);
        String fdFile = hashOpts.getTextFileName() + ".miss";
        try{
            PrintWriter writer = new PrintWriter(new FileWriter(fdFile));
            for(String word : list)
                writer.println(word);
            writer.close();
        }
        catch(IOException e) {
            System.out.println("Error in writing text misspelled file.");
            // Some useful commands…
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("misspelled words written to: " + fdFile);
    }


    /**
     * Process a line from the text file, which can consist of multiple words
     * compare each word to the dictionary and add to the appropriate lists
     *
     * @param aLine String a line from the file
     * @param dictionary hash table of dictionry words
     * @param misspelled hash table of misspelled words
     * @return an int representing the number of words found in the line
     */

        /*
    private static int processTextLine(String aLine, AVLHashSet<String> dictionary, AVLHashSet<String> misspelled){
        int numWords = 0;
        // remove punctuation
        aLine = aLine.replaceAll("[\\W]", " ").toLowerCase();
        String [] allWords = aLine.split("[ ]+");
        for(String word : allWords){
            if(word.length() > 0) {
                numWords++;
                // if not in dictionary and not already in the misspelled list
                if(!dictionary.contains(word) && !misspelled.contains(word)) {
                    misspelled.add(word);
                }
            }
        }
        return numWords;
    }


    /**
     * Process a line from the dictionary file, where each line is one word,
     * adding it to the dictionary list
     *
     * @param line String line from the dictionary
     * @param dictionary list of dictionary words
     */

        /*
    private static void processDictionaryLine(String line, AVLHashSet<String>dictionary){
        // assuming each line is a word
        line = line.replaceAll(" ", "").toLowerCase();
        if(line.length() > 0 && !dictionary.contains(line))
            dictionary.add(line);
    }

    */
}


