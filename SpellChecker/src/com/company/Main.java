package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < args.length; i++){
            System.out.println(args[i] + " ")
            if (args.length != 1){
                System.out.println("ussage error ...");
                System.exit(1);
            }

        }

        /*
        Scanner inFile = null;
        FileInputStream myDict = null;

        myDict = new FileInputStream("./resources/dictionary.txt");

        inFile = new Scanner(myDict);
        String word1 = inFile.nextLine();

        System.out.println(word1);
        */
    }
}
