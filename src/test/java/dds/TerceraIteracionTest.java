package dds;


import main.Exceptions.CategoriaPrendaExistenteEnAtuendoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TerceraIteracionTest {

    private static final String CIUDAD_BS_AS = "Ciudad de Buens Aires, Argentina";
    private AccuWeatherAPI accu;

    private Atuendo unAtuendo;
    private ProveedorDelClima proveedorAccu;
    private Prenda zapatillasRojas;
    private Prenda remeraAzul;
    private Prenda otraRemera;
    private Prenda chupin;
    private Prenda camperaGruesa;


    @Before
    public void init() {
        proveedorAccu = new AccuProveedorDelClima();
        unAtuendo = new Atuendo(CIUDAD_BS_AS);

        accu = new AccuWeatherAPI();

        zapatillasRojas = new Prenda(TipoPrenda.ZAPATILLAS, TipoMaterial.ALGODON ,new Color(252,0,0),
                TramaTela.LISA);
        remeraAzul = new Prenda(TipoPrenda.REMERA, TipoMaterial.ALGODON, new Color(0,0,252),
                new Color(252,252,252), TramaTela.RAYADA);
        otraRemera = new Prenda(TipoPrenda.REMERA, TipoMaterial.ALGODON, new Color(252,0,252), TramaTela.LISA);
        chupin = new Prenda(TipoPrenda.PANTALON, TipoMaterial.JEAN, new Color(0,0, 252), TramaTela.LISA);
        camperaGruesa = new Prenda(TipoPrenda.ABRIGO_INVERNAL, TipoMaterial.POLIESTER, new Color(0,0,0),
                TramaTela.LISA);
    }

    @Test
    public void esPosibleObtenerTempDeBuenosAires() {
       Assert.assertNotNull(proveedorAccu.getTemperaturaCelcius(CIUDAD_BS_AS));
    }

    @Test
    public void puedoAgregarPrendasAlAtuendo() {
        unAtuendo.agregarPrenda(remeraAzul);
        unAtuendo.agregarPrenda(chupin);
    }

    @Test (expected = CategoriaPrendaExistenteEnAtuendoException.class)
    public void noPuedenHaberPrendasConCategoriaRepetida() {
     unAtuendo.agregarPrenda(remeraAzul);
     unAtuendo.agregarPrenda(otraRemera);
    }

    @Test
    public void unaCamperaNoEsAptaConTempAlta() { //Acá mockeamos el proveedor del clima
        ProveedorDelClima mockitoProveedor = mock(ProveedorDelClima.class);
        when(mockitoProveedor.getTemperaturaCelcius(CIUDAD_BS_AS)).thenReturn(24.1);

        unAtuendo.setProveedorClima(mockitoProveedor);
        unAtuendo.agregarPrenda(camperaGruesa);

    }
}
