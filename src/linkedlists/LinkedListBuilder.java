package linkedlists;


/**
 * Created by Sibendu Dey on 4/21/2017.
 *
 * Utility class to build linked lists.
 */
public class LinkedListBuilder {

    public static Node BuildLinkedListWithRandomPointer()    {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node( 3);
        Node fourth = new Node( 4);

        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        head.setRandom(fourth);
        third.setRandom(second);
        fourth.setRandom(head);
        second.setRandom(third);

        return head;

    }
}
