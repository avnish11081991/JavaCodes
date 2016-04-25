package demoClasses;

public class ProducerConsumer {

	
	public static void main(String[] args){
		
		final ProduceConsume produceConsume = new ProduceConsume();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				produceConsume.Produce();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				produceConsume.Consume();
			}
		});
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
