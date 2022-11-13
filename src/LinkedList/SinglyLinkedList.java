package LinkedList;

public class SinglyLinkedList<T> {
    private SinglyListNode<T> head;

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void addFirst(T value) {
        SinglyListNode<T> node = new SinglyListNode<>(value, null);
        if (isEmpty()) {
            this.head = node;
        } else {
            node.setNext(this.head);
            this.head = node;

        }

    }

    public SinglyListNode<T> search(T value) {
        SinglyListNode<T> search;
        if (isEmpty()) {
            return null;
        } else {
            search = this.head;
            while (search != null) {
                if (search.getValue().equals(value)) {
                    return search;
                }
                search = search.getNext();
            }
            return null;
        }
    }

    public int size() {
        SinglyListNode<T> current = this.head;
        int size = 0;
        while (current != null) {
            current = current.getNext();
            size++;
        }
        return size;
    }

    public void addLast(T value) {
        SinglyListNode<T> node = new SinglyListNode<>(value, null);
        if (this.isEmpty()) {
            this.head = node;
        } else {
            SinglyListNode<T> pointer = this.head;
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
        }
    }

    public void reverse() {
        if (isEmpty() || this.size() == 1) {
            return;
        }
        SinglyListNode<T> previousNode = this.head;
        SinglyListNode<T> curreNode = previousNode.getNext();
        this.head.setNext(null);
        while (curreNode != null) {
            this.head = curreNode.getNext();
            curreNode.setNext(previousNode);
            previousNode = curreNode;
            curreNode = this.head;

        }
        this.head = previousNode;

    }

    public void delete(SinglyListNode<T> nodeDel) {
        if (this.isEmpty()) {
            return;
        }
        if (nodeDel == this.head) {
            this.head = nodeDel.getNext();
        }
        SinglyListNode<T> previousNode = this.head;
        while (previousNode != null) {
            if (previousNode.getNext() == nodeDel) {
                previousNode.setNext(nodeDel.getNext());
                break;
            }
            previousNode = previousNode.getNext();
        }
    }

    public SinglyListNode<T> getHead() {
        return this.head;
    }

    public void showGames() {
        if (this.isEmpty()) {
            System.out.println("No game released yet!");
        } else {
            SinglyListNode<T> current = this.head;
            while (current != null) {
                System.out.println(current.getValue());
            }
        }
    }
}
