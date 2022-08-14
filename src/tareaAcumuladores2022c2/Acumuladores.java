package tareaAcumuladores2022c2;

public class Acumuladores {

	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
		//IRREP NUMERO <=0 SI ES NEGATIVO Y MATIS VACIA
		if (mat.length==0 || num<=0) return false;
		boolean sialgunacolumna=false;
		//RECORRO LAS COLUMNAS POR RAMA
		for (int c=0; c<mat[0].length;c++) {
			boolean haymultiplo=true;			
			for(int f=0; f<mat.length; f++) {
				haymultiplo=haymultiplo && mat[f][c]%num==0;
			}sialgunacolumna=sialgunacolumna||haymultiplo;
		}return sialgunacolumna;
	}

	public boolean hayInterseccionPorFila(int[][] mat1, int[][] mat2) {
		// IRREP ALGUNA MATRIS <=0 Y UNA MAS GRANDE QUE LA OTRA EN N° DE FILAS
		if (mat1.length==0 || mat2.length==0 || (mat1.length != mat2.length)) return false;
		boolean todas=true;
		//SE UTILIZAN MATRICES AUXILARES SEGUN EL LARGO DE CADA MATRIZ(MAYOR COLUMNAS)
		int [][] mtx1,mtx2;
		if (mat2.length <= mat1.length) {
			mtx1=mat2;
			mtx2=mat1;
		}else {
			mtx1=mat1;
			mtx2=mat2;
		}
		//RECOORRO POR FILAS LAS MATRICES
		for (int fila1=0;fila1 <mtx1.length;fila1++) {
			boolean filas=false;
			for (int col1=0; col1 <mtx1[fila1].length;col1++) {
				for (int col2=0; col2 <mtx2[fila1].length; col2++) {
					filas= filas || (mtx1[fila1][col1] == mtx2[fila1][col2]);					
				}
			}todas = todas && filas;
		}return todas;		
	}

	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {
		// IRREP MATRIZ<0 Y LA COLUMNA>AL DE LA MATRIZ O NEGATIVO
		if (mat.length==0 || nColum > mat[0].length-1 || nColum<0) return false;
		boolean algunasuma=false;
		int sumacol=0;
		for (int f=0; f <mat.length; f++) {
			sumacol= sumacol + mat[f][nColum];
		}
		for(int f=0; f<mat.length;f++) {
			int sumafilas=0;
			for(int c=0;c<mat[f].length;c++) {				
				sumafilas+=mat[f][c];
			}algunasuma= algunasuma || sumafilas>sumacol;
		}return algunasuma;
	}

	public boolean hayInterseccionPorColumna(int[][] mat1, int[][] mat2) {
		// IRREP  MATRIZ VACIA Y DISTINTAS CANTIDAD DE COLUNAS ENTRE MATRICES
		if (mat1.length==0 || mat2.length==0 || mat1[0].length != mat2[0].length) return false;
		//RECORRIDO POR COLUMMAS
		boolean hayinter=true;
		for (int col1=0; col1 <mat1[0].length;col1++) {
			boolean intcol= false;
			for (int fila1=0; fila1 <mat1.length; fila1++) {
				for (int fila2=0; fila2 <mat2.length; fila2++) {
					intcol= intcol || (mat1[fila1][col1] == mat2[fila2][col1]);
				}
			}hayinter= hayinter && intcol;
		}return hayinter;
	}
}
