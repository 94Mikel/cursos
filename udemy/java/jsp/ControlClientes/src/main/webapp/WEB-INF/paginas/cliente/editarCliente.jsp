<%-- 
    Document   : clientes
    Created on : 3 jun 2024, 19:06:04
    Author     : mikel
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar clientes</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/e54a02fc17.js" crossorigin="anonymous"></script>

    </head>
    <body>

        <!-- Cabecero -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}"
              method="POST" class="was-validated">
            <!-- Botones de Navegacion -->
            <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cliente</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group row mb-3">
                                        <label class="col-sm-2 col-form-label" for="nombre">Nombre</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}"/>
                                        </div>
                                    </div>
                                    <div class="form-group row mb-3">
                                        <label class="col-sm-2 col-form-label" for="nombre">Apellido</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="apellido" required value="${cliente.apellido}"/>
                                        </div>
                                    </div>
                                    <div class="form-group row mb-3">
                                        <label class="col-sm-2 col-form-label" for="nombre">Email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" name="email" required value="${cliente.email}"/>
                                        </div>
                                    </div>
                                    <div class="form-group row mb-3">
                                        <label class="col-sm-2 col-form-label" for="nombre">Telefono</label>
                                        <div class="col-sm-10">
                                            <input type="tel" class="form-control" name="telefono" required value="${cliente.telefono}"/>
                                        </div>
                                    </div>
                                    <div class="form-group row mb-3">
                                        <label class="col-sm-2 col-form-label" for="nombre">Saldo</label>
                                        <div class="col-sm-10">
                                            <input type="number" class="form-control" name="saldo" required value="${cliente.saldo}" step="any"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form>


        <!--Pie de pagina-->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>

