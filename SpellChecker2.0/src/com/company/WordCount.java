package com.company;

public class WordCount{

    private String data = "";
    private int count = 0;


    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }

    public void incr(){
        count += 1;
    }

    public void setCount(int i){
        count = i;
    }

    public int getCount(){
        return count;
    }

    public String toString(){
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
