package ahorcado;

import java.util.Scanner;

import es.uned.master.java.Ahorcado;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido al juego del ahorcado!!");
		System.out.println("¿Desea jugar ahora? (S/N)");
		   
		//System.out.println(" +--+\n | |\n O |\n/|\\|\n/ \\|\n   |\n======");
		  
		Scanner Sc= new Scanner(System.in);

		String continuar ="X";
		
		//Consultamos si desea jugar hasta que indique S o N		
		do {			
		
			continuar= Sc.next().toUpperCase();
	
	        if (continuar.equals("S")) {
	        	//Iniciar juego
	        	Ahorcado juego=new Ahorcado();
	        	juego.jugar();
	        } 
	        else if (!continuar.equals("N") ){
	        	System.out.println("Indique una opción válida\n¿Desea jugar ahora? (S/N)");	        	
	        }
	        
		} while (!continuar.equals("N") && !continuar.equals("S") );

       Sc.close();

	}

}
