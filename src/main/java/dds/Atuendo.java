

package dds;
import main.Exceptions.CategoriaPrendaExistenteEnAtuendoException;
import main.Exceptions.PrendaNoAptaParaTempActualException;


import java.util.ArrayList;
import java.util.List;

public class Atuendo {

////atuendos que tengan una prenda para cada categoría
    List<Prenda> conjuntoPrendas = new ArrayList<>();
    ProveedorDelClima proveedorClima = new AccuProveedorDelClima();
    String ciudadActual;


    public Atuendo (String ciudad) {
        this.ciudadActual = ciudad;

    }

    public void agregarPrenda(Prenda unaPrenda) {

        if(conjuntoPrendas.stream().anyMatch(prenda -> prenda.getCategoriaPrenda() == unaPrenda.getCategoriaPrenda()))
            throw new CategoriaPrendaExistenteEnAtuendoException("Ya existe una prenda de esta categoria");

        if (unaPrenda.getTipoPrenda().getTempMaximaRecomendada() < proveedorClima.getTemperaturaCelcius(ciudadActual))
            throw new PrendaNoAptaParaTempActualException("La prenda elegida no es apta para esta temperatura");

        conjuntoPrendas.add(unaPrenda);
    }

    public void setProveedorClima(ProveedorDelClima proveedorClima) {
        this.proveedorClima = proveedorClima;
    }

    public void setCiudadActual(String ciudadActual) {
        this.ciudadActual = ciudadActual;
    }
}


