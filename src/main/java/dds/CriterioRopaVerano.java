package dds;

public class CriterioRopaVerano implements Criterio {

    @Override
    public boolean clasificarPrenda(Prenda unaPrenda) {
        return unaPrenda.getTempMaxPrenda() > 20.0;
    }
}
