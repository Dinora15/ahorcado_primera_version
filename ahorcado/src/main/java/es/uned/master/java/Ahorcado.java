package es.uned.master.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 * Clase que nos permite jugar a un sencillo juego del ahorcado a partir de lista predefinida
 * de palabras.
 * 
 */
public class Ahorcado {
		
	private List <Character> letras;  //Lista de letras indicadas
	Palabra palabraJuego; 
	
	/**
	 * Constructor que inicializa las propiedades de la clase.
	 * La palabra incognita se obtiene dentro de palabraJuego
	 * 
	 */
	public Ahorcado() {
		
		palabraJuego=new Palabra();
		letras= new ArrayList<Character>();
				
	}	
		
	
	
	/**
	 * imprimirLetrasLeidas: Método que escribe en consola la lista de letras leidas	 *
	 * @param 
	 * 		null
	 * @return 
	 * 		void
	 * 
	 */	
	private void imprimirLetrasLeidas() {
		String cadena="Letras introducidas: ";
		int index=0;
		
		for (index=0; index<letras.size() ; index++) {			
			cadena= cadena + " " + letras.get(index);
		}
		
		System.out.println(cadena);	
	}
	
	/**
	 * leerLetra: Método que lee de consola hasta recibir un caracter alfabético
	 * y lo incluye en la lista de letras leidas
	 * @param 
	 * 		Scanner Sc: consola de la que leer el caracter
	 * @return 
	 * 		char. Retorna el caracter leido y lo incluye en la lista de letras leidas
	 * 
	 */
	private char leerLetra(Scanner Sc) {
		String lectura="";
		boolean letra_valida=false;
		
		while (!letra_valida) {
			System.out.println("Teclee una nueva letra: ");	
			try {
				lectura= Sc.next().toUpperCase(); //OJO... necesitamos una letra
				letra_valida=Character.isLetter(lectura.toUpperCase().charAt(0));
				
			}catch(NoSuchElementException e){
				letra_valida=false;	            
	        }catch(IllegalStateException e){
	        	letra_valida=false;	            
	        }
			
			
		}
		
		
		letras.add(lectura.toUpperCase().charAt(0));
		return lectura.toUpperCase().charAt(0);
		
	}
	
	
	
	/**
	 * jugar: Método que dirige el juego. Lee letras, verifica y pinta la horca
	*
	 */
	public void jugar() {
		//boolean letraEncontrada=true;
		//boolean primeraVez=true;
		char letraLeida=' ';
		
		Scanner Sc= new Scanner(System.in);
		letras.clear();
	
		System.out.println();
		System.out.println("Comenzamos!");	
		System.out.println();
		
		 
		//La pantalla inicial será la de error 0
		String horca=Horca.getValorHorca(palabraJuego.getLetrasERROR());		
		System.out.println(horca);
		System.out.println();
		
		//Pintamos la palabra
		palabraJuego.EscribirPalabra(letras);				
		
		//mientras no hayamos encontrado la palabra y menos de 6 errores
		while (palabraJuego.ContinuarJuego(letras)) {	
			
			//Leemos letra
			letraLeida=leerLetra(Sc);
			
			//comprobar letra
			palabraJuego.ComprobarLetra(letraLeida);
			
						
			//Pintamos dibujo	
			horca=Horca.getValorHorca(palabraJuego.getLetrasERROR());
			System.out.println(horca);
			System.out.println();
			
			//Escribimos palabra con letra ya localizadas
			palabraJuego.EscribirPalabra(letras);		
			//imprimimos letras empleada
			imprimirLetrasLeidas();			

		}
		
		if (palabraJuego.PalabraEncontrada(letras)) {
			System.out.println("¡Enhorabuena! ¡Has acertado la palabra!");	
		} else {
			System.out.println("Lo siento. No has acertado la palabra");	
			System.out.println("La palabra correcta es: " + palabraJuego.getMisterio());	
		}
	
		Sc.close();
	}
	

}
