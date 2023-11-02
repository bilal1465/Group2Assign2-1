package utilities;

public interface QueueADT<T> {
	void enqueue(T item);
    T dequeue();
    T peek();
    boolean isEmpty();
    int size();
}
