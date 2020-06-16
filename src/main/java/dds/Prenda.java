package dds;

import dds.Exceptions.ColorPrincipalNuloException;
import dds.Exceptions.MaterialNuloException;
import dds.Exceptions.ColorPrincipalNuloException;
import dds.Exceptions.MaterialNuloException;
import dds.Exceptions.TipoPrendaNuloExceptionException;

import static java.util.Objects.requireNonNull;

public class Prenda {

    private TipoPrenda tipoPrenda;
    private TipoMaterial material;
    private Color colorPrincipal;
    private Color colorSecundario;
    private TramaTela trama = TramaTela.LISA;

    public Prenda (TipoPrenda tipoPrenda, TipoMaterial material, Color colorPrincipal, TramaTela trama) {

        controlAtributosObligatorios(tipoPrenda, material, colorPrincipal);

        this.colorSecundario = colorSecundario;
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.trama = trama;

    }

    public Prenda (TipoPrenda tipoPrenda, TipoMaterial material, Color colorPrincipal, Color colorSecundario, TramaTela trama) {

        controlAtributosObligatorios(tipoPrenda, material, colorPrincipal);

        this.colorSecundario = colorSecundario;
        this.tipoPrenda = tipoPrenda;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.trama = trama;

    }


    private void controlAtributosObligatorios(TipoPrenda tipoPrenda, TipoMaterial material, Color colorPrincipal) {

        if (tipoPrenda == null) throw new TipoPrendaNuloExceptionException("El main.TipoPrenda debe ser especificado");
            this.tipoPrenda = tipoPrenda;
        if (material == null) throw new MaterialNuloException( "El material debe ser especificado");
            this.material = material;
        if (colorPrincipal == null) throw new ColorPrincipalNuloException("El color debe ser especificado");
            this.colorPrincipal = colorPrincipal;
    }


    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public CategoriaPrenda getCategoriaPrenda() {
        return tipoPrenda.getCategoria();
    }

    public double getTempMaxPrenda() {
        return tipoPrenda.getTempMaximaRecomendada();
    }
}
