package algorithmslab7;

/**
 *
 * @author Oona
 * @param <T>
 */
public class DoublyLinkedList<T extends Comparable<T>> {
    private Node first;
    private Node last;

    public DoublyLinkedList() {
        initialize_dbl();
    }

    private void initialize_dbl() {
        first = null;
        last = null;
    }

    public void print() {
        Node traverse = first;
        System.out.print("List: ");
        while (traverse != null) {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }
        System.out.println("");
    }

    public void print_reverse() {
        Node traverse = last;
        System.out.print("List: ");
        while (traverse != null) {
            System.out.print(traverse.data + " ");
            traverse = traverse.previous;
        }
        System.out.println("");
    }

    public void insert_to_back(T item) {
        last = new Node(item, null, last);
        if (last.previous != null) {
            last.previous.next = last;
        }
        if (first == null) {
            first = last;
        }
    }

    public void insert_to_front(T item) {
        first = new Node(item, first, null);
        if (first.next != null) {
            first.next.previous = first;
        }
        if (last == null) {
            last = first;
        }
    }

    private class Node {

        private T data;
        private Node next;
        private Node previous;

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList<Integer> dbl = new DoublyLinkedList<>();
        //int order_no;
        //char to_be_searched;

        dbl.print();
        dbl.print_reverse();
        
        dbl.insert_to_back(10);
        dbl.print();
        dbl.print_reverse();
        
        dbl.insert_to_front(20);
        dbl.print();
        dbl.print_reverse();
        
        dbl.insert_to_back(30);
        dbl.print();
        dbl.print_reverse();
        
        dbl.insert_to_front(40);
        dbl.print();
        dbl.print_reverse();
        
        dbl.insert_to_back(50);
        dbl.print();
        dbl.print_reverse();
    }
}
