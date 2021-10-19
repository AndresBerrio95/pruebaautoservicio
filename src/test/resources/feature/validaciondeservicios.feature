#language: es

Característica: Proceso de validacion de servicios pagina reqres.in.

  Como usuario de negocio
  Quiero probar algunos de los servicios que se van a consumir en dferentes procesos
  para garantizar la correcta ejecución de estos
  generando valor para los clientes del negocio.

  @metodoGetListUsers
    @rc
  Escenario: Ejecutar metodo Get para listar todos los usuarios registrados
    Dado que Andres se conecta al servicio
    Cuando consume el metodo Get para listar todos los usuarios
    Entonces valida que el response para el metodo sea 200
    Y consulta la informacion de uno de ellos para validar los campos id 7 y nombre del usuario Michael

  @metodoPutUpdate
    @rc
  Esquema del escenario: Ejecutar metodo Put para actualizar la información de nombre y trabajo de un usuario
    Dado que Andres se conecta al servicio
    Cuando consume el metodo Put para actualizar la informacion de un usuario de los campos nombre <nombre> y ocupacion <ocupacion>
    Entonces valida que el response para el metodo sea 200
    Y consulta la informacion de uno de ellos para validar los campos name y job
    Ejemplos:
    |nombre  |ocupacion|
    |Andres|Ingeniero|

  @metodoPostCreate
    @rc
  Esquema del escenario: Ejecutar metodo Post para actualizar la informacion de un usuario para los campos nombre y ocupacion
    Dado que Andres se conecta al servicio
    Cuando consume el metodo Post para actualizar la informacion de un usuario de los campos nombre <nombre> y ocupacion <ocupacion>
    Entonces valida que el response para el metodo sea 201
    Ejemplos:
      |nombre |ocupacion    |
      |Stiven |Independiente|