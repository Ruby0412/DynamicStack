import java.math.BigInteger;

public class DynamicStack {
	//initialization
	int size = 6;
	int top = -1;
	Object[] stack = new Object[size];
	
	/**
	   * check whether the array is empty
	   * @return true if empty
	   **/
	public boolean isEmpty(){
		return (top < 0);
	}
	
	//construct an empty stack
	public DynamicStack(){
	}
	/**
	   * check whether the array is full that need to be expand
	   * @return true if not full
	   **/
	public boolean pushOK (){
		if(top >= (size-1)){
			return false;
		}
		return true;
	}
	/**
	   * double the size by two
	   * 
	   **/
	public void doubleSize(){
		size = size*2;
		Object[] newStack = new Object[size];
		for(int i = 0; i< stack.length; i++){
			newStack[i] = stack[i];
		}
		stack = newStack;
	}
	
	/**
	   * pop the item on top of the stack
	   * @return top of the stack, null if empty stack
	   **/
	public Object pop(){
		if(top < 0){
			return null;
		}
		else{
			return(stack[top--]);
		}
	}
	
	  /**
	   * add item into the stack.
	   * @param num  item that will be pushed in to the stack.
	   * @runtime： best case: Θ(1), worst case: best case: Θ(n)
	   **/ 
	public void push(Object num){
		if(pushOK ()) {
			stack[++top] = num;
		}
		else{
			doubleSize();
			stack[++top] = num;
		}
	}
	
	//test it with 1000 BigInteger
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicStack test = new DynamicStack();
		for(int i = 0; i<1000; i++){
			test.push(BigInteger.valueOf(i));
		}
		for(int i = 0; i<1000; i++){
			System.out.println(test.pop());
		}
			
			
		
	}

}
