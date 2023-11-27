package custom;

import java.util.Comparator;

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

    // Method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Method to get the size of the list
    public int size() {
        return size;
    }

    public void sort(Comparator<T> comparator) {
        if (size <= 1) {
            return; // No need to sort
        }

        head = insertionSort(head, comparator);
    }

    // Insertion sort implementation for a linked list
    private Node<T> insertionSort(Node<T> start, Comparator<T> comparator) {
        Node<T> sorted = null; // Initialize an empty sorted list
        Node<T> current = start; // Start with the original list

        // Traverse the original list
        while (current != null) {
            Node<T> next = current.next; // Save the next node in the original list
            sorted = insertSorted(sorted, current, comparator); // Insert current node into the sorted list
            current = next; // Move to the next node in the original list
        }

        return sorted; // Return the sorted list
    }

    // Insert a node into the sorted position of the list using an external comparator
    private Node<T> insertSorted(Node<T> sortedList, Node<T> newNode, Comparator<T> comparator) {
        // If the sorted list is empty or the new node is smaller than the first node in the sorted list
        if (sortedList == null || comparator.compare(newNode.data, sortedList.data) <= 0) {
            newNode.next = sortedList; // Insert the new node at the beginning
            return newNode; // Return the updated sorted list
        }

        Node<T> current = sortedList; // Start with the first node in the sorted list

        // Find the correct position to insert the new node
        while (current.next != null && comparator.compare(newNode.data, current.next.data) > 0) {
            current = current.next; // Move to the next node in the sorted list
        }

        newNode.next = current.next; // Insert the new node into the sorted position
        current.next = newNode; // Update the link in the sorted list

        return sortedList;
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
