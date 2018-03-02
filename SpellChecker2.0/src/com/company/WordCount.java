/*
 * This is the WordCount Class that stores the node data and count information
 */
package com.company;

public class WordCount{

    private String data = "";
    private int count = 0;


    public void setData(String data){
        //this sets the data of the node
        //inputs: String data: what you want to set the data to
        this.data = data;
    }

    public String getData(){
        //this retrieves the data of the node
        return data;
    }

    public void incr(){
        //this increments the count of the node
        count += 1;
    }

    public void setCount(int i){
        //this sets the count of the node
        count = i;
    }

    public int getCount(){
        //this retrives the count of the node
        return count;
    }

    public String toString(){
        //this prints out the information given in the node
        return getData() + " " + getCount();
    }

    public int compareTo(WordCount wc){
        /* Compares calling object to the argument wc
         * returns the difference in counts
         * will be positive if the calling object has a larger count and negative if not
         *
         */

        return getCount() - wc.getCount();
    }

}
