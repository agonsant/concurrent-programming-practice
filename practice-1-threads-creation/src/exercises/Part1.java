package exercises;

public class Part1 {
	
	private final int THREAD_COUNT=100;
	private final long SLEEP_TIME=1000; //1 s
	
	public Part1(){
		
	}
	
	public void execute() {
		Part1Thread[] threads = new Part1Thread[this.THREAD_COUNT];
		for(int i=0; i<this.THREAD_COUNT; i++) {
			threads[i] = new Part1Thread(this.SLEEP_TIME);
			threads[i].start();
		}
		
		//Waiting for all threads to finish
		for(int i=0; i<this.THREAD_COUNT; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Todos los Threads han terminado.");
	}
	
	
	private class Part1Thread extends Thread{
		
		private long sleepTime;
		
		public Part1Thread(long sleepTime){
			this.sleepTime = sleepTime;
		}
		
		public void run() {
			System.out.println("Inicio Thread: " + this.getId() + ' ' + this.getName());
			try {
				Thread.sleep(this.sleepTime);
			} catch (InterruptedException e) {
				System.err.println("Error en Thread: " + this.getId() + ' ' + this.getName());
				e.printStackTrace();
			}
			System.out.println("Fin Thread: " + this.getId() + ' ' + this.getName());
		
		}
		
	}
}
