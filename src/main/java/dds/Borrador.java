package dds;

public class Borrador {

    private TipoPrenda tipoPrenda;
    private TipoMaterial material;
    private Color colorPrincipal;
    private Color colorSecundario;
    private TramaTela trama;

    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(TipoPrenda tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public TipoMaterial getMaterial() {
        return material;
    }

    public void setMaterial(TipoMaterial material) {
        this.material = material;
    }

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(Color colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(Color colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public TramaTela getTrama() {
        return trama;
    }

    public void setTrama(TramaTela trama) {
        this.trama = trama;
    }


    public Prenda terminarPrenda() {
        if(colorSecundario == null)
            return new Prenda(tipoPrenda, material, colorPrincipal, trama);
        else return new Prenda(tipoPrenda, material, colorPrincipal, colorSecundario, trama);
    }

}
