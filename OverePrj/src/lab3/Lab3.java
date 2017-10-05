package lab3;

import java.util.ArrayList;

import matrix.Matrix;

public class Lab3 {

	public static boolean ifSame(int[][] P, int[][] Q) {
		boolean check = true;
		for (int i = 0; i < Q.length; i++) {
			for (int j = 0; j < Q.length; j++) {
				if(P[i][j]!=Q[i][j])
					check=false;
			}
		}
		return check;
	}
	
	public static int[][] matrixMultiply(int[][] matrix1, int[][]matrix2) {
		
		int[][] matrix = new int[matrix1.length][matrix1.length];
		
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1.length; j++) {
				for (int j2 = 0; j2 < matrix1.length; j2++) {
					if(matrix1[i][j2]==1 && matrix2[j2][j]==1)
						matrix[i][j]=1;
				}
			}
		}
		return matrix;
	}
	
	public static int[][] transitivLocking(int[][] P){
		ArrayList<Matrix> matrixs = new ArrayList<>();
		int[][] P2 = new int[P.length][P.length];
		for (int i = 0; i < P.length; i++) {
			for (int j = 0; j < P.length; j++) {
				for (int j2 = 0; j2 < P.length; j2++) {
					if(P[i][j2]==1 && P[j2][j]==1)
						P2[i][j]=1;
				}
			}
		}
		Matrix matrix = new Matrix();
		matrix.setMatrix(P);
		matrixs.add(matrix);
		matrix.setMatrix(P2);
		matrixs.add(matrix);
	
		for (int i = 1; i <10; i++) {
			Matrix matrixN = new Matrix();
			matrixN.setMatrix(matrixMultiply(matrixs.get(i).getMatrix(),matrixs.get(i-1).getMatrix()));
			matrixs.add(matrixN);
		}
		int[][] result = new int[P.length][P.length]; 
		for (int i = 0; i < matrixs.size(); i++) {
			for (int j = 0; j < matrixs.size(); j++) {
				if(matrixs.get(i).getMatrix()==matrixs.get(j).getMatrix()) {
				result=matrixs.get(i).getMatrix();
					break;
				}	
			}
		}
		return result;
	}
}
