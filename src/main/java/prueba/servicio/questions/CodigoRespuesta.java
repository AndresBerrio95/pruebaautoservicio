package prueba.servicio.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoRespuesta implements Question<Integer> {

  @Override
  public Integer answeredBy(Actor actor) {
    SerenityRest.lastResponse().body().print();
    return SerenityRest.lastResponse().getStatusCode();
  }

  public static Question<Integer> es(){
    return new CodigoRespuesta();
  }
}
