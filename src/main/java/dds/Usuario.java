package dds;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    List<Guardarropa> guardarropas = new ArrayList<>();
    List<PropuestaPrenda> misPropuestasPendientes = new ArrayList<>();
    List<PropuestaPrenda> propuestasAceptadas = new ArrayList<>();

    public void agregarGuardarropas(Guardarropa nuevoGuardarropa) {
        guardarropas.add(nuevoGuardarropa);
    }

    public void enviarPropuesta(PropuestaPrenda unaPropuestaPrenda, Usuario unUsuario) {
        unUsuario.recibirPropuesta(unaPropuestaPrenda);
    }

    public void recibirPropuesta(PropuestaPrenda unaPropuesta) {
        misPropuestasPendientes.add(unaPropuesta);
    }

    public void removerPropuesta(int indice) {
        misPropuestasPendientes.remove(indice);
    }

    public void aceptarPropuesta(int indice) {
        PropuestaPrenda laPropuesta = misPropuestasPendientes.get(indice);
        misPropuestasPendientes.remove(laPropuesta);
        propuestasAceptadas.add(laPropuesta);
    }

}


