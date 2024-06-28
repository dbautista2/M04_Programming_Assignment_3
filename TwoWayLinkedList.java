
// 24.3
import java.util.NoSuchElementException;

public class TwoWayLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public TwoWayLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // Node class definition
    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> previous;

        public Node(E data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    // Method to add an element to the end of the list
    public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (last == null) { // List is empty
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
        size++;
    }

    // Method to remove the last element from the list
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        Node<E> temp = last;
        if (first == last) { // Only one element in the list
            first = last = null;
        } else {
            last = last.previous;
            last.next = null;
        }
        size--;
        return temp.data;
    }

    // Method to get the size of the list
    public int size() {
        return size;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to print the elements of the list
    public void printList() {
        Node<E> current = first;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Test main method
    public static void main(String[] args) {
        TwoWayLinkedList<Integer> list = new TwoWayLinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("List size: " + list.size()); // Output: 4
        list.printList(); // Output: 1 2 3 4

        list.removeLast(); // Remove 4
        list.removeLast(); // Remove 3

        System.out.println("List size after removal: " + list.size()); // Output: 2
        list.printList(); // Output: 1 2
    }
}