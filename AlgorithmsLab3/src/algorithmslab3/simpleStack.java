package algorithmslab3;

public class simpleStack<T extends Comparable<T>> {

    private static final int MAXN = 10;
    private int top;
    private T[] array;

    public simpleStack() {
        top = -1;
        array = (T[]) new Comparable[MAXN];
    }

    public boolean push(T item) {
        if (top >= MAXN - 1) {
            return false;
        } else {
            array[++top] = item;
        }
        return true;
    }

    public T pop() {
        if (top == -1) {
            return null;
        } else {
            return array[top--];
        }
    }

    public void print() {
        for (int i = top; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        
        simpleStack<Integer> stack = new simpleStack<>();
        Calculator calculator = new Calculator();
        char item;
        System.out.println("This is a RPN calculator. Enter operands and operators:");
        try {
            while(true) {
                item = (char)System.in.read();
                if(Character.isDigit(item)) {
                    stack.push(Character.getNumericValue(item));
                } else if(item == '+') {
                    calculator.addNumbers(stack);
                } else if(item == '-') {
                    calculator.subtractNumbers(stack);
                } else if(item == '=') {
                    calculator.printResult(stack);
                } else if(item == 'Q' || item == 'q') {
                    calculator.printStack(stack);
                    break;
                }
            }
        } catch(Exception e) {
            System.out.println("Exception: " + e);
        }
        
        
        
        /*simpleStack<Character> stack = new simpleStack();
        Character item;
        System.out.println("Enter a letter to push onto stack");
        System.out.println("or digit 1 to take a letter from stack");
        System.out.println("Return to end the program\n");
        try {
            item = new Character((char) System.in.read());
            while (item.compareTo(new Character('\n')) != 0) {
                if (item.compareTo(new Character('1')) == 0) {
                    System.out.println("Letter popped from stack is " + stack.pop());
                } else {
                    stack.push(item);
                }
                System.out.print("Stack content: ");
                stack.print();
                System.out.println();
                item = new Character((char) System.in.read());
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }*/
    }
}
