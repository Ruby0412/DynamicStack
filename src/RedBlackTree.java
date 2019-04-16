import java.math.BigInteger;
import java.util.HashMap;

public class RedBlackTree {
	private RedBlackNode root;
	private RedBlackNode nil;
	private int size;
	private int compares;
	//pair value with key string
	HashMap<String, BigInteger> map = new HashMap<>(); 
	
	
	/**
	 * Construct an empty RedBlackTree with a black node.
	 *  Big Theta = Θ(1)
	 * 
	 */
	public RedBlackTree(){
	nil = new RedBlackNode("-1", 0, null, null, null);
	root = nil;
	size = 0;
	compares = 0;
		
	}

	
	/**
	 * The insert() method inserts an item into the red black tree.
	 * 
	 * @param value - is an integer to be inserted
	 * @precondition memory is available for insertion
	 * Big Theta = Θ(log(N))
	 */
	public void insert(java.lang.String value,  BigInteger num) {
		RedBlackNode y = nil;
        RedBlackNode x = root;
        RedBlackNode z = new RedBlackNode(value, 1, null, null, null);
        if(contains(value)) {
           	map.put(value, num);
        }
        else {
        	map.put(value, num);
        while(x != nil) {
        		y = x;
        		if(z.getData().compareTo(x.getData()) < 0) {
        			x = x.getLc();
        		}
        		else {
        			x = x.getRc();
        		}
        }
        z.setP(y);
        if( y == nil) {
        		root = z;
        }
        else {
        		if(z.getData().compareTo(y.getData()) < 0) {
        			y.setLc(z);
        		}
        		else {
        			y.setRc(z);
        		}
        }
        
        z.setLc(nil);
        z.setRc(nil);
        z.setColor(1);
        RBInsertFixup(z);
       
        size++;
        
	}
	}
	/**
	 *look for the value according to the key and return it
	 * @param key
	 * @return value
	 * 
	 */
	public BigInteger lookup(String v) {
		BigInteger nullInteger = BigInteger.valueOf(0);
		if(contains(v)) {
			return map.get(v);
		}
		else {
			return nullInteger;
		}
		
	}
	
	
	
	
	/**
	 * The boolean contains() returns true if the String v is in the RedBlackTree 
	 * and false otherwise. It counts each comparison it makes in the variable 
	 * compares.
	 * @param  v - the value to search for
	 * @returns true if v is in the tree, false otherwise;
	 *
	 */
	public boolean contains(String v) {
		compares = 0;
		RedBlackNode target = root;
		
		while (target != nil) {
			compares++;
			if(target.getData().equals(v)) {
				return true;
			}
			else if (target.getData().compareTo(v) < 0) {
				target = target.getRc();
			}
			else if (target.getData().compareTo(v) > 0) {
				target = target.getLc();
			}
		}
		return false;
	}
	


	/**
	 *   leftRotate() performs a single left rotation. 
	 *   This would normally be a private method. 
	 *   It executes the following algorithm from CLR.
	 * 
	 */
	public void leftRotate(RedBlackNode x) {
		  RedBlackNode y = x.getRc();
		  x.setRc(y.getLc());
		  y.getLc().setP(x);
		  y.setP(x.getP());
		  
		  if(x.getP() == nil) {
			  root = y;
		  }
		  else {
			  if(x == x.getP().getLc()) {
				  x.getP().setLc(y);
			  }
			  else {
				  x.getP().setRc(y);
			  }
		  }
		  y.setLc(x);
		  x.setP(y);
		
	}
	/**
	 *   rightRotate() performs a single right rotation 
	 *   This would normally be a private method. 
	 *   It executes the following algorithm from CLR.
	 * 
	 */
	public void rightRotate(RedBlackNode x) {
		RedBlackNode y = x.getLc();
		x.setLc(y.getRc());
		y.getRc().setP(x);
		y.setP(x.getP());
		
		if(x.getP() == nil) {
			root = y;
		}
		else {
			if( x == x.getP().getLc()) {
				x.getP().setLc(y);
			}
			else {
				x.getP().setRc(y);
			}
		}
		
		y.setRc(x);
		x.setP(y);
	}
	/**
	 *   Fixing up the tree so that Red Black Properties are preserved.
	 *   This would normally be a private method.
	 */
	public void RBInsertFixup(RedBlackNode z) {
		RedBlackNode y;
		while(z.getP().getColor() == 1) {
			//z's father is left chindren of his grandpa
			if(z.getP()==z.getP().getP().getLc()){
				y = z.getP().getP().getRc();
				if(y.getColor() == 1) {
					z.getP().setColor(0);
					y.setColor(0);
					z.getP().getP().setColor(1);
					z = z.getP().getP();
				}
				else {
					if (z == z.getP().getRc()) {
						z = z.getP();
						leftRotate(z);
					}
					z.getP().setColor(0);
					z.getP().getP().setColor(1);
					rightRotate(z.getP().getP());
				}
			}
			else {
				y = z.getP().getP().getLc();
				if(y.getColor() == 1) {
					z.getP().setColor(0);
					y.setColor(0);
					z.getP().getP().setColor(1);
					z = z.getP().getP();
				}
				else {
					if (z == z.getP().getLc()) {
						z = z.getP();
						rightRotate(z);
					}
					z.getP().setColor(0);
					z.getP().getP().setColor(1);
					leftRotate(z.getP().getP());
				}
			}
		}
		root.setColor(0);
	}

	public void levelOrderTraversal() {
		RedBlackNode x;
		Queue a = new Queue();
		a.enQueue(root);
		while(!a.isEmpty()) {
			x = (RedBlackNode) a.deQueue();
			System.out.println(x.toString()+" ");
			if(x.getLc()!=nil)
				a.enQueue(x.getLc());
			
			if(x.getRc()!=nil)
				a.enQueue(x.getRc());
		}
		
		
	}

	/**
	 *   Test the RedBlack tree.
	 * 
	 */
	 public static void main(String[] args) {
		 
	        RedBlackTree rbt = new RedBlackTree();
	        BigInteger nullInteger = BigInteger.valueOf(0);
	        rbt.insert("var1", BigInteger.valueOf(100));
	        rbt.insert("var2", BigInteger.valueOf(0));
	        //overwrite the previous key,value
	        rbt.insert("var1", BigInteger.valueOf(1000));
	        rbt.levelOrderTraversal();
	        System.out.println("value stored in var1 is: "+rbt.lookup("var1"));
	        
	    }
	 
}
