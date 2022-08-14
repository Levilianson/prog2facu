package p0;

public class P0Acomuladores {
	public static void main(String[] args) {
		int lista[] = { 10, 20, 30, 40, 50, 60, 70 };
		int lista2[]= {10,20,71};
		int lista3[]= {};
		
		int[][] mtx = {{1, -2, 3}, {4, 5, -6},{-5, 7, 9}};
		int[][] mtx1 = {{1, -2, 3}, {4, 5, -6}};
		int[][] mtx2 = {{1, 2, 3}, {4, 5, 6},{7, 8,9}};
		
		int[][] mat= {{9,2,4,5},{6,7,1,7},{3,5,9,11},{12,8,5,10}};
		int[] arreglo= {4,7,5,1};
		//System.out.println(mayor10(lista));//P0EJ01
		//System.out.println(pertenecenTodos(lista2,lista));
		//System.out.println(pertenecenTodos(lista,lista2));
		//verMatriz(mtx2);
		//System.out.println(tieneNegativos(mtx));
		//System.out.println(mayorDiversidad(mtx1));
		System.out.println(arregloEnFilas(mat,arreglo));
	}
	// SI TODOS SON MAJORES QUE 10
	static public boolean mayor10(int[] lista) {
		//P0EJ01
		boolean mayor=true;
		for(int a: lista) {
			mayor=mayor && a>10;
		}		
		return mayor;
	}
	//SI UN ARREGLO ES SUBCONJUNTO DE OTRO
	static public boolean pertenecenTodos(int[] elem, int[] arreglo) {
		//P0EJ02
		if (elem.length==0)return true;
		if (elem.length==0)return false;
		boolean ret=true;
		for(int a:elem) {
			boolean aux=false;
			for (int b:arreglo) {
				aux=aux||a==b;
			}
			ret=ret&&aux;
		}
		return ret;
	}
	static public boolean tieneNegativos(int [][] mat) {
		boolean ret=true;
		boolean aux= false;
		for(int f=0; f<mat.length;f++) {
			aux=false;
			for(int c=0;c<mat[f].length;c++) {
				aux=aux || mat[f][c]<0;
			}ret=ret && aux;
		}
		return ret;
	}
	//RECORRER MATRIZ POPR FILAS Y COLUMNAS
	static void verMatriz(int[][] mtx) {
		//POR FILAS
		for(int f=0; f<mtx.length;f++)
			for(int c=0;c<mtx[f].length;c++) {
				System.out.printf("fila[%d][%d] = %d\n",f,c, mtx[f][c]);
			}
		//POR COLUMNAS 		
		for(int c=0; c < mtx[0].length;c++) {
			for(int f=0; f<mtx.length;f++)
				System.out.printf("columna[%d][%d] = %d\n",f,c, mtx[f][c]);
			}
	}
	// FILAS EN ORDEN ASCENDENTE Y LAS COLUMNAS CON ELEMENTO PAR E IMPAR
	public static boolean mayorDiversidad(int[][] mtx) {
		boolean asc=true;
		
		boolean aux=true;
		//IREP
		for(int f=0; f<mtx.length-1;f++) {		
			aux=aux&&(mtx[f].length==mtx[f+1].length);
		
		}
		//FILAS
		for(int f=0; f<mtx.length;f++) {	
			for(int c=0;c<mtx[f].length-1;c++) 				
				asc=asc && mtx[f][c]<mtx[f][c+1];				
		}
		//COLUMNAS
		for(int c=0; c < mtx[0].length;c++) {
			boolean par=false, impar=false;
			for(int f=0; f<mtx.length;f++) {
				par=par|| mtx[f][c]%2==0;
				impar=impar|| mtx[f][c]%2==1;				
			}aux=aux&&impar&&par;		
		}
		return aux&&asc;
	}
	//SI EL ELEMENTO SE ENCUENTRA EN LA FILA,
	public static boolean arregloEnFilas(int[][]mat, int [] arreglo) {
		boolean aux;
		boolean esta=true;
	for(int f=0; f<mat.length;f++) {
		aux=false;
		for(int c=0;c<mat[f].length;c++) {
			System.out.print(arreglo[f]);
			System.out.printf("fila[%d][%d] = %d\n",f,c, mat[f][c]);
			
			aux=aux||mat[f][c]==arreglo[f];
		}esta=esta&&aux;
	}
	return esta;
	}
}
