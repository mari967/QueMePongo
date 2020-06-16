package dds;

import dds.Exceptions.GuardarropasNoExisteExeption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Usuario {

    private List<Guardarropa> guardarropas = new ArrayList<>();
    private List<Recomendacion> misRecomendacionesPendientes = new ArrayList<>();
    private Stack<Recomendacion> recomendacionesAceptadas = new Stack<>();

    public void agregarGuardarropas(Guardarropa nuevoGuardarropa) {
        guardarropas.add(nuevoGuardarropa);
    }

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

    public List<Recomendacion> getMisRecomendacionesPendientes() {
        return misRecomendacionesPendientes;
    }

    public void agregarPendaAGuardarropa(Guardarropa unGuardarropa, Prenda unaPrenda) {
        if (guardarropas.contains(unGuardarropa)) {
            guardarropas.get(guardarropas.indexOf(unGuardarropa)).agregarPrendaGuardarropa(unaPrenda);
        }
        else throw new GuardarropasNoExisteExeption("El guardarropa elegido no existe en la colección de " +
                "guardarropas de este usuario");
    }

}


