package arrays.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


abstract class Heap {
    List<Integer> heap = new ArrayList<>();

    public int getCount() {
        return heap.size();
    }

    public void add(int number) {
        heap.add(number);
        heapify(heap.size() - 1);
    }

    public int extractTop() {
        int top = heap.get(0);
        heap.remove(0);
        heapify(heap.size() - 1);
        return top;
    }

    abstract public void heapify(int i);

    public int top()    {
        return heap.get(0);
    }
}

class MinHeap extends Heap {

    @Override
    public void heapify(int i) {
        if (i < 0)
            return;

        int parent = (i - 1) / 2;
        if (heap.get(i) < heap.get(parent)) {
            Collections.swap(heap, i, parent);
            heapify(parent);
        }
    }
}

class MaxHeap extends Heap {

    @Override
    public void heapify(int i) {
        if (i < 0)
            return;

        int parent = (i - 1) / 2;
        if (heap.get(i) > heap.get(parent)) {
            Collections.swap(heap, i, parent);
            heapify(parent);
        }
    }
}

public class MedianInStream {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int median = 0;
        MinHeap minHeap = new MinHeap();
        MaxHeap maxHeap = new MaxHeap();

        while (true) {
            int N = sc.nextInt();
            median = findMedian(N, median, minHeap, maxHeap);
            System.out.println(median);
        }
    }

    private static int findMedian(int n, int median, MinHeap minHeap, MaxHeap maxHeap) {
        int diff = findSize(minHeap, maxHeap);
        int newMedian = 0;
        switch (diff) {
            case 0: {
                if (n > median) {
                    maxHeap.add(n);
                    maxHeap.heapify(maxHeap.getCount() - 1);
                    newMedian = maxHeap.extractTop();
                } else {
                    minHeap.add(n);
                    minHeap.heapify(minHeap.getCount() - 1);
                    newMedian = minHeap.extractTop();
                }
            }
            break;
            case 1: {
                if (n < median) {
                    int top = minHeap.extractTop();
                    minHeap.heapify(minHeap.getCount() - 1);
                    maxHeap.add(top);
                    maxHeap.heapify(maxHeap.getCount() - 1);
                    minHeap.add(n);
                    minHeap.heapify(minHeap.getCount() - 1);
                } else  {
                    maxHeap.add(n);
                    maxHeap.heapify(maxHeap.getCount() - 1);}

                newMedian = (maxHeap.top() + minHeap.top()) / 2;
            }

            case -1: {
                if (n > median) {
                    int top = maxHeap.extractTop();
                    maxHeap.heapify(maxHeap.getCount() - 1);
                    minHeap.add(top);
                    minHeap.heapify(minHeap.getCount() - 1);
                    maxHeap.add(n);
                } else {
                    minHeap.add(n);
                    minHeap.heapify(minHeap.getCount() - 1);
                }
                newMedian = (maxHeap.top() + minHeap.top()) / 2;
            }
        }
        return newMedian;
    }

    private static int findSize(MinHeap minHeap, MaxHeap maxHeap) {
        if (minHeap.getCount() == maxHeap.getCount())
            return 0;
        else if (minHeap.getCount() > maxHeap.getCount())
            return 1;
        else
            return -1;
    }

    private static void heapSort(List<Integer> array) {

    }
}
