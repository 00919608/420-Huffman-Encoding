/**
 * 
 * @author Tyrell Friend, Sam Allison, Tyre King
 *@version 2018-04-21
 */
public abstract class Node extends Object implements Comparable<Node> {

	protected int weight = 0;
	/**
	 * 
	 * @param value
	 * value frequency of Node
	 */
	Node(int value) {
		this.weight = value;
	}

	// Calls Node subclass to add a bit
		// to the sequence as the Huffman Tree is
		// being built
	/**
	 * @param s
	 * string s a bit to added either "0" or "1"
	 */
	public abstract void addBit(String s);
	
	/**
	 * @param that
	 * Node that is used to compare Nodes frequency to one another
	 */
	@Override
	public int compareTo(Node that) {
		return Integer.compare(this.weight, that.weight);
	}
	/**
	 * 
	 * @param a
	 * a is the number to increase the frequency by
	 */
	public void setWeight(int a) {
		this.weight += a;
	}

}
