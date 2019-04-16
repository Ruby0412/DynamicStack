
public class RedBlackNode {
	//field
	public static final int RED = 1;
	public static final int BLACK = 0;
	
	private String data;
	private int color = -1;
	private RedBlackNode p, lc, rc;
	

	/**
	 * 
	 * Construct a RedBlackNode with data, color, parent pointer, left child pointer and right child pointer.
	 * @param data - a simple value held in the tree
	 * @param color - either 1(RED) or 0(BLACK)
	 * @param p - the parent pointer
     * @param lc - the pointer to the left child (will be null only for the node that represents all external nulls.
	 * @param rc - the pointer to the right child (will be null only for the node that represents all external nulls.
	 * 
	 */
	public RedBlackNode(java.lang.String data,
            int color, RedBlackNode p, RedBlackNode lc, RedBlackNode rc) {
		this.data = data;
		this.color = color;
		this.p = p;
		this.lc = lc;
		this.rc = rc;
	}
	

	/**
	 * The toString() methods returns a string representation of the RedBlackNode.
	 * @overrides toString in class java.lang.Object
	 * @return the string representation of a RedBlackNode
	 * 
	 */
	public String toString() {
		String result; 
		if(color == 1) {
			result = "Red:";

		}
		else {
			result = "Black:";
		}
		return "[data = "+ data+ ":Color = "+result
				+"Parent = " + p.getData()+": LC = "
				+ lc.getData() + ": RC = " + rc.getData() +"]";
	}

	/**
	 * The getColor() method returns RED or BLACK.
	 * @ return 1 for red, 0 for black
	 * 
	 */
	public int getColor() {
		return color;
	}

	/**
	 * The getData() method returns the data in the node.
	 * @return  the data value in the node.
	 * 
	 */
	public String getData() {
		return data;
	}

	/**
	 * The getLc() method returns the left child of the RedBlackNode.
	 * @return the left child field
	 * 
	 */
	public RedBlackNode getLc() {
		return lc;
	}

	/**
	 * The getLc() method returns the right child of the RedBlackNode.
	 * @return the right child field
	 * 
	 */
	public RedBlackNode getRc() {
		return rc;
	}

	/**
	 * The getLc() method returns the parent of the RedBlackNode.
	 * @return the parent field
	 * 
	 */
	public RedBlackNode getP() {
		return p;
	}

	/**
	 * The setColor() method sets the color of the RedBlackNode.
	 * @param  1 for RED and 0 for BLACK
	 * 
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * The setData() method sets the data or key of the RedBlackNode.
	 * @param  data - is an int holding a node's data value
	 * 
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * The setLc() method sets the left child of the RedBlackNode.
	 * @param  lc - establishes a left child for this node
	 * 
	 */
	public void setLc(RedBlackNode lc) {
		this.lc = lc;
	}

	/**
	 * The setRc() method sets the right child of the RedBlackNode.
	 * @param  rc - establishes a right child for this node.
	 * 
	 */
	public void setRc(RedBlackNode rc) {
		this.rc = rc;
	}

	/**
	 * The setP() method sets the parent of the RedBlackNode.
	 * @param  p - establishes a parent pointer for this node
	 * 
	 */
	public void setP(RedBlackNode p) {
		this.p = p;
	
	}
}
