package es.uned.master.java;

/**
 * enum Horca : Cada elemento contiene el dibujo de la horca según el numero de errores. 
 * PASO0 es el inicio y PASO6 el final
 */
public enum Horca {
		PASO0(" +--+\n | |\n   |\n   |\n   |\n   |\n======"), 
		PASO1(" +--+\n | |\n O |\n   |\n   |\n   |\n======"), 
		PASO2(" +--+\n | |\n O |\n | |\n   |\n   |\n======"), 
		PASO3(" +--+\n | |\n O |\n/| |\n   |\n   |\n======"), 
		PASO4(" +--+\n | |\n O |\n/|\\|\n   |\n   |\n======"),
		PASO5(" +--+\n | |\n O |\n/|\\|\n/  |\n   |\n======"),
		PASO6(" +--+\n | |\n O |\n/|\\|\n/ \\|\n   |\n======");

		private String valor;

		private Horca(String valor) {
			this.valor = valor;
		}

		public String getValor() {
			return valor;
		}
		
		/**
		 * Retorna el enumerado correspondiente a num
		 * @param num
		 * @return
		 */
		public static String getValorHorca(int num) {	
			
			if (num<0) //inicio de la horca
				num=0;
			
			if (num>6) //final de la horca
				num=6;
			
			Horca[] pantalla_array = values(); 
			return pantalla_array[num].getValor();
		}

	}


