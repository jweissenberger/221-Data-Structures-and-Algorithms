package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner inFile = null;
        FileInputStream myDict = null;

        myDict = new FileInputStream("./resources/dictionary.txt");

        inFile = new Scanner(myDict);
        String word1 = inFile.nextLine();

        System.out.println("word1");

    }
}
