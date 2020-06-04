package dds;

import dds.Exceptions.PrendaNoCumpleCriterioGuardarropaException;

import java.util.ArrayList;
import java.util.List;

public class Guardarropa {

    List<Prenda> prendas = new ArrayList<>();
    Clasificador clasificadorPrendas;

    public Guardarropa(Clasificador unClasificador) {
        this.clasificadorPrendas = unClasificador;
    }

    public void agregarPrendaGuardarropa(Prenda unaPrenda) {
        if(clasificadorPrendas.clasificarPrenda(unaPrenda))
            prendas.add(unaPrenda);
        else throw new PrendaNoCumpleCriterioGuardarropaException("La prenda no puede ser guardada en el guardarropa " +
                "porque no cumple el criterio para pertenecer");
    }

}
