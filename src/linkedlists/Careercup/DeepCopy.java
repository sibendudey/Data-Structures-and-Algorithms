package linkedlists.Careercup;

import linkedlists.LinkedListBuilder;
import linkedlists.Node;

/**
 * Created by Sibendu dey on 4/21/2017.
 * <p>
 * This is a solution to question appeared in careercup
 * Hyperlink: https://www.careercup.com/question?id=5758891578097664
 */
public class DeepCopy {

    public static void main(String args[]) {
        Node head = LinkedListBuilder.BuildLinkedListWithRandomPointer();
        Node copyHead = createCopy(head);

        while (copyHead != null) {
            System.out.println("Node value:" + copyHead.getData() + " Random value:" + copyHead.getRandom().getData());
            copyHead = copyHead.getNext();
        }
    }

    private static Node createCopy(Node head) {


        Node currNode = head;
        while (currNode != null) {
            Node temp = new Node(currNode.getData());
            temp.setNext(currNode.getNext());
            currNode.setNext(temp);
            currNode = temp.getNext();
        }

        currNode = head;
        Node newListHead = currNode.getNext();
        Node newCurrentNode = currNode.getNext();


        while (currNode != null) {
            newCurrentNode = currNode.getNext();
            if (currNode.getRandom() != null) {
                newCurrentNode.setRandom(currNode.getRandom().getNext());
            }

            currNode.setNext(newCurrentNode.getNext());
            newCurrentNode.setNext(currNode.getNext());
            currNode = currNode.getNext();
        }


        return newListHead;
    }
}
