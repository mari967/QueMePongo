package dds;

public class ClasificadorRopaVerano implements Clasificador {

    @Override
    public boolean clasificarPrenda(Prenda unaPrenda) {
        return unaPrenda.getTempMaxPrenda() < 45.0;
    }
}
