import org.jetbrains.annotations.Contract;

import static java.util.Objects.requireNonNull;

public class Prenda {

    private tipoPrenda tipoPrenda;
    private tipoMaterial material;
    private Color colorPrincipal;
    private Color colorSecundario;
    private tramaTela trama = tramaTela.LISA;

    public Prenda (tipoPrenda tipoPrenda, tipoMaterial material, Color colorPrincipal, tramaTela trama) {

        controlAtributosObligatorios(tipoPrenda, material, colorPrincipal);

        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.trama = trama;

    }


    public Prenda (tipoPrenda tipoPrenda, tipoMaterial material, Color colorPrincipal, Color colorSecundario, tramaTela trama) {

        controlAtributosObligatorios(tipoPrenda, material, colorPrincipal);

        this.colorSecundario = colorSecundario;
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.trama = trama;

    }

    @Contract("null, _, _ -> fail")
    private void controlAtributosObligatorios(tipoPrenda tipoPrenda, tipoMaterial material, Color colorPrincipal) {

        if (tipoPrenda == null) throw new tipoPrendaNuloException("El tipoPrenda debe ser especificado");
            this.tipoPrenda = tipoPrenda;
        if (material == null) throw new materialNuloException( "El material debe ser especificado");
            this.material = material;
        if (colorPrincipal == null) throw new colorPrincipalNuloException("El color debe ser especificado");
            this.colorPrincipal = colorPrincipal;
    }


    public tipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

}

class tipoPrendaNuloException extends RuntimeException {
    public tipoPrendaNuloException(String mensaje) {
        super(mensaje);
    }
}

class materialNuloException extends RuntimeException {
    public materialNuloException(String mensaje) {
        super(mensaje);
    }
}

class colorPrincipalNuloException extends RuntimeException {
    public colorPrincipalNuloException(String mensaje) {
        super(mensaje);
    }
}


class tipoPrendaCategoriaNoCondicen extends RuntimeException {
    public tipoPrendaCategoriaNoCondicen(String mensaje) {
        super(mensaje);
    }
}


class Color {
    int rojo;
    int verde;
    int azul;

    Color (int rojo, int verde, int azul) {
        this.rojo = rojo;
        this.verde = verde;
        this.azul = azul;
    }
}

enum tipoPrenda {
    PANTALON(categoriaPrenda.PARTE_INFERIOR), CAMISA(categoriaPrenda.PARTE_SUPERIOR), ZAPATO(categoriaPrenda.CALZADO),
    REMERA(categoriaPrenda.PARTE_SUPERIOR), CINTURON(categoriaPrenda.ACCESORIO);

    private categoriaPrenda categoria;

    private tipoPrenda(categoriaPrenda categoria) {
        this.categoria = categoria;
    }

    public categoriaPrenda getCategoria() {
        return categoria;
    }
}

;
;
