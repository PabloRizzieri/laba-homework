package custom;

public class CustomLinkedList<T> {
    private Node<T> head;
    private int size;

    // Constructor
    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Method to add an element at the beginning of the list
    public void addToBeginning(T data) {
        Node<T> newNode = new Node<T>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Method to print the elements of the list
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Inner Node class
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
