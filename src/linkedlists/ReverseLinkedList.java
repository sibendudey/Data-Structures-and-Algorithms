//package linkedlists;
//
//public class ReverseLinkedList {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Node head = appendNodes();
//		//Node reverseHead = reverseLinkedList(null , head);
//		//Node reverseHead = reverseLLIterative(head);
//
//		Node middleNode = findMiddleNode(head);
//		System.out.println(middleNode.getData());
//		//printLinkedList(reverseHead);
//
//
//
//
//	}
//
//
//	private static Node findMiddleNode(Node head) {
//
//		Node middleNode = head;
//		Node doubleNode = head;
//
//		while ( doubleNode != null && doubleNode.next != null )	{
//			middleNode = middleNode.next;
//			doubleNode = doubleNode.next.next;
//		}
//
//		return middleNode;
//	}
//
//
//	private static Node reverseLLIterative(Node head) {
//
//
//		Node prev = null;
//		Node curr = head;
//
//		while ( curr != null)	{
//			Node temp = curr.next;
//			curr.next = prev;
//			prev = curr;
//			curr = temp;
//		}
//		return prev;
//	}
//
//
//	private static void printLinkedList(Node reverseHead) {
//		// TODO Auto-generated method stub
//		while (reverseHead != null)	{
//			System.out.print(reverseHead.data + " " );
//			reverseHead = reverseHead.next;
//		}
//	}
//
//
//	private static Node reverseLinkedList(Node previous,Node current) {
//		// TODO Auto-generated method stub
//		if (current.next == null)	{
//			current.next = previous;
//			return current;
//			}
//
//		else	{
//			Node temp = current.next;
//			current.next = previous;
//			Node head = reverseLinkedList(current , temp);
//			return head;
//		}
//	}
//
//
//	private static Node appendNodes() {
//		// TODO Auto-generated method stub
//		Node head = new Node(1);
//		head.next = new Node(2);
//		head.next.next = new Node(3);
//		head.next.next.next = new Node(4);
//		head.next.next.next.next = new Node(5);
//		head.next.next.next.next.next = new Node(6);
//		head.next.next.next.next.next.next = new Node(7);
//		head.next.next.next.next.next.next.next = new Node(8);
//		return head;
//	}
//
//}
