package prueba.servicio.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsumirServicioGet implements Task {

  @Override
  public <T extends Actor> void performAs(T actor) {
    RestAssured.useRelaxedHTTPSValidation();
    actor.attemptsTo(Get.resource("/api/users/"));
  }

  public static ConsumirServicioGet metodoGet() {
    return instrumented(ConsumirServicioGet.class);
  }
}
