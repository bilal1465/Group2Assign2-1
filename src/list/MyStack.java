package list;

import java.util.NoSuchElementException;

import list.MyArrayList.MyArrayListIterator;
import utilities.Iterator;
import utilities.StackADT;

public class MyStack<E> implements StackADT<E> {
	
	private static final int DEFAULT_CAPACITY = 0;
	private Object[] elements;
	private int size;

	public MyStack() {
		elements = new Object [DEFAULT_CAPACITY];
		size = 0;
	}
	@Override
	public void push(E item) {
		ensureCapacity();
		elements [size++] = item;	
	}
	
	private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[size * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }
	
	@Override
	public E pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty!");
		}
		E poppedItem = peek();
		elements [--size] = null;
		return poppedItem;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty!");
		}
		return (E) elements[size - 1];
	}

	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		elements = new Object[DEFAULT_CAPACITY];
        size = 0;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if (holder.length < size) {
            holder = (E[]) new Object[size];
        }

        for (int i = 0; i < size; i++) {
            holder[i] = (E) elements[i];
        }

        return holder;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		for (int i = 0; i < size; i++) {
            if (toFind.equals(elements[i])) {
                return true;
            }
        }
        return false;
	}

	@Override
	public int search(E toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyArrayListIterator();
	}
	private class MyArrayListIterator implements Iterator<E> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) elements[currentIndex++];
        }
    }

	@Override
	public boolean equals(StackADT<E> that) {
		// TODO Auto-generated method stub
		return false;
	}

}
