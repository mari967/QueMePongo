public class Borrador {

    private tipoPrenda tipoPrenda;
    private tipoMaterial material;
    private Color colorPrincipal;
    private Color colorSecundario;
    private tramaTela trama;

    public tipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(tipoPrenda tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public tipoMaterial getMaterial() {
        return material;
    }

    public void setMaterial(tipoMaterial material) {
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

    public tramaTela getTrama() {
        return trama;
    }

    public void setTrama(tramaTela trama) {
        this.trama = trama;
    }


    public Prenda terminarPrenda() {
        if(colorSecundario == null)
            return new Prenda(tipoPrenda, material, colorPrincipal, trama);
        else return new Prenda(tipoPrenda, material, colorPrincipal, colorSecundario, trama);
    }

}
