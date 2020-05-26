package main;

import main.Exceptions.CategoriaPrendaExistenteEnAtuendoException;
import main.Exceptions.PrendaNoAptaParaTempActualException;

import java.util.ArrayList;
import java.util.List;

public class Atuendo {
////atuendos que tengan una prenda para cada categoría
    List<Prenda> conjuntoPrendas = new ArrayList<>();
    ProveedorDelClima proveedorClima = new AccuProveedorDelClima();
    String ciudadActual;
    double tempActual;

    public Atuendo (String ciudad) {
        this.ciudadActual = ciudad;
        this.tempActual = proveedorClima.getTemperaturaCelcius(ciudad);
    }

    public void agregarPrenda(Prenda unaPrenda) {

        if(conjuntoPrendas.stream().anyMatch(prenda -> prenda.getCategoriaPrenda() == unaPrenda.getCategoriaPrenda()))
            throw new CategoriaPrendaExistenteEnAtuendoException("Ya existe una prenda de esta categoria");

        if (unaPrenda.getTipoPrenda().getTempMaximaRecomendada() < tempActual)
            throw new PrendaNoAptaParaTempActualException("La prenda elegida no es apta para esta temperatura");

        conjuntoPrendas.add(unaPrenda);
    }

    public void setProveedorClima(ProveedorDelClima proveedorClima) {
        this.proveedorClima = proveedorClima;
    }
}


