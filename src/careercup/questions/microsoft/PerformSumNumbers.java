package careercup.questions.microsoft;

import java.util.*;

/**
 * Created by sibendu on 20/6/17.
 * Question link -> https://www.careercup.com/question?id=5766700180963328
 */
public class PerformSumNumbers {

    private static HashMap<String, Integer> numberMapper;

    public PerformSumNumbers()  {
        numberMapper.put("zero" , 0);
        numberMapper.put("one" , 1);
        numberMapper.put("two" , 2);
        numberMapper.put("three" , 3);
        numberMapper.put("four" , 4);
        numberMapper.put("five" , 5);
        numberMapper.put("six" , 6);
        numberMapper.put("seven" , 7);
        numberMapper.put("eight" , 8);
        numberMapper.put("nine" , 9);
        numberMapper.put("minus" , -1);

    }

    static class TrieNode   {
        Map<Character , TrieNode> trieNodeMap;
        boolean isLeaf;
        String digit;
        int number;

        TrieNode(String digit)  {
            this.digit = digit;
            trieNodeMap = new HashMap<>();
            /*switch (digit)  {
                case "zero" : { isLeaf = true;
                                number = 0;
                            } break;
                case "one" : { isLeaf = true;
                    number = 0;
                }break;
                case "two" : { isLeaf = true;
                    number = 0;
                }break;
                case "three" : { isLeaf = true;
                    number = 0;
                }break;
                case "four" : { isLeaf = true;
                    number = 0;
                }break;
                case "five" : { isLeaf = true;
                    number = 0;
                }break;
                case "six" : { isLeaf = true;
                    number = 0;
                }break;
                case "seven" : { isLeaf = true;
                    number = 0;
                }break;
                case "eight" : { isLeaf = true;
                    number = 0;
                }break;
                case "nine" : { isLeaf = true;
                    number = 0;
                }break;
                case "minus" : {
                    isLeaf = true;
                    number = -1;
                }
                default: System.out.println(digit);
            }*/
        }

        public void addTrieNode(char c) {

            trieNodeMap.put(c , new TrieNode(digit + c));
        }

    }

    public static void main( String args[]) {

        TrieNode root = new TrieNode("");
        List<String> numberList = new ArrayList<>();
        numberList.add("zero");
        numberList.add("one");
        numberList.add("two");
        numberList.add("three");
        numberList.add("four");
        numberList.add("five");
        numberList.add("six");
        numberList.add("seven");
        numberList.add("eight");
        numberList.add("nine");
        numberList.add("minus");

        constructTrie(root , numberList);

        Scanner sc = new Scanner(System.in);

        String sac = sc.next();
        
        performSummation(sac , root);
    }

    private static void performSummation(String sac, TrieNode root) {

        String curr = "";
        int sum = 0;
        //int lastIndex = -1;
        int prev = 0;
        for ( int i = 0 ; i < sac.length() ; )   {
            curr =  "" + sac.charAt(i++);
            String searchResult = findNumber( curr , root);
            if ( searchResult != null)  {
                curr = curr + sac.charAt(i++);
                while ( (searchResult = findNumber(curr , root)) != null )  {
                    if ( numberMapper.get(searchResult) != null)    {
                        prev = prev * 10 + numberMapper.get(searchResult);
                    }
                }
            }
            else    {
                sum += prev;
                prev = 0;
            }
        }

        // Add up the remaining previous number
        sum += prev;

        System.out.println(sum);
    }

    private static String findNumber(String curr, TrieNode root) {

        System.out.println(".FindNumber(): Called for " + curr);

        TrieNode currNode = root;
        int index = 0;
        for ( ; index < curr.length() ; index++)  {
            if ( root.trieNodeMap.get(curr.charAt(index)) != null)  {
                currNode = root.trieNodeMap.get(curr.charAt(index));
                if ( currNode.isLeaf )  {
                    return currNode.digit;
                }
            }
            else
                break;
        }

        if ( index == curr.length() + 1)
            return curr;

        return null;
    }

    private static void constructTrie(TrieNode root, List<String> numberList) {

        numberList.forEach( (s) -> {
            TrieNode curr = root;
            for ( Character c : s.toCharArray())    {
                curr.trieNodeMap.put(c , new TrieNode(curr.digit + c));
                curr = curr.trieNodeMap.get(c);
            }
        });
    }


}
