package Week6;

class Stack {
    int top;
    int[] array = new int[10];

    public boolean isEmpty() {
        return (top == 0);
    }
    public void push(int data) {
        try {
            array[top++] = data;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Stack is full!");
        }
    }

    public int pop() {
        if (isEmpty())
            throw new NullPointerException("Stack is empty!");
        array[top--] = 0;
        return array[top];
    }

    public void displayStack() {
        int temp = top;
        System.out.println("Stack is :");
        while (temp != 0) {
            if (temp == top) {
                System.out.println("+---+");
                System.out.println("| " + array[temp-- - 1] + " | --> TOP");
            }
            else {
                System.out.println("+---+");
                System.out.println("| " + array[temp-- - 1] + " |");
            }
        }
        System.out.println("+---+");
    }
}
public class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        System.out.println("Poped element is : "+ stack.pop());
        stack.displayStack();
    }
}
