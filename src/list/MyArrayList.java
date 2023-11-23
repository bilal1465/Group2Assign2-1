package list;

import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;

public class MyArrayList<E> implements ListADT<E> {

	private int size;
	private Object[] elements;
	private int DEFAULT_CAPACITY;

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
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        ensureCapacity();

        // Shift elements to the right
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = toAdd;
        size++;
        return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		ensureCapacity();
        elements[size++] = toAdd;
        return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		ensureCapacity();
        elements[size++] = toAdd;
        return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E removedItem = get(index);

        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null;
        return removedItem;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		for (int i = 0; i < size; i++) {
            if (toRemove.equals(elements[i])) {
                return remove(i);
            }
        }
        return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E previousItem = get(index);
        elements[index] = toChange;
        return previousItem;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
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

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold.length < size) {
            toHold = (E[]) new Object[size];
        }

        for (int i = 0; i < size; i++) {
            toHold[i] = (E) elements[i];
        }

        return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
        return array;
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
	
	private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newArray = new Object[size * 2];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

}
