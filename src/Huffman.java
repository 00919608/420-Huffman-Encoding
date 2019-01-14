import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
/**
 * 
 * @author Tyrell Friend, Sam Allison, Tyre King
 *@version 2018-04-21
 *Took around 7-8 Hours to complete
 *This program takes in a file and counts how time each character occurs. The frequency 
 *of each character determines where it is placed in the tree. The end results is the creation of 
 *an optimal binary tree. Where the character who occurs the most frequent is at the top
 *an the least frequent is at the bottom. This program was created using the Huffman Encoding Algorithm.
  */
public class Huffman {
	/**
	 * 
	 * @param scan
	 * takes in a scanner
	 * @param file
	 * takes in a file
	 * @param fileName
	 * string name of file
	 * @return
	 * HuffmanCoding Object which creates a priority queue of frequency of characters
	 * @throws Exception
	 * catch exceptions thrown by file
	 */
	public static HuffmanCoding huffmanEncode(Scanner scan, File file, String fileName) throws Exception {
		HuffmanCoding a = new HuffmanCoding(scan, file, fileName);
		return a;
	}
	/*
	 * Books of files used were Tom Saywer, A Tale of Two Cities,
	 * Huffman Encoding Wikipedia (given through assignment) , and assignmentWebPage
	 */
	public static void main(String[] args) {
		try {

			String a = "Wikipedia.txt";
			String b = "tomSaywer";
			String c = "tale of two citys";
			String d = "assignmentWebPage";
			String e = "Untitled 1";
			File file = new File(a);
			File file2 = new File(b);
			File file3 = new File(c);
			File file4 = new File(d);
			File file5 = new File(e);
			Scanner scan = new Scanner(file);
			huffmanEncode(scan, file, a).dowork(a);
			System.out.println(
					"------------------------------------------------------------------------------------------------------");
			huffmanEncode(scan, file2, b).dowork(b);
			System.out.println(
					"------------------------------------------------------------------------------------------------------");
			huffmanEncode(scan, file3, c).dowork(c);
			System.out.println(
					"----------------------------------------------------------------------------------------------------");
			huffmanEncode(scan, file4, d).dowork(d);
			System.out.println("------------------------------------------------------------------------------------------");
			huffmanEncode(scan, file5,e).dowork(e);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
