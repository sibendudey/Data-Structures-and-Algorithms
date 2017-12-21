//package linkedlists;
//
//public class MergeKLinkedLists {
//
//	public static void main(String args[]) {
//		Node linkedList1 = createLinkedList1();
//		Node linkedList2 = createLinkedList2();
//		Node linkedList3 = createLinkedList3();
//		printLinkedList(linkedList1);
//		printLinkedList(linkedList2);
//		printLinkedList(linkedList3);
//		Node resultLisHead = merge(linkedList1, linkedList2, linkedList3);
//
//		printLinkedList(resultLisHead);
//	}
//
//	private static void printLinkedList(Node resultLisHead) {
//		// TODO Auto-generated method stub
//		while (resultLisHead != null)	{
//			System.out.print(resultLisHead.data + " ");
//			resultLisHead = resultLisHead.next;
//		}
//		System.out.println();
//	}
//
//	private static Node merge(Node linkedList1, Node linkedList2,
//			Node linkedList3) {
//		// TODO Auto-generated method stub
//		Node head = null;
//		Node current = null;
//		while (linkedList1 != null || linkedList2 != null
//				|| linkedList3 != null) {
//			if (head == null) {
//				if (linkedList1.data <= linkedList2.data) {
//					if (linkedList1.data <= linkedList3.data) {
//						head = linkedList1;
//						current = linkedList1;
//						linkedList1 = linkedList1.next;
//					} else {
//						head = linkedList3;
//						current = linkedList3;
//						linkedList3 = linkedList3.next;
//					}
//				} else {
//					if (linkedList2.data <= linkedList3.data) {
//						head = linkedList2;
//						current = linkedList2;
//						linkedList1 = linkedList2.next;
//					} else {
//						head = linkedList3;
//						current = linkedList3;
//						linkedList3 = linkedList3.next;
//					}
//				}
//			} else {
//				if ( (linkedList1 != null && linkedList2 != null ) && (linkedList1.data <= linkedList2.data)) {
//					if ( (linkedList3 != null) && (linkedList1.data <= linkedList3.data)) {
//						current.next = linkedList1;
//						current = current.next;
//						linkedList1 = linkedList1.next;
//					} else {
//						current.next = linkedList3;
//						current = current.next;
//						linkedList3 = linkedList3.next;
//					}
//				} else if (linkedList2 != null){
//					if ((linkedList3 != null ) && (linkedList2.data <= linkedList3.data)) {
//						current.next = linkedList2;
//						current = current.next;
//						linkedList2 = linkedList2.next;
//					} else {
//						current.next = linkedList3;
//						current = current.next;
//						linkedList3 = linkedList3.next;
//					}
//				}	else if ( linkedList3 != null)	{
//					 current.next = linkedList3;
//					 current = current.next;
//					 linkedList3 = linkedList3.next;
//				}
//			}
//		}
//
//		return head;
//	}
//
//	private static Node createLinkedList3() {
//		// TODO Auto-generated method stub
//		Node head = new Node(0);
//		head.next = new Node(9);
//		head.next.next = new Node(10);
//		head.next.next.next = new Node(11);
//		return head;
//	}
//
//	private static Node createLinkedList2() {
//		// TODO Auto-generated method stub
//		Node head = new Node(2);
//		head.next = new Node(4);
//		head.next.next = new Node(6);
//		head.next.next.next = new Node(8);
//		return head;
//	}
//
//	private static Node createLinkedList1() {
//		// TODO Auto-generated method stub
//		Node head = new Node(1);
//		head.next = new Node(3);
//		head.next.next = new Node(5);
//		head.next.next.next = new Node(7);
//		return head;
//	}
//}
