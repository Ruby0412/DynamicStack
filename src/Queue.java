
public class Queue {
	private static final int CAPACITY=10;
	private int front, rear;
	private int size = CAPACITY; 
	private int items;
	private Object[] queue;

	/**
	 * Construct an empty Queue with size equals to CAPACITY.
	 * 
	 */
	public Queue() {
		this.front = 0;
		this.rear = 0;
		this.items = 0;
		this.size = CAPACITY;
		this.queue = new Object[size];
	}
	
	/**
	 * Boolean method returns true if queue is currently at capacity, false otherwise.
	 *  (If full returns true and additional enqueue calls are made, 
	 *  the queue will expand in size. )
	 *  @return Returns true if queue is at current capacity.
	 * 
	 */
	public boolean isFull() {
		return items == size;
	}

	/**
	 * Boolean method returns true on empty queue, false otherwise. Pre: None
	 * @return Returns true if queue is empty.
	 * 
	 */
	public boolean isEmpty() {
		return items == 0;
	}

	/**
	 * Object method removes and returns reference in front of queue. 
	 * Pre-condition: queue not empty
	 * @return object in front of queue.
	 * 
	 */
	public Object deQueue() {
		
		items --;
		Object target = queue[front];
		if (!isEmpty())
			front = (front + 1) % size;
		return target;
	}

	/**
	 * Add an object reference to the rear of the queue. 
	 * Pre-condition Memory is available for doubling queue capacity when full. 
	 * Post-condition: queue now contains x in the rear.
	 * @param x is an object to be added to the rear of the queue.
	 * 
	 */
	public void enQueue(Object x) {
		//expand the size when full
		if (isFull()) {
			size *= 2;
			Object[] improvedQ = new Object[size];
				
			//copy from the front
			for (int i = front; i < size / 2; i++) {
				improvedQ[i] = queue[i];
			}
			//move rest of old queue
			for (int j = size / 2; j < size / 2 + rear + 1; j++) {
				improvedQ[j] = queue[j - size / 2];
			}
			// fix the rear.
			rear += size / 2;
			queue = improvedQ; 
		}
		//if not empty simply add to rear.
		if (!isEmpty())
			rear = (rear + 1) % size;
		items++;
		queue[rear] = x;
	}

	/**
	 * Method getFront returns the front of the queue without removing it. 
	 * Pre-condition: queue not empty
	 * @return the queue front without removal.
	 * 
	 */
	public Object getFront() {
		return queue[front];
	}


	/**
	 * The toString method returns a String representation of the current queue contents.
	 * @overrides toString in class java.lang.Object
	 * @return a string representation of the queue. 
	 * It shows the front of the queue first. 
	 * It then shows the second and third and so on.

	 * 
	 */
	public String toString() {
		
		String result = "";
		for(int i = 0; i < items; i++) {
			result += queue[(front + i)%size] +" ";
		}
		return result;
	}

	

	/**
	 * main is for testing the queue routines.
	 * @param  Command line parameters are not used.
	 * 
	 */
	public static void main(java.lang.String[] a) {
		 Queue q = new Queue();
	        q.enQueue("ariel");
	        q.enQueue("caspar");
	        q.enQueue("yoyo");
	        q.enQueue(5);
	        q.enQueue(2);
	        q.enQueue(1);
	        System.out.println(q.items);
	        System.out.println(q.deQueue());
	        System.out.println(q.deQueue());
	        System.out.println(q.deQueue());
	        System.out.println(q.deQueue());
	        q.enQueue("big");
	        q.enQueue("family");
	        System.out.println(q.deQueue());
	        System.out.println(q.deQueue());
	        System.out.println(q.deQueue());
	}
}