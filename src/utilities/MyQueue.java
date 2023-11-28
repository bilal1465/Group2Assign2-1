package utilities;

public class MyQueue<E> implements QueueADT<E> {
	
	private MyDLL<E> queue;
    private int maxSize;

    public MyQueue() {
        this.queue = new MyDLL<>();
        this.maxSize = Integer.MAX_VALUE; // No explicit maximum size
    }

    public MyQueue(int maxSize) {
        this.queue = new MyDLL<>();
        this.maxSize = maxSize;
    }

    @Override
    public void enqueue(E data) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        queue.addToBack(data);
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
        return queue.removeFront();
    }

    @Override
    public E peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty");
        }
        return queue.first();
    }

    @Override
    public void dequeueAll() {
        queue.clear();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return queue.iterator();
    }

    @Override
    public boolean equals(QueueADT<E> that) {
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
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    public E[] toArray(E[] holder) throws NullPointerException {
        return queue.toArray(holder);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isFull() {
        return queue.size() == maxSize;
    }
}
