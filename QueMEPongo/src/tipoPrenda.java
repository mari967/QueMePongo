public enum tipoPrenda {

    PANTALON(CategoriaPrenda.PARTE_INFERIOR), CAMISA(CategoriaPrenda.PARTE_SUPERIOR), ZAPATOS(CategoriaPrenda.CALZADO),
    REMERA(CategoriaPrenda.PARTE_SUPERIOR), CINTURON(CategoriaPrenda.ACCESORIO), CHOMBA(CategoriaPrenda.PARTE_SUPERIOR),
    ZAPATILLAS(CategoriaPrenda.CALZADO), PANTALON_VESTIR(CategoriaPrenda.PARTE_INFERIOR);

    private CategoriaPrenda categoria;

    private tipoPrenda(CategoriaPrenda categoria) {
        this.categoria = categoria;
    }

    public CategoriaPrenda getCategoria() {
        return categoria;
    }
}
