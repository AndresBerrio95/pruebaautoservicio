package prueba.servicio.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import prueba.servicio.questions.CodigoRespuesta;

public class AccionGeneralStepDefinition {

  @Before
  public void setTheStage() {
    OnStage.setTheStage(new OnlineCast());
  }

  private static final String urlBaseApi = "https://reqres.in";

  @Dado("que {} se conecta al servicio")
  public void queAndresSeConectaAlServicio(String actor) {
    theActorCalled(actor).whoCan(CallAnApi.at(urlBaseApi));
  }

  @Entonces("valida que el response para el metodo sea 200")
  public void validaQueElResponseParaElMetodoSea200() {
    theActorInTheSpotlight().should(GivenWhenThen.seeThat(CodigoRespuesta.es(),
        Matchers.equalTo(200)));
  }

  @Entonces("valida que el response para el metodo sea 201")
  public void validaQueElResponseParaElMetodoSea201() {
    theActorInTheSpotlight().should(GivenWhenThen.seeThat(CodigoRespuesta.es(),
        Matchers.equalTo(201)));
  }

}
