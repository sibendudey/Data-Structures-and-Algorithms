package randomization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Leetcode problem 382.
 *
 * Time complexity: O(N) for initialization where N is the number of nodes in the Linked List
 * O(1) for fetching random node.
 * Space complexity: O(N)
 */
public class RandomLinkedNode {
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    private List<Integer> l = new ArrayList<>();
    private Random r = new Random();
    public RandomLinkedNode(ListNode head) {
        ListNode temp = head;
        while (temp != null)    {
            l.add(temp.val);
            temp = temp.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int random = r.nextInt(l.size());
        return l.get(random);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
