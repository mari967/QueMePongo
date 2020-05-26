package main;

public enum tipoPrenda {

    PANTALON(CategoriaPrenda.PARTE_INFERIOR, 20.0), CAMISA(CategoriaPrenda.PARTE_SUPERIOR, 24.0),
    ZAPATOS(CategoriaPrenda.CALZADO,24.0),
    REMERA(CategoriaPrenda.PARTE_SUPERIOR, 40.0), CINTURON(CategoriaPrenda.ACCESORIO, 40.0),
    CHOMBA(CategoriaPrenda.PARTE_SUPERIOR, 30.0),
    ZAPATILLAS(CategoriaPrenda.CALZADO, 30.0), PANTALON_VESTIR(CategoriaPrenda.PARTE_INFERIOR, 27.0),
    ABRIGO_INVERNAL(CategoriaPrenda.PARTE_SUPERIOR, 15.0);

    private CategoriaPrenda categoria;
    private double tempMaximaRecomendada;

    private tipoPrenda(CategoriaPrenda categoria, double tempMax) {
        this.categoria = categoria;
        this.tempMaximaRecomendada = tempMax;
    }

    public CategoriaPrenda getCategoria() {
        return categoria;
    }

    public double getTempMaximaRecomendada() {
        return tempMaximaRecomendada;
    }
}
