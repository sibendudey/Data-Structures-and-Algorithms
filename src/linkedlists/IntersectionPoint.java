package linkedlists;

class LinkedListNode    {
    int data;
    LinkedListNode next;

    public LinkedListNode(int data)    {
        this.data = data;
    }
}
public class IntersectionPoint {
    public static void main(String args[])  {
        /** A Sample Test **/
        LinkedListNode head = new LinkedListNode(100);
        head.next = new LinkedListNode(200);
        head.next.next = new LinkedListNode(300);
        head.next.next.next = new LinkedListNode(400);
        head.next.next.next.next = new LinkedListNode(500);

        LinkedListNode head2 = new LinkedListNode(50);
        head2.next = new LinkedListNode(60);
        head2.next.next = new LinkedListNode(70);
        head2.next.next.next = new LinkedListNode(80);
        head2.next.next.next.next = new LinkedListNode(90);
        head2.next.next.next.next.next = head.next.next.next;

        // Finds the intersection point
        LinkedListNode intersection = intersectionPoint(head, head2);
        System.out.println(intersection.data);
    }

    private static LinkedListNode intersectionPoint(LinkedListNode head, LinkedListNode head2) {
        int len1 = length(head);
        int len2 = length(head2);

        if ( len1 > len2)   {
            int diff = len1 - len2;
            while (diff > 0) {
                head = head.next;
                --diff;
            }
        }
        else    {
            int diff = len2 - len1;
            while (diff > 0)    {
                head2 = head2.next;
                --diff;
            }
        }

        while (head.next != head2.next) {
            head = head.next;
            head2 = head2.next;
        }

        return head.next;
    }

    private static int length(LinkedListNode head) {
        int length = 0;
        while (head != null)    {
            length++;
            head = head.next;
        }

        return length;
    }
}
