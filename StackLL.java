/**
 * This class creates an ice cream cone and contains 
 * functionality like adding scoops to the top of the stack
 * and removing scoops from the top. 
 * @author Tseki
 *
 * @param <T>  any type
 */
public class StackLL<T> implements Stack<T>{
	private LinkedList<T> linkedList;
	
	public StackLL(){
		linkedList = new LinkedList<T>();
	}

	@Override
	public void push(T data) {
		linkedList.insertLast(data);	
	}

	@Override
	public T pop() {
		T popped = linkedList.getLast();
		linkedList.deleteLast();
		return popped;
	}

	@Override
	public T peek() {
		return linkedList.getLast();
	}

	@Override
	public boolean isEmpty() {	
		return linkedList.isEmpty();
	}
	
	public String toString(){	
		return linkedList.toString();
		
	}
}
