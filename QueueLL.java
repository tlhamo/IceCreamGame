
public class QueueLL<T> implements Queue<T> {
	private LinkedList<T> list;
	
	public QueueLL(){
		this.list = new LinkedList<T>();

	}

	@Override
	public void enqueue(T data) {
		this.list.insertFirst(data);	
	}
	
	@Override
	public T dequeue() {
		T deleted = this.list.getLast();
		this.list.deleteLast();
		return deleted;
	}

	@Override
	public T peek() {
		return this.list.getLast();
	}
	
	
	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}
	
	@Override
	public String toString(){	
		return this.list.toString();
	}
	
	
}
