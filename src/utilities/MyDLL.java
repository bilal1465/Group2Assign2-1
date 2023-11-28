package utilities;

public class MyDLL<E> implements ListADT<E> {

	 private MyDLLNode<E> head;
	    private MyDLLNode<E> tail;
	    private int size;
	    private int maxSize = 0;

	    public MyDLL() {
	        this.head = null;
	        this.tail = null;
	        this.size = 0;
	    }

	    @Override
	    public int size() {
	        return size;
	    }

	    @Override
	    public void clear() {
	        head = null;
	        tail = null;
	        size = 0;
	    }

	    @Override
	    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
	        validateIndexForAdd(index);

	        if (toAdd == null) {
	            throw new NullPointerException("Null element was given");
	        }

	        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

	        if (index == 0) {
	            addToEmptyList(newNode);
	        } else if (index == size) {
	            addToEnd(newNode);
	        } else {
	            insertInTheMiddle(index, newNode);
	        }

	        return true;
	    }

	    private void validateIndexForAdd(int index) {
	        if (index < 0 || index > size) {
	            throw new IndexOutOfBoundsException("Index out of range");
	        }
	    }

	    private void addToEmptyList(MyDLLNode<E> newNode) {
	        if (isEmpty()) {
	            head = newNode;
	            tail = newNode;
	        }
	        size++;
	    }

	    private void addToEnd(MyDLLNode<E> newNode) {
	        tail.setNext(newNode);
	        newNode.setPrev(tail);
	        tail = newNode;
	        size++;
	    }

	    private void insertInTheMiddle(int index, MyDLLNode<E> newNode) {
	        MyDLLNode<E> current = head;

	        for (int i = 0; i < index; i++) {
	            current = current.getNext();
	        }

	        MyDLLNode<E> previous = current.getPrev();

	        newNode.setNext(current);
	        newNode.setPrev(previous);
	        previous.setNext(newNode);
	        current.setPrev(newNode);

	        size++;
	    }

	    private boolean isEmpty() {
	        return size == 0;
	    }

	    // Implement the rest of the methods from the interface similarly...

	    private class DLLIterator implements Iterator<E> {
	        private MyDLLNode<E> current;

	        public DLLIterator() {
	            current = head;
	        }

	        @Override
	        public boolean hasNext() {
	            return current != null;
	        }

	        @Override
	        public E next() {
	            if (!hasNext()) {
	                throw new NoSuchElementException("No more elements in the list.");
	            }
	            E element = current.getElement();
	            current = current.getNext();
	            return element;
	        }
	    }
}
