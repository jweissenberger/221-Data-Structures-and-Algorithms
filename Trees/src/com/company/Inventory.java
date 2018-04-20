package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inventory {

    public static void main(String[] args) {

        //Handels tha exception that there is not a file inputted
        for (int i = 0; i < args.length; i++){
            if (args.length == 0){ //the number of files you want to read
                System.out.println("ussage error ...");
                System.exit(1);
            }
        }

        //Read the invent.dat file
        try {
            Scanner input = new Scanner(new File(args[0])); //reading in the file

            while (input.hasNext()) {
                String line = input.nextLine();
                line = line.toLowerCase();
                String[] splited = line.split("\\s+");
                System.out.println(splited[0]);

                //splited[0] will have the add or delete
                //splited[1] will have the data you're putting into the node


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
