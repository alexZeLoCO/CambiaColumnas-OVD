import java.util.Scanner;			//IMPORTA SCANNER
/**
 * @author Rodr�guez L�pez, Alejandro. UO281827
 * 	Inspirado en el trabajo obligatorio del grado de Ingenier�a de Inform�tica del Software, Universidad de Oviedo.
 * 	
 * 	El programa contiene varios m�todos para realizar diferentes operaciones con matrices como modificar la posici�n de sus columnas, rotarlas etc...
 * 
 *	Contacto: 660 51 01 99 ~ Alex
 */

public class EjercicioObligatorioSeminario_OVD {

	
	/**
	 * Subrutina Matrix():
	 * 	Valida el valor pasado como par�metro. Debe ser mayor igual que 2 y menor igual que 10.
	 * 	Hasta que el valor introducido no sea v�lido se seguir�n pediendo valores.
	 * 
	 * 	Crea una matriz de tama�o especificado y le da valores aleatorios entre 0 y 100.
	 * 
	 * @param size - Tama�o de la matriz (hay que validar).
	 * @return matriz - Matriz de valores aleatorios entre 0 y 100.
	 */
	public static int [][] Matrix (int size) {
		Scanner teclado = new Scanner (System.in);		//CREA UN TECLADO
		
			//MIENTRAS EL TAMA�O NO SEA V�LIDO.
		while (size<2 || size>10) {
			System.out.print("El tama�o ha sido invalidado. Debe pertenecer a [2,10]: ");	//PEDIR NUEVO VALOR
			size = teclado.nextInt();		//ACTUALIZAR TAMA�O
		}
				//CREAR NUEVA MATRIZ DE TAMA�O VALIDADO.
		int [][] matriz = new int [size][size];
		
			//PARA CADA FILA
		for (int i=0;i<matriz.length;i++) {
					//PARA CADA COLUMNA
			for (int j=0;j<matriz.length;j++) {
				matriz[i][j]=(int)(Math.random()*100);		//DAR UN VALOR ENTERO ALEATORIO ENTRE 0 Y 100
				
				/*
				 * Math.random() devuelve un valor double entre 0 y 1. Para llegar a nuestro entero entre 0 y 100 primero
				 * multiplicaremos el double por 100 y despu�s lo pasaremos a entero.
				 */
			}
		}
		return matriz;		//RETURN MATRIZ
	}

	/**
	 * Subrutina swapReverseByDiagonals():
	 * 	Modifica la matriz pasada como par�metro intercambiando su diagonal principal con la secundaria y viceversa.
	 * 	Para ello, utiliza un vector auxiliar.
	 * 
	 * @param matriz - Matriz original.
	 * @return matriz - Misma matriz modificada intercambiando sus diagonales.
	 */
	public static int[][] swapReverseByDiagonals(int [][] matriz) {
		
		/*
		 * LA ESTRATEGIA:
		 * 	Podr�amos utilizar una matriz auxiliar e ir pasando los valores de una a otra. Pero para no crear una matriz nueva,
		 * 	usaremos un vector para almacenar los valores de una diagonal. Cambiaremos los valores de la diagonal que hemos guardado
		 * 	en el vector por los debidos y despu�s, utilizaremos los valores del vector para pasarlos a la diagonal que nos queda.
		 * 
		 * 	Si no utiliz�semos un vector auxiliar, perder�amos los valores de una de las diagonales -la que cambiemos primero- y 
		 * 	no podr�amos finalizar el ejericicio.
		 */
		
				//CREA VECTOR AUXILIAR PARA ALMACENAR UNA DE LAS DIAGONALES
		int [] diagonalSecundaria = new int [matriz.length];
		int j=matriz.length-1;		//INICIALIZAMOS J COMO �NDICE DE LA �TLIMA COLUMNA � FILA DE LA MATRIZ
				//PARA CADA VALOR DE LA DIAGONAL
		for (int i=0;i<matriz.length;i++, j--) {	

			diagonalSecundaria[i]=matriz[i][j];		//SALVAGUARDAR VALOR DE DIAGONAL SECUNDARIA EN VECTOR
			matriz[i][j]=matriz[i][i];				//ACTUALIZAR VALOR DE DIAGONAL SECUNDIARIA POR EL DE LA PRINCIPAL
			matriz[i][i]=diagonalSecundaria[i];		//ACTUALIZAR VALRO DE DIAGONAL PRINCIPAL POR LOS DEL VECTOR

		}
		return matriz;
	}

	
	/**
	 * Subrutina rotateMatrix():
	 * 	Gira la matriz pasada como par�metro 90� en sentido antihorario.
	 * 
	 * @param matriz - Matriz original.
	 * @return matriznueva - Una nueva matriz igual a la pasada como par�metro girada 90� en sentido antiohorario.
	 */
	public static int[][] rotateMatrix (int [][] matriz){
				//CREA NUEVA MATRIZ DE MISMO TAMA�O
		int [][] matriznueva = new int [matriz.length][matriz.length];
				//PARA CADA FILA
		for (int i=0;i<matriz.length;i++) {
					//PARA CADA COLUMNA
			for (int j=0;j<matriz.length;j++) {
						//SECUENCIA DE CAMBIO
				matriznueva[i][j]=matriz[j][matriz.length-1-i];
				
				/*
				 * NO HAY NINGUNA FORMA DE HALLAR LA SECUENCIA CORRECTA A LA PRIMERA. SE TRATA DE PRUEBA Y ERROR
				 * HASTA LLEGAR AL RESULTADO. PARA ELLO, SE RECOMIENDA UTILIZA EL DEPURADOR PARA EVALUAR LOS CAMBIOS QUE 
				 * SE EST�N REALIZANDO EN COMPARACI�N CON LOS QUE SE DEBER�AN DE HACER.
				 * 
				 * LA ESTRATEGIA:
				 * 	Usar el depurador e ir prediciendo los valores que debe tener la matriz antes de ver lo que haga el programa.
				 */
				
			}
		}
				//RETURN
		return matriznueva;	
	}
	
	
	/**
	 * Subrutina mueveColumna():
	 * 	Cambia la columna pasada como @param por la �ltima de la matriz pasada como @param
	 * 
	 * @param columna - Columna a cambiar por la �ltima.
	 * @param matriz - Matriz sobre la que operar.
	 * @return Matriz cambiada.
	 */
	public static int [] [] mueveColumna (int columna, int [] [] matriz) {

		/*
		 * LA ESTRATEGIA:
		 * 	Utilizaremos una matriznueva para devolver el resultado, por lo que NUNCA MODIFICAREMOS LA MATRIZ ORIGINAL.
		 * 	Utilizaremos un vector auxiliar para almacenar los valores de una de las columnas.
		 * 
		 * 	Al igual que en la subrutina swapReverseByDiagonals(), si no hici�semos uso de un vector auxiliar, perder�amos una de las columnas y no podr�amos
		 * 	terminar. Guardamos los valores en el vector, cambiamos una columna por otra y cambiamos la columa que queda por los valores del vector.
		 */
		
		//INICIALIZAMOS MATRIZ AUX DE TAMA�O IGUAL A LA ORIGINAL
		int [] [] matriznueva = new int [matriz[1].length][matriz.length];
		//INICIALIZAMOS VECTOR PARA ALMACENAR COLUMNA FINAL ORIGINAL
		int [] columnafinal = new int [matriz.length];

		for (int i=0;i<matriz[1].length;i++) {

			//RELLENAMOS MATRIZ AUX
			for (int j=0;j<matriz.length;j++) {
				matriznueva[i][j]=matriz[i][j];
			}
			
			// =================================================================================================================
			// ||NOTA: FIJARSE QUE LAS SIGUIENTES �RDENES NO EST�N DENTRO DEL BUCLE INTERIOR, EST�N S�LO EN EL BUCLE EXTERIOR.||
			// =================================================================================================================
			
			//PARA CADA FILA
			columnafinal [i] = matriz[i][matriz[1].length-1];		//GUARDAR VALOR DE �LTIMA COLUMNA
			//SUSTITUIR VALOR DE �LTIMA COLUMNA POR COLUMNA PASADA COMO PAR�METRO
			matriznueva [i][matriz[1].length-1] = matriz[i][columna];
			//SUSTITUIR VALOR DE �LTIMA COLUMNA POR VECTOR
			matriznueva [i][columna]=columnafinal[i];
		}

		//DEVOLVER MATRIZNUEVA
		return matriznueva;
	}


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
	
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in);			//CREA TECLADO

		System.out.print("Introduzca el tama�o de la matriz cuadrada: ");		//SOLICITA VALOR
		//INICIALIZA UNA MATRIZ Y DA VALORES USANDO LA SUBRUTINA MATRIX()
		int [][] matriz = Matrix(teclado.nextInt());
		imprimeMatriz(matriz);		//IMPRIME LA MATRIZ ORIGINAL

		//SOLICITA DATO
		System.out.println("Introduzca n�mero de columna a cambiar (Primera columna 1): ");
		//IMPRIMIR� LA MATRIZ	//DE COLUMNA PASADA POR TECLADO
		imprimeMatriz(mueveColumna(teclado.nextInt()-1,matriz));	
		//DE COLUMNA CAMBIADA	//DE LA MATRIZ ORIGINAL

		System.out.println("Se intercambiar�n las diagonales.");
		imprimeMatriz(swapReverseByDiagonals(matriz));
		
		System.out.println("Se rotar� la matriz 90�.");
		imprimeMatriz(rotateMatrix(matriz));
	}				

}


