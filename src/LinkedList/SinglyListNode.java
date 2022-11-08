package LinkedList;

public class SinglyListNode <T>{
    private SinglyListNode<T> next;
    private T value;

    public SinglyListNode(T value, SinglyListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public SinglyListNode<T> getNext() {
        return this.next;
    }

    public void setNext(SinglyListNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}