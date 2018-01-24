package queue;

import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> firstStack = new Stack<>();
    Stack<Integer> secondStack = new Stack<>();
    public QueueUsingStack()    {

    }

    public void add(int number) {
        firstStack.addAll(secondStack);
        secondStack.removeAllElements();
        secondStack.push(number);
        secondStack.addAll(firstStack);
        firstStack.removeAllElements();
    }

    public int remove() {
        int remove = -1;
        if (secondStack.size() > 0)    {
            remove = secondStack.pop();
        }

        return remove;
    }

    public static void main(String args[])  {
        QueueUsingStack queueUsingStack = new QueueUsingStack();

        queueUsingStack.add(2);
        queueUsingStack.add(3);
        queueUsingStack.add(4);

        System.out.println(queueUsingStack.remove());
        System.out.println(queueUsingStack.remove());
        System.out.println(queueUsingStack.remove());
        System.out.println(queueUsingStack.remove());

    }
}
