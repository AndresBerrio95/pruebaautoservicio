package prueba.servicio.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.hamcrest.Matchers;
import prueba.servicio.models.DatosParaConsumoDeServicio;
import prueba.servicio.tasks.ConsumirServicioPost;

public class ValidacionDeServicioPostStepDefinition {
  DatosParaConsumoDeServicio datosParaConsumoDeServicio;

  @Cuando("consume el metodo Post para actualizar la informacion de un usuario de los campos nombre {} y ocupacion {}")
  public void consumeElMetodoPostParaActualizarLaInformacionDeUnUsuario(String nombre, String ocupacion) {
    datosParaConsumoDeServicio = new DatosParaConsumoDeServicio(nombre, ocupacion);
    theActorInTheSpotlight().attemptsTo(ConsumirServicioPost.metodoPost(datosParaConsumoDeServicio));
  }

  @Entonces("valida que el codigo de respuesta {} sea el corecto junto con los campos nombre y ocupacion")
  public void consultaLaInformacionDeUnoDeEellosParaValidarLosCamposNombreYOcupacion() {
    theActorInTheSpotlight().should(seeThatResponse("mensaje", response -> response.body("name", Matchers.containsString(datosParaConsumoDeServicio.getNombre()))),
        seeThatResponse("mensaje", response -> response.body("job", Matchers.containsString(datosParaConsumoDeServicio.getOcupacion()))));
  }
}
