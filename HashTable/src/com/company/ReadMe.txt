Jack Weissenberger
Project 5, Spell Check v3.0

The purpose of this project is to use a hash table to store a dictionary of words, then check
the spelling of a textfile and print out a new textfile with all of the misspelled  words. 
The main is stored in SpellChecker3 which reads in commandline arguments setting the size of the
hash table, and reading in the dictionary and text file. HashOpts also helps read in the 
information. AVLHashSet adds words to the hashtable and then checks to see if words are within 
the table. AddToList contains the visitor that is used when converting the hash to an array. 
AVLTree is the class containing the information for the AVL tree. BinarySearchTree is the class
that defines the information for a BST on which AVL is built. BinaryTreeNode is an interface that
has the classes for a basic binary tree. BinarySearchTree implements them. LinkedBinaryTreeNode 
contains the basic information of a node in a binary tree.