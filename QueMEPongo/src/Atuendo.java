import java.util.ArrayList;
import java.util.List;

public class Atuendo {

    List<Prenda> conjuntoPrendas = new ArrayList<>();

    public void agregarPrenda(Prenda unaPrenda) {

        if(conjuntoPrendas.stream().anyMatch(prenda -> prenda.getTipoPrenda() == unaPrenda.getTipoPrenda()))
            throw new tipoPrendaExistenteEnAtuendoException("Ya existe una prenda de este tipo");

        conjuntoPrendas.add(unaPrenda);  //controlar que el conjunto sea valido, sin prendas
        //repetidas, sin categorias repetidas
    }
}


class tipoPrendaExistenteEnAtuendoException extends RuntimeException {
    public tipoPrendaExistenteEnAtuendoException(String mensaje) {
        super(mensaje);
    }
}