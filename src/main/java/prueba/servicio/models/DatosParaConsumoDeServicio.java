package prueba.servicio.models;

public class DatosParaConsumoDeServicio {

  private final String nombre;
  private final String ocupacion;

  public DatosParaConsumoDeServicio(String nombre, String ocupacion) {
    this.nombre = nombre;
    this.ocupacion = ocupacion;
  }

  public String getNombre() {
    return nombre;
  }

  public String getOcupacion() {
    return ocupacion;
  }
}
