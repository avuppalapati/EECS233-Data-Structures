/**
 * @author akhila
 *
 */
public class HuffmanNode extends HuffmanCompressor{
	private Character inChar;
	private Integer frequency;
	private HuffmanNode left;
	private HuffmanNode right;

// constructor
	public HuffmanNode(Character inChar, Integer frequency, HuffmanNode left, HuffmanNode right) {
		this.inChar = inChar;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}
//below are just getters and setters for the fields in this class
	/**
	 * @return the inChar
	 */
	public Character getInChar() {
		return inChar;
	}

	/**
	 * @param inChar the inChar to set
	 */
	public void setInChar(Character inChar) {
		this.inChar = inChar;
	}

	/**
	 * @return the frequency
	 */
	public Integer getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return the left
	 */
	public HuffmanNode getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(HuffmanNode left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public HuffmanNode getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(HuffmanNode right) {
		this.right = right;
	}
	
	

}
