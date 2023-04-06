package es.uned.master.java;

public class AhorcadoException extends RuntimeException {
    public AhorcadoException(String mensaje) {
        super("Ahorcado Exception:" + mensaje);
    }
    public AhorcadoException() {
    	super("Ahorcado Exception...");
    }
}
