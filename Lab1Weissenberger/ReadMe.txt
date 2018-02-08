Jack Weissinberger
Lab1 Doubly Linked List ReadMe

SpellChecker:
reads in a text file(text.txt) and a dictionary file(dictionary.txt) that compares every word in
the text file to the dictionary and outputs the number of words, number of unique words, number of misspelled words
and prints all of the misspelled words which are stored in a doubly linked list.

****NOTE**** The dictionary text file must be the first (0th) argument and the text file must be the second (1st) argument 
for the program to work correctly.

The program works by reading in characters of the text file, finding a word, checking that word against the words in the
dictionary file and then adding it to the list of misspelled words if it is not found in the dictionary. These are stored
in the doubly linked list. Checking the dictionary is done using the checkDict method. After each word is found in the number
of words is incremented by one, that word is stored into the ArrayList Words and if the word is misspelled, it is added to the
doubly linked list and the number of misspelled words is incremented by one. The number of unique words are calculated by
checking the size of the UWords Doubly linked list which adds a new word to the list when if it is not contained already.
The number of words, unique words, and misspelled words are all printed to the user. The misspelled words are then printed 
by using the enhanced for loop of the doubly linked list.

Doubly Linked List:
The DLinkedList.java contains a class DLinkedList that is a doubly linked list. It contains the following: Node, isEmpty(),
contains() size(), indexOf(), addFirst(), and toString(). It also contains an Iterator interface the supports enhanced 
for loops.
