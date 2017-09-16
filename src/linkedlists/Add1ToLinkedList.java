package linkedlists;

public class Add1ToLinkedList {
	static Node head = new Node(2);
	public static void main(String args[])	{
		createLinkedList(head);
		printLinkedList(head);
		head = add1toList(head);
		printLinkedList(head);
	}
	private static void printLinkedList(Node head) {
		// TODO Auto-generated method stub
		System.out.println("Linked List values are");
		while ( head != null)	{
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
		System.out.println();
	}
	private static Node add1toList(Node head) {
		// TODO Auto-generated method stub
		int carryOver = 0;
		if (head.getNext() != null)	{
			carryOver = add1util(head.getNext());
		}
		
		int data = head.getData();
		int temp = (data + carryOver) % 10;
		head.setData(temp);
		carryOver = (data + carryOver) / 10;
		if (carryOver == 1)	{
			Node prevHead = head;
			head = new Node(carryOver);
			head.setNext(prevHead);
		}
		return head;
	}
	private static int add1util(Node curr) {
		// TODO Auto-generated method stub
		int carryOver = 0;
		if (curr.getNext() != null)	{
			carryOver = add1util(curr.getNext());
			int data = curr.getData();
			int temp = (data + carryOver) % 10;
			curr.setData(temp);
			carryOver = (data + carryOver) / 10; 
		}
		else	{
			int data = curr.getData();
			int temp = (data + 1) % 10;
			carryOver = (data + 1) / 10; 
			curr.setData(temp);
		}
		return carryOver;
	}
	private static void createLinkedList(Node head) {
		// TODO Auto-generated method stub
		head.setNext(new Node(0));
		head = head.getNext();
		head.setNext(new Node(0));
		head = head.getNext();
		head.setNext(new Node(0));
	}
}
