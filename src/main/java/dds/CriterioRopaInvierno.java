package dds;

public class CriterioRopaInvierno implements Criterio {

    @Override
    public boolean clasificarPrenda(Prenda unaPrenda) {
        return unaPrenda.getTempMaxPrenda() < 15.0;
    }
}
