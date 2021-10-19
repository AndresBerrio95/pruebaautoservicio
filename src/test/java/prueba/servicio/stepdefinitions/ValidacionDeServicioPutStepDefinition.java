package prueba.servicio.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.hamcrest.Matchers;
import prueba.servicio.models.DatosParaConsumoDeServicio;
import prueba.servicio.tasks.ConsumirServicioPut;

public class ValidacionDeServicioPutStepDefinition {

  DatosParaConsumoDeServicio datosParaConsumoDeServicio;

  @Cuando("consume el metodo Put para actualizar la informacion de un usuario de los campos nombre {} y ocupacion {}")
  public void consumeElMetodoPutParaActualizarLaInformacionDeUnUsuario(String nombre, String ocupacion) {
    datosParaConsumoDeServicio = new DatosParaConsumoDeServicio(nombre, ocupacion);
    theActorInTheSpotlight().attemptsTo(ConsumirServicioPut.metodoPut(datosParaConsumoDeServicio));
  }

  @Entonces("consulta la informacion de uno de ellos para validar los campos name y job")
  public void consultaLaInformacionDeUnoDeEellosParaValidarLosCamposNombreYOcupacion() {
    theActorInTheSpotlight().should(seeThatResponse("mensaje", response -> response.body("name", Matchers.containsString(datosParaConsumoDeServicio.getNombre()))),
        seeThatResponse("mensaje", response -> response.body("job", Matchers.containsString(datosParaConsumoDeServicio.getOcupacion()))));
  }
}
