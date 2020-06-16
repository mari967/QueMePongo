package dds;

import dds.Exceptions.CategoriaPrendaExistenteEnAtuendoException;
import dds.Exceptions.PrendaNoCumpleCriterioGuardarropaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuintaIteracionTest {

    private Guardarropa ropaVerano;
    private Guardarropa ropaInvierno;
    private Guardarropa ropaEntrecasa;

    private Prenda remeraVerano;
    private Prenda pantuflas;
    private Prenda abrigoInvierno;

    private Usuario unUsuario;
    private Usuario otroUsuario;
    private Usuario usuarioConRecomendaciones;

    private Recomendacion recomendacionRemera;
    private Recomendacion recomendacionPantuflas;

@Before
    public void init() {
        ropaVerano = new Guardarropa(new CriterioRopaVerano());
        ropaInvierno = new Guardarropa(new CriterioRopaInvierno());
        ropaEntrecasa = new Guardarropa(new CriterioRopaEntrecasa());

        remeraVerano =  new Prenda(TipoPrenda.REMERA, TipoMaterial.ALGODON, new Color(0,0,252),
                new Color(252,252,252), TramaTela.RAYADA);
        abrigoInvierno = new Prenda(TipoPrenda.ABRIGO_INVERNAL, TipoMaterial.ALGODON, new Color(0,0,0), TramaTela.LISA);
        pantuflas = new Prenda(TipoPrenda.PANTUFLAS, TipoMaterial.POLIESTER, new Color(1,1,1), TramaTela.LISA);

        unUsuario = new Usuario();
        otroUsuario = new Usuario();
        usuarioConRecomendaciones = new Usuario();


        recomendacionPantuflas = new RecomendacionAgregar(ropaEntrecasa, pantuflas);
        recomendacionRemera = new RecomendacionAgregar(ropaEntrecasa, remeraVerano);

        usuarioConRecomendaciones.agregarGuardarropas(ropaEntrecasa);
        usuarioConRecomendaciones.agregarRecomendacionNueva(recomendacionPantuflas);
        usuarioConRecomendaciones.agregarRecomendacionNueva(recomendacionRemera);
}

    @Test (expected = PrendaNoCumpleCriterioGuardarropaException.class)
    public void noPuedoAgregarRopaDeInviernoAlGuardarropasDeVerano() {
        ropaVerano.agregarPrendaGuardarropa(abrigoInvierno);
}

    @Test (expected = PrendaNoCumpleCriterioGuardarropaException.class)
    public void noPuedoAgregarRopaDeVeranoAlGuardarropasDeInvierno() {
        ropaInvierno.agregarPrendaGuardarropa(remeraVerano);
}

//manejar varios guardarropas para separar mis prendas según diversos criterios
    @Test
    public void puedoAgregarVariosGuardarropasAUnUsuario() {
        unUsuario.agregarGuardarropas(ropaInvierno);
        unUsuario.agregarGuardarropas(ropaVerano);
        unUsuario.agregarGuardarropas(ropaEntrecasa);
    }

//quiero poder crear guardarropas compartidos con otros usuaries
    @Test
    public void unGuardarropasPuedeSerCompartido() {
        unUsuario.agregarGuardarropas(ropaEntrecasa);
        otroUsuario.agregarGuardarropas(ropaEntrecasa);
    }

//quiero que otro usuario me proponga tentativamente agregar una prenda al guardarropas
    @Test
    public void unUsuarioProponeAgregarUnaPrendaAOtroUsuario() {

        Assert.assertEquals(0, otroUsuario.getMisRecomendacionesPendientes().size(), 0);

        otroUsuario.agregarGuardarropas(ropaVerano);
        unUsuario.enviarRecomendacion(otroUsuario, new RecomendacionAgregar(ropaVerano, remeraVerano));

        Assert.assertEquals(1, otroUsuario.getMisRecomendacionesPendientes().size(), 0);
    }

//quiero que otro usuario me proponga tentativamente quitar una prenda del guardarropas
    @Test
    public void unUsuarioProponeQuitarUnaPrendaAOtroUsuario() {

        otroUsuario.agregarGuardarropas(ropaVerano);
        otroUsuario.agregarPendaAGuardarropa(ropaVerano, remeraVerano);
        Assert.assertEquals(0, otroUsuario.getMisRecomendacionesPendientes().size(), 0);

        unUsuario.enviarRecomendacion(otroUsuario, new RecomendacionQuitar(ropaVerano, remeraVerano));

        Assert.assertEquals(1, otroUsuario.getMisRecomendacionesPendientes().size(), 0);
    }

//necesito ver todas las propuestas de modificación (agregar o quitar prendas) del guardarropas
//y poder aceptarlas o rechazarlas..

    @Test
    public void puedoVerLasRecomendacionesPendientes() {
    usuarioConRecomendaciones.verRecomendacionesPendientes();
    }

    @Test
    public void puedoAceptarRecomendacion() {
        //Assert.assertEquals(0, usuarioConRecomendaciones.);
        usuarioConRecomendaciones.aceptarRecomendacion(recomendacionPantuflas);
    }

    @Test
    public void puedoRechazarRecomendacion() {
        //Assert.assertEquals(0, usuarioConRecomendaciones.);
        usuarioConRecomendaciones.rechazarRecomendacion(recomendacionPantuflas);
    }

//quiero poder deshacer las propuestas de modificación que haya aceptado
    @Test
    public void puedoDeshacerRecomendaciones() {
        usuarioConRecomendaciones.aceptarRecomendacion(recomendacionPantuflas);
        usuarioConRecomendaciones.deshacerUltimaRecomendacionAceptada();
    }

}
