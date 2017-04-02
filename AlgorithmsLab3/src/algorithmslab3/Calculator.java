package algorithmslab3;

/**
 *
 * @author Oona
 */
public class Calculator {
    int number1, number2, result;
    
    public Calculator() {
        number1 = 0;
        number2 = 0;
        result = 0;
    }
    
    public void addNumbers(simpleStack stack) {
        number1 = (int) stack.pop();
        number2 = (int) stack.pop();
        result = number1 + number2;
        stack.push(result);
    }
    
    public void subtractNumbers(simpleStack stack) {
        number2 = (int) stack.pop();
        number1 = (int) stack.pop();
        result = number1 - number2;
        stack.push(result);
    }
    
    public void printResult(simpleStack stack) {
        int topValue = (int) stack.pop();
        System.out.println("top value is " + topValue);
        stack.push(topValue);
    }
    
    public void printStack(simpleStack stack) {
        System.out.println("stack contained");
        stack.print();
    }
}
