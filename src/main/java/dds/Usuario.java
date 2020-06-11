package dds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Usuario {

    List<Guardarropa> guardarropas = new ArrayList<>();
    List<Recomendacion> misRecomendacionesPendientes = new ArrayList<>();
    Stack<Recomendacion> recomendacionesAceptadas = new Stack<>();

    public void aceptarRecomendacion(Recomendacion recomendacion){
        misRecomendacionesPendientes.remove(recomendacion);
        recomendacion.aplicarEnGuardarropas();
        recomendacionesAceptadas.add(recomendacion);
    }

    public void rechazarRecomendacion(Recomendacion recomendacion) {
        misRecomendacionesPendientes.remove(recomendacion);
    }

    public void enviarRecomendacion(Usuario otroUsuario, Recomendacion unaRecomendacion) {
        otroUsuario.agregarRecomendacionNueva(unaRecomendacion);
    }

    public void agregarRecomendacionNueva(Recomendacion nuevaRecomendacion) {
        misRecomendacionesPendientes.add(nuevaRecomendacion);
    }

    public void deshacerUltimaRecomendacionAceptada() {
        recomendacionesAceptadas.pop().deshacer();
    }

    public void verRecomendacionesPendientes() {
     System.out.println(Arrays.toString(misRecomendacionesPendientes.toArray()));
    }
}


