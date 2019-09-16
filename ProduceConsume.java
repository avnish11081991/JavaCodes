package demoClasses;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProduceConsume {
	
	//Test the application, trying to learn github (branches / master / tags)

	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(100);
	Random random = new Random();
	private Object lock = new Object();

	public void Produce(){

		while(true){
			synchronized (lock) {
				try {
					while(queue.size() == 100){
						lock.wait();
					}
					queue.put(random.nextInt(100));
					lock.notify();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void Consume(){

		while(true){
			synchronized (lock) {
				try {
					while(queue.size() ==0){
						lock.wait();
					}
					int valueTaken = queue.take();
					System.out.println("Value Out is "+valueTaken + " Queue Size is "+queue.size());
					lock.notify();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


}
