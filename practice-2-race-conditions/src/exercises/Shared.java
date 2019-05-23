package exercises;

public class Shared {

	private volatile int counter;

	public Shared() {
		this.counter = 0;
	}

	public void counterAdd() {
		this.counter++;
	}

	public void counterDec() {
		this.counter--;
	}

	@Override
	public String toString() {
		return Integer.toString(this.counter);
	}

}
