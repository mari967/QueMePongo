package main;

import main.Exceptions.ColorPrincipalNuloException;
import main.Exceptions.MaterialNuloException;
import main.Exceptions.TipoPrendaNuloException;

import static java.util.Objects.requireNonNull;

public class Prenda {

    private tipoPrenda tipoPrenda;
    private TipoMaterial material;
    private Color colorPrincipal;
    private Color colorSecundario;
    private TramaTela trama = TramaTela.LISA;

    public Prenda (tipoPrenda tipoPrenda, TipoMaterial material, Color colorPrincipal, TramaTela trama) {

        controlAtributosObligatorios(tipoPrenda, material, colorPrincipal);

        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.trama = trama;

    }


    public Prenda (tipoPrenda tipoPrenda, TipoMaterial material, Color colorPrincipal, Color colorSecundario, TramaTela trama) {

        controlAtributosObligatorios(tipoPrenda, material, colorPrincipal);

        this.colorSecundario = colorSecundario;
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.trama = trama;

    }


    private void controlAtributosObligatorios(main.tipoPrenda tipoPrenda, TipoMaterial material, Color colorPrincipal) {

        if (tipoPrenda == null) throw new TipoPrendaNuloException("El main.tipoPrenda debe ser especificado");
            this.tipoPrenda = tipoPrenda;
        if (material == null) throw new MaterialNuloException( "El material debe ser especificado");
            this.material = material;
        if (colorPrincipal == null) throw new ColorPrincipalNuloException("El color debe ser especificado");
            this.colorPrincipal = colorPrincipal;
    }


    public tipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public CategoriaPrenda getCategoriaPrenda() {
        return tipoPrenda.getCategoria();
    }

}
