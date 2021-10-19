package prueba.servicio.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.json.simple.JSONObject;
import prueba.servicio.models.DatosParaConsumoDeServicio;

public class ConsumirServicioPut implements Task {
  private final DatosParaConsumoDeServicio datosParaConsumoDeServicio;

  public ConsumirServicioPut(DatosParaConsumoDeServicio datosParaConsumoDeServicio) {
    this.datosParaConsumoDeServicio = datosParaConsumoDeServicio;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    JSONObject json = new JSONObject();
    json.put("name", datosParaConsumoDeServicio.getNombre());
    json.put("job", datosParaConsumoDeServicio.getOcupacion());
    RestAssured.useRelaxedHTTPSValidation();
    actor.attemptsTo(Put.to("/api/users/7").with(requestSpecification -> requestSpecification.contentType("application/json").body(json)));
  }

  public static ConsumirServicioPut metodoPut(DatosParaConsumoDeServicio datosParaConsumoDeServicio) {
    return instrumented(ConsumirServicioPut.class, datosParaConsumoDeServicio);
  }
}
