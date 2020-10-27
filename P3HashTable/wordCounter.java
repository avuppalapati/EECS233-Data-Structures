package amv87.myCode;

import java.io.*;
import java.util.*;

public class wordCounter {
    //fields

    //constructor
    public wordCounter() {

    }

    public void wordCount(String input_file, String output_file) {
        try {
            // used a scanner
            File input = new File(input_file);
            Scanner scanner = new Scanner(input, "UTF-8");
            String inputString = "";
            //instance of hash class is made
            Hash hash = new Hash();
            // uses the scanner to input each individual word into the hashmap
            while (scanner.hasNextLine()) {
                //saves the next line of the scanner as a string
                inputString = scanner.nextLine();
                //makes everything lowercase
                inputString = inputString.toLowerCase();
                String[] words = inputString.split("\\W");
                hash.add(words);
            }
            hash.scan(hash.getHashMap(), "output.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File was not found. Make sure the file is in the folder.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        wordCounter a = new wordCounter();
        a.wordCount("input.txt", "output.txt");
    }
}
