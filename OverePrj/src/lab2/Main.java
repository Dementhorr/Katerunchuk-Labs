package lab2;

public class Main {

	public static int[][] logicMatrixBuild(int[] arr,int param){
		int[][] matrix = new int[arr.length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int temp = arr[i];
				if(param==1) {
					if(temp>=arr[j])
					matrix[i][j]=1;
					else {
						matrix[i][j]=0;
					}
				}
				if(param==2) {
					if(temp==arr[j])
					matrix[i][j]=1;
					else {
						matrix[i][j]=0;
					}
				}
				
			}
		}
		
		return matrix;
	}
	
	public static int[][] logicOperations(int[][]matrix1, int[][]matrix2, int param){
		int[][] matrix = new int[matrix1.length][matrix2.length];
		for (int i = 0; i < matrix1.length; i++) {
			for (int j = 0; j < matrix1.length; j++) {
				if(param==1) {
					if(matrix1[i][j]==1 && matrix2[i][j]==1)
						matrix[i][j]=1;
					else {
						matrix[i][j]=0;
					}
				}
				if(param==2) {
					if(matrix1[i][j]==1 || matrix2[i][j]==1)
						matrix[i][j]=1;
					else {
						matrix[i][j]=0;
					}
				}
				if(param==3) {
					if(matrix1[i][j]==1 && matrix2[i][j]==0)
						matrix[i][j]=1;
					else {
						matrix[i][j]=0;
					}
				}
				if(param==4) {
					if(matrix1[i][j]==0 && matrix2[i][j]==1)
						matrix[i][j]=1;
					else {
						matrix[i][j]=0;
					}
				}
				if(param==5) {
					if(matrix1[i][j]==0)
						matrix[i][j]=1;
					else {
						matrix[i][j]=0;
					}
				}
				if(param==6) {
					matrix[i][j]=matrix1[j][i];
				}
				if(param==7) {
					for (int j2 = 0; j2 < matrix.length; j2++) {
						if(matrix1[i][j2]==1 && matrix2[j2][j]==1)
							matrix[i][j]=1;
					}
					}
				
			}
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix,String name) {
		System.out.println();
		System.out.print(name);
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		int[] arr = {0,1,0,-1};
		int matrix1[][] = logicMatrixBuild(arr,1);
		int matrix2[][] = logicMatrixBuild(arr,2);
		int matrixAnd[][]=logicOperations(matrix1,matrix2,1);
		int matrixOr[][]=logicOperations(matrix1,matrix2,2);
		int matrixPnoQ[][]=logicOperations(matrix1,matrix2,3);
		int matrixQnoP[][]=logicOperations(matrix1,matrix2,4);
		int matrixPdeltaQ[][]=logicOperations(matrixPnoQ,matrixQnoP,2);
		int matrixNoP[][]=logicOperations(matrix1,matrix1,5);
		int matrixRevertP[][]=logicOperations(matrix1,matrix1,6);
		int matrixPcomositionQ[][]=logicOperations(matrix1,matrix2,7);
		printMatrix(matrix1,"P");
		printMatrix(matrix2,"Q");
		printMatrix(matrixAnd,"And");
		printMatrix(matrixOr,"Or");
		printMatrix(matrixPnoQ,"P/Q");
		printMatrix(matrixQnoP,"Q/P");
		printMatrix(matrixPdeltaQ,"P delta Q");
		printMatrix(matrixNoP,"not P");
		printMatrix(matrixRevertP,"Revert P");
		printMatrix(matrixPcomositionQ,"P composition Q");
	}

}
