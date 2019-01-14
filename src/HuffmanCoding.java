import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * @author Tyrell Friend, Sam Allison, Tyre King
 * @version 2018-04-21
 */
public class HuffmanCoding {
	private int numberOfChar = 0;
	private int count = 0;
	private Integer longestCode = 0;
	private int ByteFileLen = 0;
	private int fileLength = 0;
	private double aveCodeLen = 0;
	private double huffmanReduction = 0.0;
	private HashMap<String, Leaf> hashMap = new HashMap<String, Leaf>();
	private HashMap<String, String> map = new HashMap<String, String>();

	private ArrayList<String> table = new ArrayList<>();

	private int tablecounter = 0;
	private static Queue<Node> pq = new PriorityQueue<>();
	private ArrayList<Character> listOfChar = new ArrayList<Character>();

	/**
	 * 
	 * @param scan
	 *            takes in a scanner
	 * @param file
	 *            takes in a file
	 * @param fileName
	 *            takes in a string name of the file
	 * @throws FileNotFoundException
	 *             exception get thrown if file cannot be found
	 */
	public HuffmanCoding(Scanner scan, File file, String fileName) throws FileNotFoundException {
		file = new File(fileName);
		scan = new Scanner(file);
		Integer numberOfNewLines = 0;
		while (scan.hasNext()) {
			char[] chars = scan.nextLine().toCharArray();

			for (Character c : chars) {

				if (hashMap.containsKey(c.toString())) {
					hashMap.get(c.toString()).setWeight(1);
				} else {
					int one = 1;
					Leaf a = new Leaf(one, c.toString(), "");
					hashMap.put(c.toString(), a);
					map.put(c.toString(), "");
					listOfChar.add(c);
				}
				numberOfChar++;
			}
			numberOfNewLines++;
		}
		Leaf a = new Leaf(numberOfNewLines, "{nl}", "");
		hashMap.put("{nl}", a);
		map.put("{nl}", numberOfNewLines.toString());
		numberOfChar += numberOfNewLines;
		scan.close();
	}

	/**
	 * 
	 * @param fileName
	 *            string name of file being read
	 */
	public void dowork(String fileName) {
		count = 0;
		for (Map.Entry<String, Leaf> entry : hashMap.entrySet()) {
			pq.add((Leaf) entry.getValue());
			table.add(entry.getKey() + ":   " + entry.getValue().weight);
			count++;
		}
		createTree(pq);
		ByteFileLen = numberOfChar * 8;
		System.out.println("Char " + "Freq " + "   Code");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			findHelp(pq.peek(), entry.getKey());
			System.out.println(table.get(tablecounter) + "    " + entry.getValue());
			tablecounter++;

		}

		aveCodeLen = (double) fileLength / (double) numberOfChar;
		huffmanReduction = (double) fileLength / (double) ByteFileLen;
		huffmanReduction = huffmanReduction * 100;
		printReport(fileName);
		reset();
	}

	/**
	 * 
	 * @param a
	 *            taking a priority queue of Nodes which is to be turn into a
	 *            optimal binary search tree
	 */
	public void createTree(Queue<Node> a) {
		if (a.size() == 1) {
			return;
		} else {
			Node b = a.poll();
			Node c = a.poll();

			int val = b.weight + c.weight;
			if(b instanceof Leaf && c instanceof Leaf) {
			Leaf t = (Leaf)b;
			Leaf m = (Leaf)c;
			String k = t.getChar();
			String q = m.getChar();
			System.out.println(k+q+ ": " + val);
			}
			InternalNode d = new InternalNode(val, b, c);
			if (b instanceof InternalNode || c instanceof InternalNode) {
				((InternalNode) d).getLeft().addBit("0");
				((InternalNode) d).getRight().addBit("1");
			} else {
				b.addBit("0");
				c.addBit("1");
			}
			a.add(d);
			createTree(a);
		}
	}

	public void reset() {
		listOfChar.clear();
		hashMap.clear();
		map.clear();
		table.clear();
		pq.clear();
		tablecounter = 0;
		numberOfChar = 0;
		count = 0;
		longestCode = 0;
		ByteFileLen = 0;
		fileLength = 0;
		aveCodeLen = 0;
		huffmanReduction = 0.0;

	}

	/**
	 * 
	 * @return returns node from priority queue
	 */
	public Node getPq() {
		return pq.poll();
	}

	/**
	 * 
	 * @param a
	 *            Node a allows the node containing the string c to be found
	 * @param c
	 *            string c is the character to be found in the tree
	 */
	private void findHelp(Node a, String c) {
		if (a == null) {
			return;
		} else if (a instanceof InternalNode) {

			findHelp(((InternalNode) a).getLeft(), c);
			findHelp(((InternalNode) a).getRight(), c);
		} else if (a instanceof Leaf) {
			if (((Leaf) a).getChar().compareTo(c) == 0) {
				map.put(c, ((Leaf) a).getBit());
				if ((Integer) longestCode.compareTo((Integer) ((Leaf) a).getBit().length()) < 0) {
					longestCode = ((Leaf) a).getBit().length();
				}
				fileLength += ((Leaf) a).getBit().length() * hashMap.get((((Leaf) a).getChar())).weight;

				return;
			}
		}

	}

	/**
	 * 
	 * @param name
	 *            name is the filename of the data
	 */
	private void printReport(String name) {
		System.out.println("Name" + "            " + "TotalChars" + "  " + "DiffChars" + "  " + "MaxCodeLen" + "   "
				+ "AveCodeLen" + "   " + "FileLen" + "   " + "ByteFileLen" + "   " + "HuffmanReduction");
		System.out.println(name + "      " + numberOfChar + "       " + count + "          " + longestCode + "         "
				+ String.format("%1.2f", aveCodeLen) + "          " + fileLength + "        " + ByteFileLen
				+ "          " + String.format("%1.2f", huffmanReduction) + "%");
	}
}
