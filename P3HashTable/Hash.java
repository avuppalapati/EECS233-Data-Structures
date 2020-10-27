package amv87.myCode;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Hash {

    //fields
    private ArrayList<LLNode> hashMap;

    //capacity of the hashmap
    private int capacity = 20;

    //size of the table
    private int size = 0;

    //constructor
    public Hash() {
        hashMap = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            hashMap.add(null);
        }
    }

    //this is to determine which bucket of the arraylist the word will go in
    public int whichBucket(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    //returns the arraylist of LLNodes that I use as my hashmap
    public ArrayList<LLNode> getHashMap() {
        return hashMap;
    }

    //looking up an item in the hashmap
    //this method is called on in the add method
    public boolean lookUp(String key) {
        int whichBucket = whichBucket(key);

        //gets the head of the LL at that bucket
        LLNode head = hashMap.get(whichBucket);

        //returns true if the key is already in the hashmap
        while (head != null) {
            if (head.getKey().equals(key)) {
                return true;
            }
            head = head.next;
        }
        //returns false if the key is not found in the hashmap
        return false;
    }

    //adding an item to the hashmap
    public void add(String[] words) {
        //iterates through the String[] made by String.split()
        //can ignore the comment below, I am still trying to learn enhanced for loops so I include the regular for loop too in a comment
        //for (int i = 0; i < words.length; i++) {
        for (String word : words) {
            //does not print empty strings
            if (!word.isEmpty()) {
                int whichBucket = whichBucket(word);
                LLNode head = hashMap.get(whichBucket);
                LLNode newNode = new LLNode(word, 1);

                //if the word is already in the hashMap it will just increment count for it by 1
                if (lookUp(newNode.getKey())) {
                    while (head != null) {
                        if (head.getKey().equals(word)) {
                            //increments the value by 1
                            head.setValue(1 + head.getValue());
                        }
                        head = head.next;
                    }
                }
                //if word is not in the hashmap, it will add it to the hashmap
                else {
                    newNode.next = head;
                    hashMap.set(whichBucket, newNode);
                    size++;
                }
                //if the arraylist of LLNodes is filled up 75% or more, it calls on the resize method
                if (((float) size / (float) capacity) >= 0.75) {
                    resize();
                }
            }
        }
    }

    //this is a method that is only used in the resize() method
    //had to do it this way because my add() method takes in a String[] but I needed to use just the key and value
    public void addNode(String word, Integer value) {
        int whichBucket = whichBucket(word);
        LLNode head = hashMap.get(whichBucket);
        LLNode newNode = new LLNode(word, value);

        //if the word is already in the hashMap it will just increment count for it by 1
        if (lookUp(newNode.getKey())) {
            while (head != null) {
                if (head.getKey().equals(word)) {
                    head.setValue(1 + head.getValue());
                }
                head = head.next;
            }
        }
        // if word is not in the hashmap, it will add it to the hashmap
        else {
            newNode.next = head;
            hashMap.set(whichBucket, newNode);
            size++;
        }
    }

    //scan the entire table for all items in it and outputs into the output file
    public void scan(ArrayList<LLNode> hashMap, String output_file) {
        try {
            //uses a printstream to print onto the output file
            PrintStream printS = new PrintStream(new FileOutputStream(output_file));
            for (LLNode node : hashMap) {
                // will print the node onto the output file as long as it is not null
                while (node != null) {
                    printS.print("(" + node.getKey() + " " + node.getValue() + ")");
                    node = node.next;
                }
            }
        }
        //catches it if the output file is not found
        catch (IOException e) {
         System.out.println("File was not found. Make sure the file is in the folder.");
         e.printStackTrace();
         }
    }

    //resizes the hashtable to double its capacity
    //called on in add() method
    private void resize() {
        ArrayList<LLNode> temporaryHashMap = hashMap;
        hashMap = new ArrayList<>();
        capacity = capacity * 2;
        size = 0;
        for (int i = 0; i < capacity; i++) {
            hashMap.add(null);
        }
        for (LLNode headNode : temporaryHashMap) {
            while (headNode != null) {
                addNode(headNode.getKey(), headNode.getValue());
                headNode = headNode.next;
            }
        }
    }
}
