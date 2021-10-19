package prueba.servicio.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.json.simple.JSONObject;
import prueba.servicio.models.DatosParaConsumoDeServicio;

public class ConsumirServicioPost implements Task {
  private final DatosParaConsumoDeServicio datosParaConsumoDeServicio;

  public ConsumirServicioPost(DatosParaConsumoDeServicio datosParaConsumoDeServicio) {
    this.datosParaConsumoDeServicio = datosParaConsumoDeServicio;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    JSONObject json = new JSONObject();
    json.put("name", datosParaConsumoDeServicio.getNombre());
    json.put("job", datosParaConsumoDeServicio.getOcupacion());
    RestAssured.useRelaxedHTTPSValidation();
    actor.attemptsTo(Post.to("/api/users/").with(requestSpecification -> requestSpecification.contentType("application/json").body(json)));
  }

  public static ConsumirServicioPost metodoPost(DatosParaConsumoDeServicio datosParaConsumoServicio) {
    return instrumented(ConsumirServicioPost.class, datosParaConsumoServicio);
  }
}
