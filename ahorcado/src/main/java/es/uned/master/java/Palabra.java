package es.uned.master.java;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * Clase que contiene la palabra incognita y métodos para verificar si se ha encontrado en función de una lista de letras introducidas
 * 
 * @author Raul
 *
 */
public class Palabra {
	private final int NUM_MAX_ERROR=6; //Numero máximo de errores permitidos
	private String misterio; //palabra incognita
	private int letrasERROR; //letras erroneas indicadas
	private int letrasOK;	//letras correctas
	
	public Palabra () {
		
		//Posibles palabras
		List <String> palabras= Arrays.asList("raton", "pato", "tigre", "oso", "mirlo", "oca", "ardilla", "conejo", "leopardo", "perro", "gato", "toro", "vaca");
		
		//Obtenemos una palabra aleatoria
		Random r = new Random();
		int n = r.nextInt(palabras.size());		
		misterio=palabras.get(n).toUpperCase();
		
		
		letrasERROR=0;
		letrasOK=0;	
		
	}

	/**
	 * ComprobarLetra :Aumenta el numero de letras de error si la letra introducida no pertence a la palabra incognito
	 */
	public void ComprobarLetra(char letra_in) {
		boolean letraEncontrada=false;
		
		letraEncontrada=localizarLetra(letra_in);			
		if(!letraEncontrada) {
			letrasERROR++;			
		}			
		
	}
	
	
	/***************************************
	 * numLetrasEncontradas : Obtiene el numero de letrás ya encontradas en la palabra incognita.
	 * @return 
	 * 		int. Número de letras encontradas. Si una letra aparece n veces se contabiliza n veces.
	  */
	private int NumLetrasEncontradas(List<Character> letras) {
		int contador=0;
		int index=0;
		
		for (index=0; index<this.misterio.length();  index++) {
			if (letras.contains(this.misterio.charAt(index))) {
				contador++;		
			}
		}		
		return contador;		
	}
	
	/***************************************
	 * palabraEncontrada : Indica si ya hemos localizado todas las letras necesarias	
	 * @return 
	 * 		boolean.Retorna true cuando el numero de letras encontradas coincide con el número de letras de la palabra
	  */
	public boolean PalabraEncontrada(List<Character> letras) {
		this.letrasOK=NumLetrasEncontradas(letras);		
		return (this.misterio.length()==letrasOK);
	}
	
	
	/**
	 * PermitirIntentos
	 * 
	 * @return Retorna true si no se han superado el numero máximo de errores
	 */
	private boolean PermitirIntentos() {	
	boolean retorno=false;
	
		if (this.letrasERROR<NUM_MAX_ERROR)
			retorno=true;
		else
			retorno=false;
		
		return retorno;
	}
	
	
	/***************************************
	 * ContinuarJuego : Indica si ya podemos continuar el juego por no haber cometido NUM_MAX_ERROR errores y no haber encontrado la palabra
	 * 
	 * @return 
	 * 		boolean.Retorna true si podemos continuar probando letras
	  */
	public boolean ContinuarJuego(List<Character> letras) {	
		boolean retorno=false;
		
		if (PermitirIntentos() && !PalabraEncontrada(letras))
			retorno=true;
		else
			retorno=false;
				
		return retorno;	
		
	}
	
	/**
	 * localizarLetra : Método empleado para saber si una letra está incluida en la palabra incognita.
	 * @param 
	 * 		char letraLeida : caracter a comprobar si está incluido en la palabra
	 * @return 
	 * 		boolean. true (el caracter está incluido) / false (el caracter no está incluido)
	  */	
	private boolean localizarLetra(char letraLeida) {
		boolean retorno=false;		
		String cadena="";
		cadena=cadena+letraLeida;
		
		if (this.misterio.contains(cadena)) {
				retorno=true;		
			}
		
		
		return retorno;
		
	}

	/***************************************
	 * escribirPalabra : Escribe por consola la palabra según las letras encontradas
	* @return 
	 * 		boolean.Retorna true cuando el numero de letras encontradas coincide con el número de letras de la palabra
	  */
	public void EscribirPalabra(List<Character> letras) {
		
		String cadena="Palabra: ";
		int index=0;
			
		if (letras.isEmpty()) { //Si todavia no se ha tecleado letras escribimos letras ocultas
			for (index=0; index<this.misterio.length();  index++) {
				cadena=cadena+"_ ";
			}
			
		}else {			
			//escribimos la palabra sustityendo las letras no encontradas por '_'
			for (index=0; index<this.misterio.length();  index++) {
				if (letras.contains(this.misterio.charAt(index))) {
					cadena=cadena+this.misterio.charAt(index)+ " ";						
				}else {
					cadena=cadena+"_ ";
				}
			}
			
		}
		
		System.out.println(cadena);		
		
	}
	
	
	/**
	 * @return the misterio
	 */
	public String getMisterio() {
		return misterio;
	}

	/**
	 * @param misterio the misterio to set
	 */
	public void setMisterio(String misterio) {
		this.misterio = misterio;
	}

	/**
	 * @return the letrasERROR
	 */
	public int getLetrasERROR() {
		return letrasERROR;
	}

	/**
	 * @param letrasERROR the letrasERROR to set
	 */
	public void setLetrasERROR(int letrasERROR) {
		this.letrasERROR = letrasERROR;
	}

	/**
	 * @return the letrasOK
	 */
	public int getLetrasOK() {
		return letrasOK;
	}

	/**
	 * @param letrasOK the letrasOK to set
	 */
	public void setLetrasOK(int letrasOK) {
		this.letrasOK = letrasOK;
	}


	


}
