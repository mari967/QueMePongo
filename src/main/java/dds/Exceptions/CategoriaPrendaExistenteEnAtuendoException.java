package main.Exceptions;

public class CategoriaPrendaExistenteEnAtuendoException extends RuntimeException {
    public CategoriaPrendaExistenteEnAtuendoException(String mensaje) {
        super(mensaje);
    }
}
