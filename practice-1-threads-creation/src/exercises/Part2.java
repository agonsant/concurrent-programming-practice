package exercises;

public class Part2 {

	private final int THREAD_COUNT = 100;

	public Part2() {
	}

	public void execute() {
		Part2Thread[] threads = new Part2Thread[this.THREAD_COUNT * 2];
		Shared shared = new Shared();
		for (int i = 0; i < this.THREAD_COUNT; i++) {
			threads[i] = new Part2Thread(false, shared);
		}

		for (int i = this.THREAD_COUNT; i < this.THREAD_COUNT * 2; i++) {
			threads[i] = new Part2Thread(true, shared);
		}

		for (int i = 0; i < this.THREAD_COUNT * 2; i++) {
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

	private class Part2Thread extends Thread {

		private final int OPERATIONS = 20;
		private boolean isDecrementor;
		private Shared shared;

		public Part2Thread(boolean isDecrementor, Shared sharedVariable) {
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
