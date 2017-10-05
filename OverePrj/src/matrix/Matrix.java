package matrix;

import java.util.Arrays;

public class Matrix {

	private int[][]matrix;


	public Matrix() {
		super();
	}

	public Matrix(int[][] matrix) {
		super();
		this.matrix = matrix;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	@Override
	public String toString() {
		return "Matrix [matrix=" + Arrays.toString(matrix) + "]";
	}
	
	
	
}
