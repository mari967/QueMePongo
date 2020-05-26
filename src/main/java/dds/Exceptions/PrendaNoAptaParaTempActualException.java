package main.Exceptions;

public class PrendaNoAptaParaTempActualException extends  RuntimeException {
    public PrendaNoAptaParaTempActualException(String mensaje) {
        super(mensaje);
    }
}
