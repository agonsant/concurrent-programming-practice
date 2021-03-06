package exercises;

public class Part1 {

	private final int THREAD_COUNT = 1;

	public Part1() {
	}

	public void execute() {
		Part1Thread[] threads = new Part1Thread[this.THREAD_COUNT * 2];
		Shared shared = new Shared();
		for (int i = 0; i < this.THREAD_COUNT; i++) {
			threads[i] = new Part1Thread(false, shared);
			threads[i].start();
		}

		for (int i = this.THREAD_COUNT; i < this.THREAD_COUNT * 2; i++) {
			threads[i] = new Part1Thread(true, shared);
			threads[i].start();
		}

		// Waiting for all threads to finish
		for (int i = 0; i < this.THREAD_COUNT * 2; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Todos los Threads han terminado. El valor del contador es: " + shared);
	}

	private class Part1Thread extends Thread {

		private final int OPERATIONS = 500;
		private boolean isDecrementor;
		private Shared shared;

		public Part1Thread(boolean isDecrementor, Shared sharedVariable) {
			this.isDecrementor = isDecrementor;
			this.shared = sharedVariable;
		}

		public void run() {
			for (int i = 0; i < this.OPERATIONS; i++) {
				if (this.isDecrementor) {
					this.shared.counterDec();
				} else {
					this.shared.counterAdd();
				}
			}

		}

	}
}
