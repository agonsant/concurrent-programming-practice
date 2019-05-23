package exercises;

public class Shared {

	private int counter;

	private int[][] matrix_A;
	private int[][] matrix_B;
	private int[][] matrix_result;

	public Shared() {
		this.counter = 0;
	}

	public Shared(int matrixSize) {
		this.matrix_A = this.generateRandomMatrix(matrixSize);
		this.matrix_B = this.generateRandomMatrix(matrixSize);
		this.matrix_result = new int[matrixSize][matrixSize];
	}

	public void counterAdd() {
		this.counter++;
	}

	public void counterDec() {
		this.counter--;
	}

	public void calculateMatrixRow(int row) {
		for (int j = 0; j < this.matrix_result.length; j++) {
			this.matrix_result[row][j] = this.generateMatrixResult(row, j);
		}
	}

	private int generateMatrixResult(int row, int column) {
		int result = 0;
		for (int i = 0; i < this.matrix_A.length; i++) {
			result += this.matrix_A[row][i] * this.matrix_B[i][column];
		}
		return result;
	}
	
	private int[][] generateRandomMatrix(int size){
		int[][] result = new int[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0; j<size; j++) {
				result[i][j] = (int)(Math.random()*(10+1));
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return Integer.toString(this.counter);
	}

	public String matrixToString() {
		String txt = "";
		for (int i = 0; i < this.matrix_result.length; i++) {
			for (int j = 0; j < this.matrix_result.length; j++) {
				txt += " " + this.matrix_result[i][j];
			}
			txt += "\n";
		}
		return txt;
	}

}
