/**
 * 
 * @author Tyrell Friend, Sam Allison, Tyre King
 *@version 2018-04-21
 */
public class Leaf extends Node {
	private String character;
	private String code;
	/**
	 * 
	 * @param value
	 * frequency of Leaf
	 * @param c
	 * character of Leaf
	 * @param code
	 * code representing where Leaf is in tree
	 */
	public Leaf(int value, String c, String code) {
		super(value);
		this.character = c;
		this.code = code;

	}
	/**
	 * 
	 * @return
	 * returns character of Leaf
	 */
	public String getChar() {
		return this.character;
	}
	/**
	 * @param s
	 * string s is being add to the code of the Leaf
	 */
	@Override
	public void addBit(String s) {
		this.code = s + this.code;
	}
	/**
	 * 
	 * @return
	 * returns code of the Leaf
	 */
	public String getBit() {
		return code;
	}

}
