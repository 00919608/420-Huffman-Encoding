/**
 * 
 * @author Tyrell Friend,Sam Allison, Tyre King
 * @version 2018-04-21
 *
 */
public class InternalNode extends Node {
	private Node left;
	private Node right;
	/**
	 * 
	 * @param value
	 * value - frequency of node
	 * @param l
	 * left child of Node
	 * @param r
	 * right child of Node
	 */
	public InternalNode(int value, Node l, Node r) {
		super(value);
		this.left = l;
		this.right = r;
	}
	/**
	 * @return
	 * returns left child of node
	 */
	public Node getLeft() {
		return this.left;
	}
	/**
	 * 
	 * @return
	 * returns right child of node
	 */
	public Node getRight() {
		return this.right;
	}
	/**
	 * @param s
	 * string s represents bit "0" or "1"
	 */
	@Override
	public void addBit(String s) {
		this.getLeft().addBit(s);
		this.getRight().addBit(s);
	}
}
