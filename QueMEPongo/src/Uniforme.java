public class Uniforme extends Atuendo {

    private Sastre sastreDelUniforme;

    @Override
    public void agregarPrenda(Prenda unaPrenda) {
        conjuntoPrendas.add(sastreDelUniforme.crearCalzado());
        conjuntoPrendas.add(sastreDelUniforme.crearParteSuperior());
        conjuntoPrendas.add(sastreDelUniforme.crearParteInferior());
    }
}

interface Sastre {
    public Prenda crearParteSuperior();
    public Prenda crearParteInferior();
    public Prenda crearCalzado();
}

class SastreSanJuan implements Sastre {

  //  Borrador creadorPrendas = new Borrador();  //Deberìa crear un nuevo buider Borrador por prenda?


    private Prenda completarDetallesPrenda(tipoPrenda tipo, Color color, TipoMaterial material) {

        Borrador creadorPrendas = new Borrador();

        creadorPrendas.setTipoPrenda(tipo);
        creadorPrendas.setColorPrincipal(color);
        creadorPrendas.setMaterial(material);

        return creadorPrendas.terminarPrenda();
    }


    public Prenda crearParteSuperior() {
        return completarDetallesPrenda(tipoPrenda.CHOMBA, new Color(0, 255, 0), TipoMaterial.PIQUE);
    }

    public Prenda crearParteInferior() {
        return completarDetallesPrenda(tipoPrenda.PANTALON, new Color(60, 60, 60), TipoMaterial.ACETATO);
    }

    public Prenda crearCalzado() {
        return completarDetallesPrenda(tipoPrenda.ZAPATILLAS, new Color(255, 255, 255), TipoMaterial.CUERO);
    }
}


class SastreInstitutoJohnson implements Sastre {

    private Prenda completarDetallesPrenda(tipoPrenda tipo, Color color, TipoMaterial material) {

        Borrador creadorPrendas = new Borrador();

        creadorPrendas.setTipoPrenda(tipo);
        creadorPrendas.setColorPrincipal(color);
        creadorPrendas.setMaterial(material);

        return creadorPrendas.terminarPrenda();
    }

    public Prenda crearCalzado() {
        return completarDetallesPrenda(tipoPrenda.ZAPATOS, new Color(0, 0, 0), TipoMaterial.CUERO);
    }

    public Prenda crearParteSuperior() {
        return completarDetallesPrenda(tipoPrenda.CAMISA, new Color(255, 255, 255), TipoMaterial.ALGODON);
    }

    public Prenda crearParteInferior() {
        return completarDetallesPrenda(tipoPrenda.PANTALON_VESTIR, new Color(0, 0, 0), TipoMaterial.ALGODON);
    }

}
