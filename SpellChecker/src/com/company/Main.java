package com.company;
import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(new File ("C:\\Users\\weisja15\\Documents\\GitHub\\221-Data-Structures-and-Algorithms\\SpellChecker\\src\\com\\company\\dictionary.txt"));

        String word1 = input.nextLine();

        System.out.println(word1);

    }
}
