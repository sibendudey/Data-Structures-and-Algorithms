package hash.tables.leetcode;

import java.util.*;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class LongestPalindrome {
    public static void main(String args[]) {
        LongestPalindrome ll = new LongestPalindrome();
        System.out.println(ll.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.putIfAbsent(c, 0);
            countMap.put(c, countMap.get(c) + 1);
        }

        AtomicInteger max = new AtomicInteger(0);

        int even = countMap.entrySet().stream().filter(entry -> entry.getValue() % 2 == 0 )
                .mapToInt(entry -> entry.getValue()).sum();
        int result = countMap.entrySet().stream()
                .collect(() -> new AtomicInteger(0),
                        (at, entry) -> {
                            if (entry.getValue() % 2 == 0) {
                                at.set(at.get() + entry.getValue());
                            } else {
                                at.set(at.get() + entry.getValue() - 1);
                            }
                        }, (at1, at2) -> at2.set(at1.get() + at2.get())).intValue();

        return result == s.length() ? result : result + 1;
    }
}
