package prueba.servicio.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import prueba.servicio.tasks.ConsumirServicioGet;
import prueba.servicio.tasks.ConsumirServicioEspecifico;

public class ValidacionDeServicioGetStepDefinition {

  @Cuando("consume el metodo Get para listar todos los usuarios")
  public void consumeServicioGetParaListarUsuarios() {
    theActorInTheSpotlight().attemptsTo(ConsumirServicioGet.metodoGet());
  }

  @Entonces("consulta la informacion de uno de ellos para validar los campos id {} y nombre del usuario {}")
  public void yValidaElIdYNombreDeUnUsuario(int id, String nombre) {
    theActorInTheSpotlight().attemptsTo(ConsumirServicioEspecifico.metodoGet());
    theActorInTheSpotlight().should(seeThatResponse("mensaje", response -> response.body("data.id", Matchers.equalTo(id))),
        seeThatResponse("mensaje", response -> response.body("data.first_name", Matchers.containsString(nombre))));
    SerenityRest.lastResponse().body().print();
  }
}
