import java.util.Scanner;			//IMPORTA SCANNER
/**
 * @author Rodríguez López, Alejandro. UO281827
 * 	Intercambia las columnas última y la pasada como parámetro entre sí de la matriz pasada como parámetro.
 * 
 *	Contacto: 660 51 01 99 ~ Alex
 */

public class CambiaColumnas {

	/**
	 * Subrutina imprimeMatriz():
	 * 	Imprime la matriz pasada como @param
	 * 
	 * @param matriz.
	 */
	public static void imprimeMatriz (int [][] matriz) {
			//PARA CADA FILA DE LA MATRIZ
		for (int i=0;i<matriz.length;i++) {
				//PARA CADA COLUMNA DE LA MATRIZ
			for (int j=0;j<matriz.length;j++) {
						//IMPRIMIR VALOR
				System.out.printf("%4d",matriz[i][j]);
			}
					//SEPARADOR
			System.out.println();
		}
	}

	/**
	 * Subrutina mueveColumna():
	 * 	Cambia la columna pasada como @param por la última de la matriz pasada como @param
	 * 
	 * @param columna - Columna a cambiar por la última.
	 * @param matriz - Matriz sobre la que operar.
	 * @return Matriz cambiada.
	 */
	public static int [] [] mueveColumna (int columna, int [] [] matriz) {
		
			//INICIALIZAMOS MATRIZ AUX DE TAMAÑO IGUAL A LA ORIGINAL
		int [] [] matriznueva = new int [matriz[1].length][matriz.length];
		//INICIALIZAMOS VECTOR PARA ALMACENAR COLUMNA FINAL ORIGINAL
		int [] columnafinal = new int [matriz.length];
				
		for (int i=0;i<matriz[1].length;i++) {
			
			//RELLENAMOS MATRIZ AUX
			for (int j=0;j<matriz.length;j++) {
				matriznueva[i][j]=matriz[i][j];
			}
			
			//PARA CADA FILA
			columnafinal [i] = matriz[i][matriz[1].length-1];		//GUARDAR VALOR DE ÚLTIMA COLUMNA
				//SUSTITUIR VALOR DE ÚLTIMA COLUMNA POR COLUMNA PASADA COMO PARÁMETRO
			matriznueva [i][matriz[1].length-1] = matriz[i][columna];
			//SUSTITUIR VALOR DE ÚLTIMA COLUMNA POR VECTOR
			matriznueva [i][columna]=columnafinal[i];
		}

			//DEVOLVER MATRIZNUEVA
		return matriznueva;
	}
	
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);			//CREA TECLADO
		
		//INICIALIZA UNA MATRIZ Y DA VALORES
		int [] [] matriz = {{5,10,5,9,23,12},
				{16,30,25,41,50,9},
				{7,17,50,12,46,34},
				{45,8,22,34,8,48},
				{6,21,13,5,11,41},
				{23,45,16,18,29,25}};
		
		imprimeMatriz(matriz);		//IMPRIME LA MATRIZ ORIGINAL
			
				//SOLICITA DATO
		System.out.println("Introduzca número de columna a cambiar (Primera columna 1): ");
			//IMPRIMIRÁ LA MATRIZ		//DE COLUMNA PASADA POR TECLADO
		imprimeMatriz(mueveColumna(teclado.nextInt()-1,matriz));	
	}				//DE COLUMNA CAMBIADA			//DE LA MATRIZ ORIGINAL

}


