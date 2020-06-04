package dds;

public class ClasificadorRopaInvierno implements Clasificador {

    @Override
    public boolean clasificarPrenda(Prenda unaPrenda) {
        return unaPrenda.getTempMaxPrenda() < 15.0;
    }
}
