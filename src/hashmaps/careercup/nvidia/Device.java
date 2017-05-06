package hashmaps.careercup.nvidia;

import java.util.*;

/**
 * Created by Sibendu on 4/24/2017.
 */
class TrieNode  {

    String value;
    HashMap<String, TrieNode> trieNodes;
    int count;

    TrieNode(String value)  {
        this.value = value;
        trieNodes = new HashMap<>();
    }

    public void addTrieNode(String trieNodeValue)   {
        if (trieNodes == null)
            trieNodes = new HashMap<>();

        trieNodes.put(value+trieNodeValue , new TrieNode(value+trieNodeValue));
    }

    public HashMap<String , TrieNode> getTrieNodes()   {
        return trieNodes;
    }

    public boolean isLeaf() {
        return trieNodes != null && trieNodes.size() > 0 ? false : true;
    }

}
public class Device {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String args[])  {
        TrieNode head = new TrieNode("//");
        int inputs = sc.nextInt();
        sc.nextLine();
        for ( int i = 0 ; i < inputs ; i++) {
            String input = sc.nextLine();
            parseInputs( head , input);
        }

        findCount(head);

    }

    private static void findCount(TrieNode head) {
        for ( Map.Entry<String , TrieNode> node : head.getTrieNodes().entrySet()) {
            System.out.println( node.getKey() + "=" + node.getValue().count);
            findCount(node.getValue());
        }
    }

    private static void parseInputs(TrieNode head, String input) {
        head.count++;
        for ( String str : input.split("/"))   {

            if ( !head.getTrieNodes().containsKey(head.value + str + "/"))   {
                head.getTrieNodes().put(head.value + str + "/" , new TrieNode( head.value + str + "/"));
            }
            head = head.getTrieNodes().get(head.value + str + "/");
            head.count++;
        }
    }
}