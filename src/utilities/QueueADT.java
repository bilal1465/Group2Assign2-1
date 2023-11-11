package utilities;

public interface QueueADT<T> {
    /**
     * Adds one item to the rear of this queue.
     * @param item to be added to the rear of this queue.
     */
	void enqueue(T item);
    /**
     * Removes and returns the front item of the queue.
     * @return the item at the front of this queue.
     * @throws EmptyCollectionException if the queue is empty.
     */
    T dequeue();
    /**
     * Returns without removing the front item of the queue.
     * @return the item at the front of this queue.
     * @throws EmptyCollectionException if the queue is empty.
     */
    T peek();
    /**
     * Returns true if this queue contains no items.
     * @return true if this queue is empty, false otherwise.
     */
    boolean isEmpty();
    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue.
     */
    int size();
    /**
     * Returns a string representation of this queue.
     * @return a string representation of this queue.
     */
}
