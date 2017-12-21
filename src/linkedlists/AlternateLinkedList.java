//package linkedlists;
//
//public class AlternateLinkedList {
//
//	public static void main(String args[])	{
//		//LinkedList<Node> list = new LinkedList<Node>();
//		Node head = null;
//		head = appendNodes();
//		//printLinkedList(head);
//		//System.out.println();
//		swapPairs(head);
//		printLinkedList(head);
//
//	}
//
//	private static void printLinkedList(Node head) {
//		// TODO Auto-generated method stub
//		// TODO Auto-generated method stub
//		while (head != null)	{
//			System.out.print(head.data + " " );
//			head = head.next;
//		}
//
//	}
//
//	private static void swapPairs( Node head) {
//		// TODO Auto-generated method stub
//		Node temp = head;
//		Node reverseHead = null;
//		int length = calculateLengthList(head);
//		//System.out.println((float)length/2 + " " + Math.round((float)length/2));
//		for ( int i = 1 ; i <= Math.round((float)length/2); i++)	{
//			if ( i == Math.round((float)length/2))		{
//				reverseHead = temp.next;
//				temp.next = null;
//			}
//			else	{
//			temp = temp.next;
//			}
//		}
//
//		reverseHead = reverseLinkedList(null , reverseHead);
//
//		while ( reverseHead!= null)	{
//
//				Node tempNext = head.next;
//				head.next = reverseHead;
//				reverseHead = reverseHead.next;
//				head.next.next = tempNext;
//				head = tempNext;
//
//		}
//	}
//
//	private static int calculateLengthList(Node head) {
//		// TODO Auto-generated method stub
//		int count = 0;
//		while (head != null)	{
//			count++;
//			head = head.next;
//		}
//		return count;
//	}
//
//	private static Node appendNodes() {
//		// TODO Auto-generated method stub
//		Node head = new Node(1);
//		head.next = new Node(2);
//		head.next.next = new Node(3);
//		head.next.next.next = new Node(4);
//		head.next.next.next.next = new Node(5);
//		head.next.next.next.next.next = new Node(6);
//
//		head.next.next.next.next.next.next = new Node(7);
//
//		return head;
//
//
//	}
//
//	private static Node reverseLinkedList(Node previous , Node current) {
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
//
//		}
//	}
//
//}
