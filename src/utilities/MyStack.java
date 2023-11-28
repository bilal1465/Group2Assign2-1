package utilities;

import java.util.EmptyStackException;

public class MyStack<E> implements StackADT<E> {
	
	private MyArrayList<E> stackList;

    public MyStack() {
        stackList = new MyArrayList<>();
    }

    @Override
    public void push(E toAdd) throws NullPointerException {
        stackList.add(toAdd);
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.remove(stackList.size() - 1);
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackList.get(stackList.size() - 1);
    }

    @Override
    public void clear() {
        stackList.clear();
    }

    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    @Override
    public Object[] toArray() {
        return stackList.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return stackList.toArray(holder);
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return stackList.contains(toFind);
    }

    @Override
    public int search(E toFind) {
        for (int i = stackList.size() - 1; i >= 0; i--) {
            if (stackList.get(i).equals(toFind)) {
                return stackList.size() - i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<E> iterator() {
        return stackList.iterator();
    }

    @Override
    public boolean equals(StackADT<E> that) {
        if (that == null || this.size() != that.size()) {
            return false;
        }

        Iterator<E> thisIterator = this.iterator();
        Iterator<E> thatIterator = that.iterator();

        while (thisIterator.hasNext()) {
            E thisElement = thisIterator.next();
            E thatElement = thatIterator.next();

            if (!thisElement.equals(thatElement)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int size() {
        return stackList.size();
    }
}
