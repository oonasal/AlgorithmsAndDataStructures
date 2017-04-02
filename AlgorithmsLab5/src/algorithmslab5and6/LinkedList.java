package algorithmslab5and6;

import java.util.Scanner;

public class LinkedList<T extends Comparable<T>> {

    private Node first;
    //private Node last;

    public LinkedList() {
        first = null;
        //last = null;
    }

    public void add(T item) {
        /*if (first != null) {
            Node prev = last;
            last = new Node(item, null);
            prev.next = last;
        } else {
            last = new Node(item, null);
            first = last;
        }*/

        if (first != null) {
            Node checkedNode = first;
            while (checkedNode.next != null) {
                checkedNode = checkedNode.next;
            }
            if (checkedNode.next == null) {
                Node anotherNode = new Node(item, null);
                checkedNode.next = anotherNode;
            }
        } else {
            first = new Node(item, null);
        }
    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node p = first;
        while (p != null) {
            s.append(p.data + " ");
            p = p.next;
        }
        return s.toString();
    }

    public void delete_first() {
        if (first != null) {
            first = first.next;
        }
    }

    public void delete_last() {
        if (first != null) {
            Node lastNode = first;
            Node secondLastNode = null;
            while (lastNode.next != null) {
                secondLastNode = lastNode;
                lastNode = lastNode.next;
            }
            if (find_pos_in_list(lastNode.data) == 0) {
                first = null;
            } else {
                lastNode = secondLastNode;
                lastNode.next = null;
            }
        }
    }

    public void insert_to_end(T item) {
        if (first != null) {
            Node lastNode = first;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = new Node(item, null);
        } else {
            add(item);
        }
    }

    public int find_pos_in_list(T item) {
        int position = 0;
        Node checkedNode = first;
        try {
            while (checkedNode.data != item) {
                checkedNode = checkedNode.next;
                position++;
            }
        } catch (NullPointerException e) {
            return -1;
        }
        return position;
    }

    public static void main(String[] args) {
        /*LinkedList<Character> list = new LinkedList<>();

        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');

        System.out.println("List: " + list);*/

        LinkedList<Character> list = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        int order_no;
        char to_be_searched;

        try {
            list.delete_last();
            list.insert_to_end('?');
            list.delete_last();
            list.insert_to_end('x');
            list.insert_to_end('a');
            list.insert_to_end('b');
            list.insert_to_end('c');
            list.insert_to_end('d');
            list.insert_to_end('y');
            System.out.println("List: " + list);
            System.out.print("Enter the first character to be searched: ");
            to_be_searched = s.next().charAt(0);
            if ((order_no = list.find_pos_in_list(to_be_searched)) >= 0) {
                System.out.println("The order no is " + order_no);
            } else {
                System.out.println("Not found");
            }
            System.out.print("Enter the second character to be searched: ");
            to_be_searched = s.next().charAt(0);
            if ((order_no = list.find_pos_in_list(to_be_searched)) >= 0) {
                System.out.println("The order no is " + order_no);
            } else {
                System.out.println("Not found");
            }
            list.delete_first();
            System.out.println("List: " + list);
            list.delete_last();
            System.out.println("List: " + list);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }

    }
}
