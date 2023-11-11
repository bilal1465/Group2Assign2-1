package utilities;

public interface StackADT<T> {
    /**
     * Adds one item to the top of this stack.
     * @param item the item to be added to the top of this stack.
     */
	void push(T item);
    /**
     * Removes and returns the top item from the stack
     * @return the item at the top of this stack.
     * @throws EmptyCollectionException if the stack is empty.
     */
    T pop();
    /**
     * Returns without removing the top item of the stack.
     * @return the item at the top of this stack.
     * @throws EmptyCollectionException if the stack is empty.
     */
    T peek();
    /**
     * Returns true if this stack contains no items.
     * @return true if this stack is empty, false otherwise.
     */
    boolean isEmpty();
    /**
     * Returns the number of items in this stack.
     * @return the number of items in this stack.
     */
    int size();
    /**
     * Returns a string representation of this stack.
     * @return a string representation of this stack.
     */
}
