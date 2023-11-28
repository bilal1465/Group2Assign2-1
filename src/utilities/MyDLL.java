package utilities;

public class MyDLL<E> implements ListADT<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    private static class Node<E> implements Serializable {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        public Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public MyDLL() {
        this.size = 0;
        this.head = null;
        this.tail = null;
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        if (index == 0) {
            addToFront(toAdd);
        } else if (index == size) {
            addToBack(toAdd);
        } else {
            Node<E> newNode = new Node<>(toAdd);
            Node<E> current = getNode(index);

            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;

            size++;
        }
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        addToBack(toAdd);
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        for (E item : toAdd) {
            add(item);
        }
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return getNode(index).data;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node<E> current = getNode(index);
        if (size == 1) {
            clear();
        } else if (index == 0) {
            head = head.next;
            head.prev = null;
            size--;
        } else if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
        return current.data;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(toRemove)) {
                if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node<E> node = getNode(index);
        E oldData = node.data;
        node.data = toChange;

        return oldData;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        Node<E> current = head;
        while (current != null) {
            if (current.data.equals(toFind)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E[] toArray(Object[] arr) throws NullPointerException {
        if (arr.length < size) {
            arr = (E[]) new Object[size];
        }

        Node<E> current = head;
        int index = 0;
        while (current != null) {
            arr[index++] = current.data;
            current = current.next;
        }

        return (E[]) arr;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        return toArray(arr);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements in the list.");
                }
                E data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    private void addToFront(E toAdd) {
        Node<E> newNode = new Node<>(toAdd);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    private void addToBack(E toAdd) {
        Node<E> newNode = new Node<>(toAdd);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node<E> current;
        if (index <= size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }
}
