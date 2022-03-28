package Week6;

class Queue {
    int front, rear;
    int n;
    int[] array;

    public Queue(int n) {
        front = -1;
        rear = -1;
        this.n = n;
        array = new int[n];
    }

    public boolean isFull() {
        return (front == 0 && rear == this.n - 1);
    }

    public boolean isEmpty() {
        return front == -1;
    }
    public void enQueue(int data) {
        if (isFull())
          System.out.println("Queue is full");
        else {
          if (front == -1)
            front = 0;
          rear++;
          array[rear] = data;
        }
      }

    public int deQueue() {
        int element;
        if (isEmpty()) {
          System.out.println("Queue is empty");
          return -1;
        }
        else {
          element = array[front];
          if (front >= rear) {
            front = -1;
            rear = -1;
          }
          else
            front++;
          return element;
        }
      }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front ; i <= rear; i++) {
            if (i == rear) {
                System.out.println("-----");
                System.out.println("| " + array[i] + " | --> rear");
            } else if (i == front) {
                System.out.println("-----");
                System.out.println("| " + array[i] + " | --> front");
            }
            else {
                System.out.println("-----");
                System.out.println("| " + array[i] + " |");
            }
        }
        System.out.print("-----");
    }

}
public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue(20);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        //System.out.println("Is queue empty? " + queue.isEmpty());
        queue.deQueue();
        System.out.println("Element dequed is : " +queue.deQueue());
        queue.displayQueue();
    }
}
