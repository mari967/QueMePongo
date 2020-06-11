package dds;

import dds.Exceptions.PrendaNoCumpleCriterioGuardarropaException;

import java.util.ArrayList;
import java.util.List;

/*
*QMP5
* Como usuarie de QuéMePongo, quiero poder manejar varios guardarropas para separar mis prendas según diversos criterios
*(ropa de viaje, ropa de entrecasa, etc).
* */
public class Guardarropa implements Cloneable{

    private List<Prenda> prendas = new ArrayList<>();
    private Criterio criterioPrendas;

    public Guardarropa(Criterio unCriterio) {
        this.criterioPrendas = unCriterio;
    }

    public void agregarPrendaGuardarropa(Prenda unaPrenda) {
        if(criterioPrendas.clasificarPrenda(unaPrenda))
            prendas.add(unaPrenda);
        else throw new PrendaNoCumpleCriterioGuardarropaException("La prenda no puede ser guardada en el guardarropa " +
                "porque no cumple el criterio para pertenecer");
    }

    public void quitarPrendaGuardarropa(Prenda prenda) {
        prendas.remove(prenda);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
