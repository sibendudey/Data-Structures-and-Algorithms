package com.sibendu.threads.programming;

import java.util.ArrayList;
import java.util.List;

class PCThread 	{
	public static void main(String[] args) throws InterruptedException{
		
		final ProducerConsumer pc = new ProducerConsumer();
		Thread T1 = new Thread(new Runnable() {
			
			@Override
			public void run()  {
				// TODO Auto-generated method stub
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		Thread T2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		T1.start();

		T2.start();
		T1.join();
		T2.join();
		T2.join();
	}
	
	
}


public class ProducerConsumer {
	int value = 0 ;
	List<Integer> list = new ArrayList<Integer>();
	private int maxCapacity = 2; 
	public void produce() throws InterruptedException{
		while(true)	{
		synchronized(this)	{
			
			if (list.size() == maxCapacity )	{
				wait();
			}
			
			int addedValue = value++;
			list.add(addedValue);
			
			System.out.println("Produced value:" + addedValue);
			
			notify();
			
			Thread.sleep(1000);
		}
		}
	}
	
	public void consume() throws InterruptedException	{
		while(true)	{
			synchronized(this)	{
				if (list.size() == 0)
					wait();
				
				int consume = list.remove(0);
				System.out.println("consumed:" + consume);
				notify();
				
				Thread.sleep(1000);
			}
		}
	}
}

