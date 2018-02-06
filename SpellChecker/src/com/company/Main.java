package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            for (int i = 0; i < args.length; i++){
                System.out.println(args[i] + " ");
                if (args.length != 2){ //the number of files you want to read
                    System.out.println("ussage error ...");
                    System.exit(1);
                }

            }

            try {
                Scanner input = new Scanner(new File(args[1])); //to open another file need to use args[1]
                //and separate the arguments by a space in run-edit configurations
                while (input.hasNext()){
                    String line = input.nextLine();
                    System.out.println(line);
                }

                input.close();
            }

            catch (FileNotFoundException e){
                System.exit(2);
            }

        /*
        Scanner inFile = null;
        FileInputStream myDict = null;

@ -15,6 +25,6 @@ public class Main {
        String word1 = inFile.nextLine();

        System.out.println(word1);

        */

    }
}

