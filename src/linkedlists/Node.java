package linkedlists;

public class Node	{
	int data;

	private Node next;
	private Node previous;
	private Node random;

    public Node(int data)	{
		this.data = data;
	}
	
	public Node() {

	}

	public Node getNext()	{
		return next;
	}
	
	public int getData()	{
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

    public Node getRandom() {
        return random;
    }

    public void setRandom(Node random) {
        this.random = random;
    }


    public static Node createLL()	{
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		return head;
	}
	
	public static void printLL(Node head)	{
		while ( head != null)	{
			System.out.print( head.data + " ");
			head = head.next;
		}
	}
}

