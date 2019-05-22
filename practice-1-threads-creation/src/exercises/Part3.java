package exercises;

public class Part3 {

	private final int THREAD_COUNT = 10;

	public Part3() {
	}

	public void execute() {
		Part3Thread[] threads = new Part3Thread[this.THREAD_COUNT];
		Shared shared = new Shared(this.THREAD_COUNT);
		for (int i = 0; i < this.THREAD_COUNT; i++) {
			threads[i] = new Part3Thread(i, shared);
			threads[i].start();
		}

		// Waiting for all threads to finish
		for (int i = 0; i < this.THREAD_COUNT; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Todos los Threads han terminado. El valor de la matriz resultado es: \n\n" + shared.matrixToString());
	}

	private class Part3Thread extends Thread {

		private int row;
		private Shared shared;

		public Part3Thread(int row, Shared sharedVariable) {
			this.row = row;
			this.shared = sharedVariable;
		}

		public void run() {
			this.shared.calculateMatrixRow(this.row);
		}

	}
}
