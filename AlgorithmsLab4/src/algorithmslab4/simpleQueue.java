package algorithmslab4;

public class simpleQueue<T extends Comparable<T>> {

    private static int MAXN = 5;
    private int number_of_items;
    private T[] array;

    public simpleQueue() {
        number_of_items = 0;
        array = (T[]) new Comparable[MAXN];
    }

    public boolean enqueue(T item) {
        
        if (number_of_items >= MAXN) {
            MAXN += 5;
            T[] newArray = (T[]) new Comparable[MAXN];
            System.out.println("size is increased and is now " + MAXN + " items");
            for(int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            newArray[number_of_items++] = item;
            array = newArray;
            
        } else {
            array[number_of_items++] = item;
        }
        return true;
        
        
    }

    public T dequeue() {
        if (number_of_items == 0) {
            return null;
        } else {
            T item = array[0];
            for (int i = 0; i < number_of_items - 1; i++) {
                array[i] = array[i + 1];
            }
            number_of_items--;
            return item;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < number_of_items; i++) {
            s.append(array[i] + " ");
        }

        return s.toString();
    }

    public static void main(String[] args) {
        simpleQueue<Character> queue = new simpleQueue();
        Character item;

        System.out.println("Enter a letter to push onto stack");
        System.out.println("or digit 1 to dequeue a letter");
        System.out.println("Return to end the program\n");
        try {
            //item = new Character((char) System.in.read());
            while (/*item.compareTo(new Character('\n')) != 0 */true) {
                item = new Character((char) System.in.read());
                if (item.compareTo(new Character('1')) == 0) {
                    System.out.println("A letter dequeued " + queue.dequeue());
                } else if(Character.toString(item).equals("\n")) {
                    break;
                } else {
                    queue.enqueue(item);
                }

                System.out.println("Queue content: [" + queue + "]");
                item = new Character((char) System.in.read());
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
