package dds;

import java.util.ArrayList;
import java.util.List;

public class ClasificadorRopaEntrecasa implements  Clasificador{

    List<TipoPrenda> tiposPrendasParaCasa = new ArrayList<>();
    //public Prenda (TipoPrenda tipoPrenda, TipoMaterial material, Color colorPrincipal, TramaTela trama)

    public ClasificadorRopaEntrecasa() {
        tiposPrendasParaCasa.add(TipoPrenda.OJOTAS);
        tiposPrendasParaCasa.add(TipoPrenda.PANTUFLAS);
        tiposPrendasParaCasa.add(TipoPrenda.REMERA);
        tiposPrendasParaCasa.add(TipoPrenda.PANTALON);
        tiposPrendasParaCasa.add(TipoPrenda.SUETER);
        tiposPrendasParaCasa.add(TipoPrenda.OJOTAS);
    }

    @Override
    public boolean clasificarPrenda(Prenda unaPrenda) {
        return tiposPrendasParaCasa.contains(unaPrenda.getTipoPrenda());
    }

    public void agregarTiposPrendasParaCasa(TipoPrenda unTipo) {
        tiposPrendasParaCasa.add(unTipo);
    }

}
