package dds;


/*
* Patrón command.
* Una recomendación se crea para un guardarropa en particular
* */
public class RecomendacionAgregar implements  Recomendacion{

    Guardarropa unGuardarropa;
    Prenda unaPrenda;

    public RecomendacionAgregar (Guardarropa unGuardarropa, Prenda unaPrenda) {
        this.unGuardarropa = unGuardarropa;
        this.unaPrenda = unaPrenda;
    }

    @Override
    public void aplicarEnGuardarropas()  {
        unGuardarropa.agregarPrendaGuardarropa(unaPrenda);
    }

    @Override
    public void deshacer() {
    unGuardarropa.quitarPrendaGuardarropa(unaPrenda);
    }
}
