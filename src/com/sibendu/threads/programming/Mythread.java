package com.sibendu.threads.programming;

public class Mythread extends Thread {

    private static int j = 0;
    private static int mutex = 0;  // Initial value of the mutex is 0;

    @Override
    public void run() {


        while (test_and_set(mutex) == 1) {

            // wait here if mutex is 1
            System.out.println("Thread waiting..");
        } 

        for (int i = 1; i <= 10; i++) { // Start of Critical section 
            j += i;                     // 

        }
        System.out.println(j);       // End of Critical section 
                                     // Should add on 55 to j if one thread is running through the CS

       mutex = 0; // Thread that has finished the CS sets the mutex to 0.

    }

    public static int test_and_set(int oldMutexValue) {
        if (mutex == 0) {
            mutex = 1;
        }
        return oldMutexValue;
    }


}

class Test1 {




    public static void main(String[] args) {

        Mythread thread1 = new Mythread();
        Mythread thread2 = new Mythread();
        Mythread thread3 = new Mythread();
        thread1.start();
        thread2.start();
        thread3.start();

    }



}