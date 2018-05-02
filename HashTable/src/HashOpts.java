/**
 * This reads command line arguments for SpellChecker3
 *
 * Useage:
 *    java SpellChecker3 tableSize dictionary.txt text.txt
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Apr. 22, 2018
 */

public class HashOpts{
    private String dFile = null;   // dictionary file name
    private String tFile = null;   // text file name
    private int tableSize = 11;    // hash table size
    private boolean isOK = false;  // true if args are OK, false othrwise


    /**
     * Parse the command line arguments
     * @param args
     */
    public HashOpts(String[] args) {
        // if only two Strings, the use default table size
        if(args.length == 2){  
            dFile = args[0];
            tFile = args[1];
            isOK = true;  
        }  
        else if(args.length > 2){  
            tableSize = Integer.parseInt(args[0]);
            dFile = args[1];
            tFile = args[2];
            isOK = true;  
        }  
        else{
            System.out.println("Usage: java program [tableSize] dictionaryFile fileToCheck ");
            System.out.println("  tableSize       size of hash tables ");
            System.out.println("  dictionaryFile  file containing correct words ");
            System.out.println("  fileToCheck     file to spell check ");
        }
    }


    /**
     * Return the table size
     * @return int, the table size
     */
    public int getTableSize(){
        return tableSize;
    }


    /**
     * Return the dictionary file name
     * @return String, the dictionary file name
     */
    public String getDictionaryFileName(){
        return dFile;
    }


    /**
     * Return the text file name
     * @return String, the text file name
     */
    public String getTextFileName(){
        return tFile;
    }


    /**
     * Return is the command line arguments are correct, false otherwise
     * @return booleam, true is command line arguments are correct, false otherwise
     */
    public boolean isOK(){
        return isOK;
    }
}  
