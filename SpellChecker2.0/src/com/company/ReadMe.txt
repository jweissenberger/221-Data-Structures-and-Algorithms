Jack Weissenberger
CS 221 Proj 2 SpellChecker 2.0

My project contains the files CWCLinkedList, SpellChecker2, TWCLinkedList, WCLinkedList
and WordCount. The purpose of this program is to create a spell checker that stores
the words of a dictionary in a self-updating list. This is done by reading a file using
command line arguments and storing the dictionary into a doubly linked list. This list
uses the transpose or count method depending on if your first command line argument it 
"-c" for count "-t" for transpose or "-s" or nothing for a regular non-self-updating
list. The base class for the doubly linked list is WCLinkedList, CWCLinkedList extends
this and contains the information for a count list, TWCLinkedList extends WCLinkedList
and contains the information for a transpose list. The WordCount file stores the count 
and string information of a node and all of the important getter and setter methods. 

While the dictionary is being checked, it is being timed so that we can compare the 
speed of the different lists. From my limited testing, the count list seems to work the
fastest. At the end of the program, an updated dictionary is printed to 
final."name of dictionary".txt that prints out the words of the dictionary and how many
times each word was called. 

**NOTE** The dictionary is has to come before the text file in the command line