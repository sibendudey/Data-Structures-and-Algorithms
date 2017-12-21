//package arrays;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class ArrayReducedForm {
//
//    public static void main(String[] args) {
//
//        int arr[] = {5, 10, 40, 30, 20};
//        ArrayList<Integer> temp = new ArrayList<Integer>();
//        for (int numbers : arr) {
//            temp.add(numbers);
//        }
//        Collections.sort(temp);
//        for (int iterator = 0; iterator < arr.length; iterator++) {
//            int number = arr[iterator];
//            int index = temp.indexOf(number);
//            arr[iterator] = index;
//        }
//
//        int[][] arr1 = new int[2][3];
//
//        printReducedForm(arr);
//    }
//
//    private static void printReducedForm(int[] arr) {
//
//        for (int index : arr) {
//            System.out.print(index + " ");
//        }
//    }
//
//}
//
//
//    private void run() throws InterruptedException {
//        ExecutorService es = Executors.newCachedThreadPool();  // Simulating multiple threads in the system  // if one of them is executing a long-running task.  // Some of the other threads/tasks are waiting  // for it to finish
//        es.execute(() -> countPrimes(MAX, 1000)); //incorrect task  es.execute(() -> countPrimes(MAX, 0));  es.execute(() -> countPrimes(MAX, 0));  es.execute(() -> countPrimes(MAX, 0));  es.execute(() -> countPrimes(MAX, 0));  es.execute(() -> countPrimes(MAX, 0));  es.shutdown();  es.awaitTermination(60, TimeUnit.SECONDS);}private void countPrimes(int max, int delay) {  System.out.println(     range(1, max).parallel()        .filter(this::isPrime).peek(i -> sleep(delay)).count()  );}
