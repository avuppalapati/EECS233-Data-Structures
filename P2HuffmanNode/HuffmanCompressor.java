import java.io.*;
import java.util.*;

public class HuffmanCompressor {

	// priority queue 
	// below is why I used a priority queue over an ArrayList and LinkedList
	private PriorityQueue<HuffmanNode> _priorityQueue;
	// this is the final hashmap made after encoding the characters
	private HashMap<Character, String> finalHashMap = new HashMap<>();

	// empty constructor
	public HuffmanCompressor() {
	}

	// helper method 1
	// scan the input text file to generate the initial list of HuffmanNodes
	public void buildPQ(String inputFileName) {
		try {
			// used a scanner
			File input = new File(inputFileName);
			Scanner scanner = new Scanner(input, "UTF-8");
			String inputString = "";
			//hashmap is made
			HashMap<Character, Integer> hashMap = new HashMap<>();
			// uses the scanner to input the string into the hashmap
			while (scanner.hasNextLine()) {
				inputString = scanner.nextLine();
				for (int i = 0; i < inputString.length(); i++) {
					char c = inputString.charAt(i);
					int value = hashMap.getOrDefault(c, 0);
					hashMap.put(c, value + 1);
				}
			}

			// I chose to hard code my comparator
			// I used Priority Queue because it will automatically adjust its size and will
			// continue to sort it rather than me having to manually sort it each time
			_priorityQueue = new PriorityQueue<>(
					(huffmanNode1, huffmanNode2) -> huffmanNode1.getFrequency().equals(huffmanNode2.getFrequency())
							? huffmanNode2.getInChar().compareTo(huffmanNode1.getInChar())
							: huffmanNode1.getFrequency() - huffmanNode2.getFrequency());

			//makes a node based off of the hashmap entry and then adds it to the priority queue
			for (Character entry : hashMap.keySet()) {
				HuffmanNode node = new HuffmanNode(null, 0, null, null);
				node.setInChar(entry);
				node.setFrequency(hashMap.get(entry));
				node.setLeft(null);
				node.setRight(null);
				_priorityQueue.add(node);
			}
		} 
		//this is what it does when there is no file found
		catch (FileNotFoundException e) {
			System.out.println("File was not found. Make sure the file is in the folder.");
			e.printStackTrace();
		}
	}

	// merges two HuffmanNodes to generate and return a combined HuffmanNode
	public void mergeHuffmanNodes() {
		//the two smallest of the priority queue are assigned to Huffman Nodes and then they are removed
		HuffmanNode smaller = _priorityQueue.peek();
		_priorityQueue.poll();
		HuffmanNode larger = _priorityQueue.peek();
		_priorityQueue.poll();

		// Creates a new node which has these the above nodes as children
		HuffmanNode mergedNode = new HuffmanNode(null, 0, null, null);
		mergedNode.setLeft(smaller);
		mergedNode.setRight(larger);
		mergedNode.setFrequency(larger.getFrequency() + smaller.getFrequency());
		mergedNode.setInChar('-');

		// Add this new merged node back to the priority queue
		_priorityQueue.add(mergedNode);
	}

	// helper method 3
	// runs the Huffman encoding algorithm to produce the Huffman tree
	public HuffmanNode produceHuffmanTree() {
		while (_priorityQueue.size() > 1) {
			mergeHuffmanNodes();
		}
		return _priorityQueue.peek();
	}

	// traverses the Huffman tree to output the character encoding
	// makes the final hashmap for character encoding
	// helper method 4
	public void makeFinalHashMap(HuffmanNode root, String encode) {
		if (root.getLeft() == null && root.getRight() == null) {
			// prints out Huffman encoding of characters in the form of a table of character/frequency/encoding triples – one triple per line,
			System.out.println(root.getInChar() + ":" + root.getFrequency() + ":" + encode);
			finalHashMap.put(root.getInChar(), encode);
			return;
		}
		//makes the encoded value
		//recursive
		makeFinalHashMap(root.getLeft(), encode + "0");
		makeFinalHashMap(root.getRight(), encode + "1");
	}

	//Special Character code from Professor Rabinovich
	public static String escapeSpecialCharacter(String x) {
		StringBuilder sb = new StringBuilder();
		for (char c : x.toCharArray()) {
			if (c >= 32 && c < 127)
				sb.append(c);
			else
				sb.append(" [0x" + Integer.toOctalString(c) + "]");
		}
		return sb.toString();
	}

	// helper method 5
	// scans the input text file, produces the encoded output file, and computes the
	// savings
	public void scanAgain(String inputFileName, String outputFileName) {
		try {
			int bytesSaved = 0;
			int outputBytes = 0;
			int inputBytes = 0;
			File input = new File(inputFileName);
			Scanner scanner = new Scanner(input);
			String inputString = "";
			// outputs the encoded value onto the file
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
			while (scanner.hasNextLine()) {
				inputString = scanner.nextLine();
				for (int i = 0; i < inputString.length(); i++) {
					char c = inputString.charAt(i);
					//assumes 8 bits in space as Professor Rabinovich states
					inputBytes = inputBytes + 8;
					String finalString = finalHashMap.get(c);
					outputBytes = outputBytes + finalString.length();
					writer.write(escapeSpecialCharacter(finalString));
				}
			}
			//amount of bytes saved
			bytesSaved = inputBytes - outputBytes;
			//outputs the amount of bytes saved
			System.out.print("bytes saved: " + bytesSaved);
			writer.close();
		} catch (IOException e) {
			System.out.println("File was not found. Make sure the file is in the folder.");
			e.printStackTrace();
		}
	}
	
	// main method
	public static void main(String[] args) throws FileNotFoundException {
		HuffmanCompressor a = new HuffmanCompressor();
		a.buildPQ(args[0]); 
		a.makeFinalHashMap(a.produceHuffmanTree(), "");
		a.scanAgain(args[0], args[1]);
	}

}