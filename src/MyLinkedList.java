public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0 ;

    public int getSize() {
        return size;
    }

    public MyLinkedList() {
        last = new Node<E>(null, first, null);
        first = new Node<E>(null,null,last);
    }

    public void pushFirst(E data) {
        Node<E> next = first;
        next.setData(data);
        first = new Node<E>(null,null,next);
        next.setPrev(first);
        size++;
    }

    public void pushLast(E data) {
        Node<E> prev = last;
        prev.setData(data);
        last = new Node<E>(null,prev,null);
        prev.setNext(last);
        size++;
    }

    public void pushIndex(int index, E data) {
        Node<E> currNode = first;
        for (int i = 0; i <= index-1; i++) {
            currNode = currNode.getNext();
        }
        Node<E> added = new Node<E>(data,currNode,currNode.getNext());
        currNode.getNext().setPrev(added);
        currNode.setNext(added);
        size++;

        System.out.println("Element : " + added.getData() + " added");
    }

    public void removeFirst() {
        System.out.println("Element : " + first.getNext().getData() + " deleted");
        first = first.getNext();
        size--;
    }

    public void removeLast() {
        System.out.println("Element : " + last.getPrev().getData() + " deleted");
        last = last.getPrev();
        size--;
    }

    public void removeIndex(int index) {
        Node<E> currNode = first;
        for (int i = 0; i <= index; i++) {
            currNode = currNode.getNext();
        }
        currNode.getPrev().setNext(currNode.getNext());
        currNode.getNext().setPrev(currNode.getPrev());
        System.out.println("Element : " + currNode.getData() + " deleted");
        currNode = null;
        size--;
    }

    public E get(int index) {
        Node<E> currNode = first;
        for (int i = 0; i <= index; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getData();
    }

    public void print() {
        Node<E> currNode = first.getNext();
        while (currNode != last) {
            System.out.println(currNode.getData());
            currNode = currNode.getNext();
        }
    }

}