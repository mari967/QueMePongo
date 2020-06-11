package dds;

public class RecomendacionQuitar implements Recomendacion {

    private Guardarropa unGuardarropas;
    private Prenda unaPrenda;

    public RecomendacionQuitar (Guardarropa unGuardarropas, Prenda unaPrenda) {
        this.unGuardarropas = unGuardarropas;
        this.unaPrenda = unaPrenda;
    }

    @Override
    public void aplicarEnGuardarropas() {
        unGuardarropas.quitarPrendaGuardarropa(unaPrenda);
    }

    @Override
    public void deshacer() {
        unGuardarropas.agregarPrendaGuardarropa(unaPrenda);
    }
}
