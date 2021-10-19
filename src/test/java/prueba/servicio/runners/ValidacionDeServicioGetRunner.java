package prueba.servicio.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/feature/validaciondeservicios.feature",
    glue = "prueba.servicio.stepdefinitions",
    tags = "@rc",
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ValidacionDeServicioGetRunner {
}
