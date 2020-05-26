package dds;

public class Uniforme extends Atuendo {

    private Sastre sastreDelUniforme;

    public Uniforme (Sastre sastreDelUniforme, String ciudad) {
        super(ciudad);
        this.sastreDelUniforme = sastreDelUniforme;
    }

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

  //  main.Borrador creadorPrendas = new main.Borrador();  //Deberìa crear un nuevo buider main.Borrador por prenda?


    private Prenda completarDetallesPrenda(TipoPrenda tipo, Color color, TipoMaterial material) {

        Borrador creadorPrendas = new Borrador();

        creadorPrendas.setTipoPrenda(tipo);
        creadorPrendas.setColorPrincipal(color);
        creadorPrendas.setMaterial(material);

        return creadorPrendas.terminarPrenda();
    }


    public Prenda crearParteSuperior() {
        return completarDetallesPrenda(TipoPrenda.CHOMBA, new Color(0, 255, 0), TipoMaterial.PIQUE);
    }

    public Prenda crearParteInferior() {
        return completarDetallesPrenda(TipoPrenda.PANTALON, new Color(60, 60, 60), TipoMaterial.ACETATO);
    }

    public Prenda crearCalzado() {
        return completarDetallesPrenda(TipoPrenda.ZAPATILLAS, new Color(255, 255, 255), TipoMaterial.CUERO);
    }
}


class SastreInstitutoJohnson implements Sastre {

    private Prenda completarDetallesPrenda(TipoPrenda tipo, Color color, TipoMaterial material) {

        Borrador creadorPrendas = new Borrador();

        creadorPrendas.setTipoPrenda(tipo);
        creadorPrendas.setColorPrincipal(color);
        creadorPrendas.setMaterial(material);

        return creadorPrendas.terminarPrenda();
    }

    public Prenda crearCalzado() {
        return completarDetallesPrenda(TipoPrenda.ZAPATOS, new Color(0, 0, 0), TipoMaterial.CUERO);
    }

    public Prenda crearParteSuperior() {
        return completarDetallesPrenda(TipoPrenda.CAMISA, new Color(255, 255, 255), TipoMaterial.ALGODON);
    }

    public Prenda crearParteInferior() {
        return completarDetallesPrenda(TipoPrenda.PANTALON_VESTIR, new Color(0, 0, 0), TipoMaterial.ALGODON);
    }

}
