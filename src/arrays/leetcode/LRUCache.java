package arrays.leetcode;

import java.util.*;
class LRUCache {

    int capacity;
    LinkedHashSet<Integer> timeStamps = new LinkedHashSet<>();
    Map<Integer, Integer> keyValue = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer value = keyValue.get(key);
        if ( value == null)
            return -1;
        else    {
            timeStamps.remove(key);
            timeStamps.add(key);
            return keyValue.get(key);
        }
    }

    public void put(int key, int value) {
        if ( keyValue.size() == capacity && !keyValue.containsKey(key))   {
            Iterator<Integer> itr = timeStamps.iterator();
            Integer i = null;
            while (itr.hasNext())   {
                i = itr.next();
                itr.remove();
                break;
            }
            keyValue.remove(i);
        }

        timeStamps.remove(key);
        timeStamps.add(key);
        keyValue.put(key, value);
    }
}

